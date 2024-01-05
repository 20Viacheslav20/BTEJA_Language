
using Antlr4.Runtime;
using Language.Models.DataTypes;

namespace Language.Models.SymbolsInfo
{
    public class VariableSymbolInfo : ISymbolInfo
    {
        public DataType DataType { get; }

        public VariableSymbolInfo(string name, DataType dataType, ParserRuleContext context)
            : base(name, SymbolType.VARIABLE, context)
        {
            DataType = dataType;
        }
    }
}
