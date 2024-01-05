using Antlr4.Runtime;

namespace Language.Models
{
    public class CompilationError
    {
        public string Message { get; }

        public ParserRuleContext Context { get; set; }

        public CompilationError(string message, ParserRuleContext context)
        {
            Message = message;
            Context = context;
        }

        public override string ToString()
        {
            return $"{Message} at line {Context.Start.Line}, column {Context.Start.Column}";
        }
    }
}
