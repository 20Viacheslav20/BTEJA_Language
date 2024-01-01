
using Antlr4.Runtime.Tree;
using Antlr4.Runtime;
using Language;

class Program
{
    public static void Main(string[] args)
    {
        string input = 
@"MODULE mod;
    VARIABLES somevalue : INT;
START
    somevalue := 45;
END mod.";

        ICharStream stream = CharStreams.fromString(input);

        ITokenSource lexer = new MyLanguageGrammarLexer(stream);

        ITokenStream tokens = new CommonTokenStream(lexer);

        MyLanguageGrammarParser parser = new MyLanguageGrammarParser(tokens);

        IParseTree tree = parser.start();
        Visitor visitor = new Visitor();
        var a = visitor.Visit(tree);

        Console.WriteLine(a);

        var ab = 5;
    }
}