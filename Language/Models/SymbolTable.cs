using Language.Models.SymbolsInfo;
using static System.Formats.Asn1.AsnWriter;

namespace Language.Models
{
    public class SymbolTable
    {
        private Stack<Dictionary<string, ISymbolInfo>> scopes;

        public SymbolTable()
        {
            scopes = new Stack<Dictionary<string, ISymbolInfo>>();
        }

        public void EnterScope()
        {
            scopes.Push(new Dictionary<string, ISymbolInfo>());
        }

        public void ExitScope()
        {
            scopes.Pop();
        }

        public void AddSymbol(string name, ISymbolInfo symbolInfo)
        {
            if (scopes.Count > 0)
            {
                scopes.Peek()[name] = symbolInfo;
            }
        }

        public ISymbolInfo GetSymbol(string name)
        {
            foreach (var scope in scopes)
            {
                if (scope.TryGetValue(name, out var symbol))
                {
                    return symbol;
                }
            }

            return null;
        }

        public Dictionary<string, ISymbolInfo> GetCurrentScope()
        {
            if (scopes.Count > 0)
            {
                return scopes.Peek();
            }

            return null;
        }
    }
}
