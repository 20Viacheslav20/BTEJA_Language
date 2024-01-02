
using Antlr4.Runtime.Tree;
using Antlr4.Runtime;
using Language.AstAnalysis;

class Program
{
    public static void Main(string[] args)
    {
        string input =
@"MODULE mod;
VARIABLES 
    somevalue : INT;
START
    somevalue :=  45 + 8 < 9 + 5;
END mod.";

        ICharStream stream = CharStreams.fromString(input);

        ITokenSource lexer = new MyLanguageGrammarLexer(stream);

        ITokenStream tokens = new CommonTokenStream(lexer);

        MyLanguageGrammarParser parser = new MyLanguageGrammarParser(tokens);

        IParseTree tree = parser.start();
        AstVisitor visitor = new AstVisitor();
        visitor.Visit(tree);
    }
}