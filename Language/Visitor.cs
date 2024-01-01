using Antlr4.Runtime.Misc;


namespace Language
{
    public class Visitor: MyLanguageGrammarBaseVisitor<object> 
    {
        public override object VisitModule([NotNull] MyLanguageGrammarParser.ModuleContext context)
        {
            var name = context.IDENT_L().GetText();
            Console.WriteLine($"Visiting Module: {name}");
            return base.VisitModule(context);
        }
    }
}
