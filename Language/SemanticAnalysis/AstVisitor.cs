using Antlr4.Runtime.Misc;
using Language.Models;
using Language.Models.DataTypes;
using Language.Models.SymbolsInfo;

namespace Language.AstAnalysis
{
    public class AstVisitor : MyLanguageGrammarBaseVisitor<object?>
    {
        public SymbolTable symbolTable;
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

            //symbolTable.ExitScope();

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
            }
            return DataType.BOOL;
        }

        public override object? VisitSimpleExpression([NotNull] MyLanguageGrammarParser.SimpleExpressionContext context)
        {
            if (context.term().Length == 0)
            {
                errors.Add(new CompilationError($"The value is null", context));
                return null;
            } else
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

            errors.Add(new CompilationError("Unrecognized literal type", context));
            return null;
        }

        public override object? VisitProcedureCall([NotNull] MyLanguageGrammarParser.ProcedureCallContext context)
        {
            var procedureName = context.IDENT_L().GetText();

            ISymbolInfo procedureInfo = symbolTable.GetSymbol(procedureName);

            if (procedureInfo == null)
            {
                errors.Add(new CompilationError($"Procedure '{procedureName}' is not declared", context));
            }
            else
            {
                if (procedureInfo is not ProcedureSymbolInfo)
                {
                    errors.Add(new CompilationError($"Symbol '{procedureName}' is not a subprogram or not declared", context));
                }
                var procedure = (ProcedureSymbolInfo) procedureInfo;

                if (context.expression().Length != procedure.Parameters.Count)
                {
                    errors.Add(new CompilationError($"Exprected {procedure.Parameters.Count} parametrs but {context.expression().Length} was stated", context));
                }

                for (int i = 0; i < context.expression().Length; i++)
                {
                    var exp = VisitExpression(context.expression()[i]);

                    var prParam = procedure.Parameters.ElementAt(i).DataType;

                    if (prParam != exp)
                    {
                        errors.Add(new CompilationError($"Expected {prParam} but was {exp} at position {i + 1}", context));
                    }

                }
            }

            return null;
        }

        public override object? VisitProcedure([NotNull] MyLanguageGrammarParser.ProcedureContext context)
        {
            symbolTable.EnterScope();
            VisitProcedureDeclaration(context.procedureDeclaration());
            var variablesDeclarationBlock = context.variablesDeclarationBlock();
            if (variablesDeclarationBlock != null)
            {
                VisitVariablesDeclarationBlock(variablesDeclarationBlock);
            }
            VisitProcedureBody(context.procedureBody());
            return null;
        }

        public override object? VisitProcedureDeclaration([NotNull] MyLanguageGrammarParser.ProcedureDeclarationContext context)
        {
            var name = context.IDENT_L().GetText();

            if (symbolTable.GetSymbol(name) != null)
            {
                errors.Add(new CompilationError($"Procedure '{name}' is already declared.", context));
                return null;
            }

            ProcedureSymbolInfo procedureSymbolInfo = new ProcedureSymbolInfo(name, null, null, context);
            if (context.type() == null)
            {
                procedureSymbolInfo.ReturnType = DataType.VOID;
                symbolTable.AddSymbol(name, procedureSymbolInfo);
            } else
            {
                var typ = VisitType(context.type());
                if (typ is CompilationError compilationError)
                {
                    errors.Add(compilationError);
                } else
                {
                    if (typ is DataType dataType)
                    {
                        procedureSymbolInfo.ReturnType = dataType;
                        symbolTable.AddSymbol(name, procedureSymbolInfo);
                    }
                }
            }

            var parameters = context.procedureParameters()?.variablesDeclaration();
            if (parameters != null)
            {
                var parameterList = new List<VariableSymbolInfo>();
                foreach (var parameter in parameters)
                {
                    foreach(var param in parameter.IDENT_L())
                    {
                        var parameterType = VisitType(parameter.type());
                        if (parameterType is CompilationError compilationError1)
                        {
                            errors.Add(compilationError1);
                        } else
                        {
                            var parameterInfo = new VariableSymbolInfo(param.GetText(), (DataType) parameterType, parameter);
                            parameterList.Add(parameterInfo);
                            symbolTable.AddSymbol(param.GetText(), parameterInfo);
                        }
                    }
                }

                procedureSymbolInfo.Parameters = parameterList;
            }

            return null;
        }

        public override object? VisitIfStatement([NotNull] MyLanguageGrammarParser.IfStatementContext context)
        {
            var expression = VisitExpression(context.expression());

            if (expression != null && expression is DataType dataType && dataType != DataType.BOOL)
            {
                errors.Add(new CompilationError($"If statement condition must be of type BOOL, but found {dataType}.", context));
                return null;
            }

            VisitChildren(context);
            return null;
        }

        public override object? VisitElseIfStatement([NotNull] MyLanguageGrammarParser.ElseIfStatementContext context)
        {
            var expression = VisitExpression(context.expression());

            if (expression != null && expression is DataType dataType && dataType != DataType.BOOL)
            {
                errors.Add(new CompilationError($"Else If statement condition must be of type BOOL, but found {dataType}.", context));
                return null;
            }

            VisitChildren(context);
            return null;
        }

        public override object? VisitReturnStatement([NotNull] MyLanguageGrammarParser.ReturnStatementContext context)
        {
            var expression = VisitExpression(context.expression());

            var currentProcedure = symbolTable.GetCurrentScope();

            var procedureInfo = currentProcedure.Values.First() as ProcedureSymbolInfo;

            var expectedReturnType = procedureInfo.ReturnType;
            if (expression is not DataType dataType)
            {
                var symbol = symbolTable.GetSymbol((string)expression);

                if (symbol == null)
                {
                    errors.Add(new CompilationError($"Symbol '{expression}' is not declared", context));
                    return null;
                }

                if (procedureInfo != null)
                {

                    // Check if the returned expression type matches the expected return type of the current procedure
                    if (symbol is VariableSymbolInfo symbolInfo && symbolInfo.DataType != expectedReturnType)
                    {
                        errors.Add(new CompilationError($"Return statement type '{symbolInfo.DataType}' does not match the expected return type '{expectedReturnType}'.", context));
                    }
                }
                else
                {
                    errors.Add(new CompilationError($"Return can used only in procedures", context));
                }

            } else
            {
                if (expression != null && expression != expectedReturnType) 
                {
                    errors.Add(new CompilationError($"Return statement type '{expression}' does not match the expected return type '{expectedReturnType}'.", context));
                }
            }


            return null;
        }

        public override object? VisitWhileStatement([NotNull] MyLanguageGrammarParser.WhileStatementContext context)
        {
            var expression = VisitExpression(context.expression());

            if (expression != null && expression is DataType dataType && dataType != DataType.BOOL)
            {
                errors.Add(new CompilationError($"While statement condition must be of type BOOL, but found {dataType}.", context));
                return null;
            }

            VisitChildren(context);
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

    }
}
