
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

        var programsSources = new[]
        {
            "Programs/testMod.txt",
            "Programs/Discriminant.txt",
            "Programs/Factorial.txt",
        };

        foreach (string program in programsSources) 
        {
            string path = $"../../../{program}";
            var inputStream = new AntlrFileStream(path);

            ITokenSource lexer = new MyLanguageGrammarLexer(inputStream);

            ITokenStream tokens = new CommonTokenStream(lexer);

            MyLanguageGrammarParser parser = new MyLanguageGrammarParser(tokens);

            IParseTree tree = parser.start();
            AstVisitor visitor = new AstVisitor();
            visitor.Visit(tree);

            if (visitor.Errors.Any())
            {
                foreach (CompilationError compilationError in visitor.Errors)
                {
                    Console.WriteLine(compilationError);
                }
            } else
            {
                IrGenerator irGenerator = new IrGenerator(visitor.symbolTable);
                irGenerator.Visit(tree);
                irGenerator.Module.Dump();

                try
                {
                    var llFile = path + ".ll";

                    irGenerator.Module.PrintToFile(llFile);

                    var llcStartInfo = new ProcessStartInfo
                    {
                        FileName = "clang",
                        Arguments = $"{llFile} -Wno-override-module -llegacy_stdio_definitions -o {path}.exe",
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

                    Console.WriteLine($"Output file: {path}.exe");
                }
                catch (Exception ex)
                {
                    Console.WriteLine($"An error occurred: {ex.Message}");
                }
            }
        }
    }
}