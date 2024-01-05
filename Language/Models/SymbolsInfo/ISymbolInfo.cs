
using Antlr4.Runtime;

namespace Language.Models.SymbolsInfo
{
    public class ISymbolInfo
    {
        public ParserRuleContext Context { get; set; }
        public string Name { get; }
        public SymbolType Type { get; }

        public ISymbolInfo(string name, SymbolType type, ParserRuleContext context)
        {
            Name = name;
            Type = type;
            Context = context;
        }
    }
}
