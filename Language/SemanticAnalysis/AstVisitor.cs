using Antlr4.Runtime.Misc;
using Language.Models;

namespace Language.AstAnalysis
{
    public class AstVisitor : MyLanguageGrammarBaseVisitor<object?>
    {
        public override object? VisitModule([NotNull] MyLanguageGrammarParser.ModuleContext context)
        {
            var name = context.IDENT_L().GetText();
            Console.WriteLine($"Visiting Module: {name}");
            var moduleStatements = context.moduleStatements();
            if (moduleStatements != null)
            {
                base.VisitModuleStatements(moduleStatements);
            }
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

            if (context.ARRAY() is not null)
            {
                int arraySize = int.Parse(context.INT_L().GetText());
                var elementType = VisitType(context.type());
                return DataType.Array((DataType) elementType, arraySize);
            }

            return null;
        }

        public override object? VisitVariablesDeclaration([NotNull] MyLanguageGrammarParser.VariablesDeclarationContext context)
        {
            var variablesNames = context.IDENT_L();
            var variableType = VisitType(context.type());

            foreach (var variableName in variablesNames)
            {
                Console.WriteLine($"{variableName} - {variableType}");
            }
            return null;
        }

        public override object VisitAssignment([NotNull] MyLanguageGrammarParser.AssignmentContext context)
        {
            var name = context.IDENT_L().GetText(); // TODO need to save all variables and check if his type is
                                                    // equals with expression return type
            var expression = VisitExpression(context.expression());
            Console.WriteLine($"{name} {expression}");

            return null;
        }

        public override object VisitExpression([NotNull] MyLanguageGrammarParser.ExpressionContext context)
        {
            if (context.simpleExpression().Count() == 1) // expression with only simpleExpression (equals)
            {
                Console.WriteLine($"Visiting simple expression");
                return VisitSimpleExpression(context.simpleExpression()[0]);
            }
            else // expression with relation 
            {
                Console.WriteLine($"Visiting relation");
                var left = VisitSimpleExpression(context.simpleExpression()[0]);

                var right = VisitSimpleExpression(context.simpleExpression()[1]);

                if (left == null || right == null || left != right )
                {
                    Console.WriteLine("Error");
                }

                var relation = context.relation().GetText();
                Console.WriteLine(relation);

                var a = 45;

            }
            return null;
        }

        public override object VisitSimpleExpression([NotNull] MyLanguageGrammarParser.SimpleExpressionContext context)
        {
            var term = VisitTerm(context.term()[0]);

            if (context.plusMinus() != null)
            {
                Console.WriteLine(context.plusMinus().GetText());
            }

            if (context.addOperator().Count() > 0)
            {
                Console.WriteLine(context.addOperator()[0].GetText());
            }

            return term;
        }

        public override object VisitTerm([NotNull] MyLanguageGrammarParser.TermContext context)
        {
            
            return VisitFactor(context.factor()[0]);
        }

        public override object VisitFactor([NotNull] MyLanguageGrammarParser.FactorContext context)
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
                var a = context.IDENT_L().GetText();
                var aa = 45;
            }

            if (context.literal() != null)
            {
                return Visit(context.literal());
            }

            return null;
        }

        public override object VisitLiteral([NotNull] MyLanguageGrammarParser.LiteralContext context)
        {
            //Console.WriteLine(context.INT_L().GetText());
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

            return null;
        }
    }
}
