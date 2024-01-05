using Antlr4.Runtime;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Language.Models.SymbolsInfo
{
    public class ModuleInfo : ISymbolInfo
    {
        public ModuleInfo(string name, SymbolType type, ParserRuleContext context)
            : base(name, type, context)
        {
        }
    }
}
