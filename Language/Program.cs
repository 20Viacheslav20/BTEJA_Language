
using Antlr4.Runtime.Tree;
using Antlr4.Runtime;
using Language.AstAnalysis;
using Language.Models;
using Language.IrGenerator;
using System.Diagnostics;

class Program
{
    public static void Main(string[] args)
    {
        Trace.Listeners.Add(new ConsoleTraceListener());

        var programSources = new[]
        {
            "Programs/testMod.txt",
            "Programs/Discriminant.txt",
            "Programs/Factorial.txt",
        };

        foreach (string program in programSources)
        {
            Console.WriteLine($"\nProgram --> {program}");
            CompileProgram(program);
        }
    }

    private static void CompileProgram(string programPath)
    {
        //try
        //{
            string fullPath = Path.Combine("../../../", programPath);
            var inputStream = new AntlrFileStream(fullPath);

            var lexer = new MyLanguageGrammarLexer(inputStream);
            var tokens = new CommonTokenStream(lexer);

            var parser = new MyLanguageGrammarParser(tokens);
            IParseTree tree = parser.start();

            AstVisitor visitor = new AstVisitor();
            visitor.Visit(tree);

            if (visitor.Errors.Any())
            {
                Console.WriteLine("Analysis erros: \n");
                foreach (CompilationError compilationError in visitor.Errors)
                {
                    Console.WriteLine(compilationError);
                }
            }
            else
            {
                Console.WriteLine("Analysis done \n");
                IrGenerator irGenerator = new IrGenerator(visitor.symbolTable);
                irGenerator.Visit(tree);
                irGenerator.Module.Dump();

                CompileIR(fullPath, irGenerator);
            }
        //}
        //catch (Exception ex)
        //{
        //    Console.WriteLine($"An error occurred: {ex.Message}");
        //}
    }

    private static void CompileIR(string sourcePath, IrGenerator irGenerator)
    {
        try
        {
            var llFile = sourcePath + ".ll";
            irGenerator.Module.PrintToFile(llFile);

            var llcStartInfo = new ProcessStartInfo
            {
                FileName = "clang",
                Arguments = $"{llFile} -Wno-override-module -llegacy_stdio_definitions -o {sourcePath}.exe",
                UseShellExecute = false,
                RedirectStandardOutput = true,
                RedirectStandardError = true
            };

            using var llcProcess = Process.Start(llcStartInfo);

            if (llcProcess == null)
            {
                Console.WriteLine("Failed to start clang");
                return;
            }

            llcProcess.WaitForExit();

            var llcOutput = llcProcess.StandardOutput.ReadToEnd();
            var llcError = llcProcess.StandardError.ReadToEnd();

            if (!string.IsNullOrEmpty(llcError))
            {
                Console.WriteLine("Errors: \n" + llcError);
                return;
            }

            Console.WriteLine($"Output file: {sourcePath}.exe");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"An error occurred: {ex.Message}");
        }
    }
}