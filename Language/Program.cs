
using Antlr4.Runtime.Tree;
using Antlr4.Runtime;
using Language.AstAnalysis;
using Language.Models;

class Program
{
    public static void Main(string[] args)
    {
        List<string> programs = ReadFile();

        int i = 0; // todo remove it

        foreach (string program in programs) 
        {
            // todo remove it
            i++;
            if (i != 3) continue;
            ICharStream stream = CharStreams.fromString(program);

            ITokenSource lexer = new MyLanguageGrammarLexer(stream);

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
            }
        }
    }

    public static List<string> ReadFile()
    {
        string filePath = "../../../Programs/programs.txt";
        List<string> programs = new List<string>();
        try
        {
            using (StreamReader reader = new StreamReader(filePath))
            {
                string content = reader.ReadToEnd();
                programs = content.Split("--------------------------------------------------------------")
                                  .Select(x => x.Trim())
                                  .ToList();              
            }
        }
        catch (FileNotFoundException)
        {
            Console.WriteLine($"File not found: {filePath}");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"An error occurred: {ex.Message}");
        }
        return programs;
    }
}