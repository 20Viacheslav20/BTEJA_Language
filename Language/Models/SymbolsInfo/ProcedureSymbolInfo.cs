
using Antlr4.Runtime;
using Language.Models.DataTypes;

namespace Language.Models.SymbolsInfo
{
    public class ProcedureSymbolInfo : ISymbolInfo
    {
        public DataType ReturnType { get; set; }
        public List<VariableSymbolInfo>? Parameters { get; set; }

        public ProcedureSymbolInfo(string name, DataType returnType, List<VariableSymbolInfo>? parameters, ParserRuleContext context)
            : base(name, SymbolType.PROCEDURE, context)
        {
            ReturnType = returnType;
            Parameters = parameters;
        }
    }
}
