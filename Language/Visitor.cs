using Antlr4.Runtime.Misc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Language
{
    public class Visitor: MyLanguageGrammarBaseVisitor<object?> 
    {
        public override object VisitModule([NotNull] MyLanguageGrammarParser.ModuleContext context)
        {
            var a = context.qualifiedIdent().IDENT_L();
            return base.VisitModule(context);
        }
    }
}
