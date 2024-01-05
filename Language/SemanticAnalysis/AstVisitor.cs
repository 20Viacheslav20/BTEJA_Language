using Antlr4.Runtime.Misc;
using Language.Models;
using Language.Models.DataTypes;
using Language.Models.SymbolsInfo;

namespace Language.AstAnalysis
{
    public class AstVisitor : MyLanguageGrammarBaseVisitor<object?>
    {
        private SymbolTable symbolTable;
        public IEnumerable<CompilationError> Errors => errors;

        private List<CompilationError> errors;

        public AstVisitor()
        {
            symbolTable = new SymbolTable();
            errors = new List<CompilationError>();
        }

        public override object? VisitModule([NotNull] MyLanguageGrammarParser.ModuleContext context)
        {
            symbolTable.EnterScope();
            var name = context.IDENT_L().GetText();

            ModuleInfo moduleInfo = new ModuleInfo(name, SymbolType.MODULE, context);
            symbolTable.AddSymbol(name, moduleInfo);

            var moduleStatements = context.moduleStatements();
            if (moduleStatements != null)
            {
                base.VisitModuleStatements(moduleStatements);
            }

            symbolTable.ExitScope();

            return null;
        }

        public override object? VisitVariablesDeclarationBlock([NotNull] MyLanguageGrammarParser.VariablesDeclarationBlockContext context)
        {
            foreach (var variables in context.variablesDeclaration())
            {
                VisitVariablesDeclaration(variables);
            }

            return null;
        }

        public override object? VisitVariablesDeclaration([NotNull] MyLanguageGrammarParser.VariablesDeclarationContext context)
        {
            var variablesNames = context.IDENT_L();
            var variableType = VisitType(context.type());

            if (variableType is CompilationError) // incorrect type or null
            {
                errors.Add((CompilationError)variableType);
            }

            foreach (var variableName in variablesNames)
            {
                if (symbolTable.GetSymbol(variableName.GetText()) != null)
                {
                    errors.Add(new CompilationError($"Variable '{variableName}' is already declared", context));
                } else
                {
                    VariableSymbolInfo variableSymbolInfo = new VariableSymbolInfo(variableName.GetText(), (DataType)variableType, context);
                    symbolTable.AddSymbol(variableName.GetText(), variableSymbolInfo);
                }
            }
            return null;
        }


        public override object? VisitType([NotNull] MyLanguageGrammarParser.TypeContext context)
        {
            if (context.INT() is not null)
            {
                return DataType.INT;
            }

            if (context.REAL() is not null)
            {
                return DataType.REAL;
            }

            if (context.STR() is not null)
            {
                return DataType.STR;
            }

            if (context.BOOL() is not null)
            {
                return DataType.BOOL;
            }

            if (context.ARRAY() is not null)
            {
                int arraySize = 0;
                if (context.INT_L() is null)
                {
                    return new CompilationError("Array size is missing or not an integer", context);
                }
                else if (!int.TryParse(context.INT_L().GetText(), out arraySize))
                {
                    return new CompilationError("Array size is not a valid integer", context);
                }

                var elementType = VisitType(context.type());

                if (elementType is CompilationError)
                {
                    CompilationError elementError = (CompilationError)elementType;
                    return new CompilationError($"Error in array element type: {elementError.Message}", elementError.Context);
                }
                else if (elementType == null)
                {
                    return new CompilationError("Array element type is not defined", context);
                }
                else
                {
                    return DataType.Array((DataType)elementType, arraySize);
                }
            }

            return new CompilationError("Unable to determine the data type", context);
        }


        public override object? VisitAssignment([NotNull] MyLanguageGrammarParser.AssignmentContext context)
        {
            var variableName = context.IDENT_L().GetText();

            ISymbolInfo variableInfo = symbolTable.GetSymbol(variableName);

            if (variableInfo == null)
            {
                errors.Add(new CompilationError($"Variable '{variableName}' is not declared", context));
            }

            var expression = VisitExpression(context.expression());

            if (expression != null && expression is DataType dataType && variableInfo is VariableSymbolInfo variableSymbolInfo)
            {
                // Checking for type matching
                if (dataType != variableSymbolInfo.DataType)
                {
                    errors.Add(new CompilationError($"Can't assign {dataType} to variable of type {variableSymbolInfo.DataType}", context));
                }
            }

            return null;
        }

        public override object? VisitExpression([NotNull] MyLanguageGrammarParser.ExpressionContext context)
        {
            if (context.simpleExpression().Count() == 1) // expression with only simpleExpression (equals)
            {
                return VisitSimpleExpression(context.simpleExpression()[0]);
            }
            else // expression with relation ( '=', '<', '<=', '>', '>=')
            {

                var relation = context.relation().GetText();

                var left = VisitSimpleExpression(context.simpleExpression()[0]);

                if (left == null)
                {
                    errors.Add(new CompilationError($"Left expression is null", context));
                    return null;
                }

                var right = VisitSimpleExpression(context.simpleExpression()[1]);

                if (right == null)
                {
                    errors.Add(new CompilationError($"Right expression is null", context));
                    return null;
                }

                if (left != right)
                {
                    errors.Add(new CompilationError($"Can't compare {left} with {right} using {relation}", context));
                    return null;
                }

                return left;
            }
        }

        public override object? VisitSimpleExpression([NotNull] MyLanguageGrammarParser.SimpleExpressionContext context)
        {
            var term = VisitTerm(context.term()[0]);

            var plusMinus = context.plusMinus()?.GetText();
            
            if (context.term().Length == 1)
            {
                if (plusMinus is not null && (term == DataType.BOOL || term == DataType.STR))
                {
                    errors.Add(new CompilationError($"Can't perform {plusMinus} to {term}", context));
                }
                return term;
            }

            var addOperator = context.addOperator(0).GetText();
            if ((addOperator != "OR" && (term == DataType.BOOL || term == DataType.STR)) ||
                (addOperator == "OR" && term != DataType.BOOL))
            {
                errors.Add(new CompilationError($"Can't perform {addOperator} on {term}", context));
                return term;
            }

            for (var i = 1; i < context.term().Length; i++)
            {
                var rightType = VisitTerm(context.term()[i]);

                if (term != rightType)
                {
                    errors.Add(new CompilationError($"Can't perform this operation on {rightType}", context));
                }
            }

            return term;
        }

        public override object? VisitTerm([NotNull] MyLanguageGrammarParser.TermContext context)
        {
            var factor = VisitFactor(context.factor()[0]);

            if (context.factor().Length == 1)
            {
                return factor;
            }

            var mulOperator = context.mulOperator(0).GetText();

            if (factor == DataType.BOOL || factor == DataType.STR)
            {
                errors.Add(new CompilationError($"Cannot perform operation ({mulOperator}) on {factor}", context));
                return factor;
            }


            for (var i = 1; i < context.factor().Length; i++)
            {
                var newFactor = VisitFactor(context.factor()[i]);

                if (factor != newFactor)
                {
                    errors.Add(new CompilationError($"Cannot perform this operation on {factor} and {newFactor}", context));
                    return factor;
                }
            }

            return factor;
        }

        public override object? VisitFactor([NotNull] MyLanguageGrammarParser.FactorContext context)
        {
            if (context.factor() != null)
            {
                return VisitFactor(context.factor());
            }

            if (context.expression() != null)
            {
                return VisitExpression(context.expression());
            }

            if (context.procedureCall() != null)
            {
                return VisitProcedureCall(context.procedureCall());
            }

            if (context.IDENT_L() != null)
            {
                return context.IDENT_L().GetText();
            }

            if (context.literal() != null)
            {
                return VisitLiteral(context.literal());
            }

            return null;
        }

        public override object? VisitLiteral([NotNull] MyLanguageGrammarParser.LiteralContext context)
        {
            if (context.REAL_L() != null)
            {
                return DataType.REAL;
            }

            if (context.INT_L() != null)
            {
                return DataType.INT;
            }

            if (context.STR_L() != null)
            {
                return DataType.STR;
            }

            if (context.BOOL_L() is not null)
            {
                return DataType.BOOL;
            }

            return new CompilationError("Incorrect type", context); ;
        }

        public override object? VisitProcedureCall([NotNull] MyLanguageGrammarParser.ProcedureCallContext context)
        {
            var procedureName = context.IDENT_L().GetText();

            ISymbolInfo procedureInfo = symbolTable.GetSymbol(procedureName);

            if (procedureInfo == null)
            {
                errors.Add(new CompilationError($"Procedure '{procedureName}' is not declared.", context));
            }
            else
            {
                var a = 5;
            }

            return null;
        }
    }
}
