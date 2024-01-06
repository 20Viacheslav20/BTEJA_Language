using Antlr4.Runtime.Misc;
using Language.Models;
using Language.Models.DataTypes;
using Language.Models.SymbolsInfo;
using LLVMSharp.Interop;
using static MyLanguageGrammarParser;

namespace Language.IrGenerator
{
    public class IrGenerator : MyLanguageGrammarBaseVisitor<object?>
    {
        public LLVMModuleRef Module;

        private LLVMBuilderRef builder;
        private SymbolTable symbolTable;

        public IrGenerator(SymbolTable symbolTable)
        {
            this.symbolTable = symbolTable;
        }

        public override object? VisitModule([NotNull] MyLanguageGrammarParser.ModuleContext context)
        {
            var moduleInfo = symbolTable.GetSymbol(context.IDENT_L().GetText());

            Module = LLVMModuleRef.CreateWithName(moduleInfo.Name);
            Module.Target = LLVMTargetRef.DefaultTriple;

            builder = Module.Context.CreateBuilder();

            VisitModuleStatements(context.moduleStatements());
            return null;
        }

        public override object? VisitModuleStatements([NotNull] MyLanguageGrammarParser.ModuleStatementsContext context)
        {
            VisitVariablesDeclarationBlock(context.variablesDeclarationBlock());

            foreach (var procedure in context.procedure())
            {
                VisitProcedure(procedure);
            }

            var mainFunctionType = LLVMTypeRef.CreateFunction(LLVMTypeRef.Void, Array.Empty<LLVMTypeRef>());
            var mainFunction = Module.AddFunction("main", mainFunctionType);
            var entryBlock = mainFunction.AppendBasicBlock("entry");

            builder.PositionAtEnd(entryBlock);

            VisitProcedureBody(context.procedureBody());

            AddVoidReturn(mainFunction);

            return null;
        }

        private void AddVoidReturn(LLVMValueRef function)
        {
            var lastInstruction = function.LastBasicBlock.LastInstruction;

            if (lastInstruction == null || lastInstruction.InstructionOpcode != LLVMOpcode.LLVMRet)
            {
                builder.BuildRetVoid();
            }
        }

        public override object VisitProcedure([NotNull] MyLanguageGrammarParser.ProcedureContext context)
        {
            var a = context.procedureDeclaration().IDENT_L().GetText();
            var procedureInfo = symbolTable.GetSymbol(context.procedureDeclaration().IDENT_L().GetText()) as ProcedureSymbolInfo;

            if (procedureInfo != null)
            {
                bool isVoid = true;
                // Create a type for the procedure function
                var returnType = LLVMTypeRef.Void; //  For a procedure with return type void
                if (procedureInfo.ReturnType != DataType.VOID)
                {
                    returnType = GetLLVMType(procedureInfo.ReturnType);
                    isVoid = false;
                }

                var parameterTypes = procedureInfo.Parameters?.Select(param => GetLLVMType(param.DataType)).ToArray()
                                     ?? Array.Empty<LLVMTypeRef>();

                var procedureType = LLVMTypeRef.CreateFunction(returnType, parameterTypes);

                var procedureFunction = Module.AddFunction(procedureInfo.Name, procedureType);


                var entryBlock = procedureFunction.AppendBasicBlock("entry");

                builder.PositionAtEnd(entryBlock);

                context.procedureBody().Accept(this);

                if (isVoid)
                    AddVoidReturn(procedureFunction);

            }

            return null;
        }

        public override object VisitVariablesDeclarationBlock([NotNull] MyLanguageGrammarParser.VariablesDeclarationBlockContext context)
        {
/*            foreach(var variableDeclarationContext in context.variablesDeclaration())
            {
                foreach (var variable in symbolTable.GetSymbol(variableDeclarationContext.)
                {
                    var llvmType = variable.DataType.ToLlvmType();

                    builder.BuildAlloca(llvmType, variable.Name);
                }
            }*/
            return null;
        }

        public override object? VisitIfStatement([NotNull] IfStatementContext context)
        {
            return base.VisitIfStatement(context);
        }

        public override object? VisitWhileStatement([NotNull] WhileStatementContext context)
        {
            return base.VisitWhileStatement(context);
        }

        public override object? VisitReturnStatement([NotNull] ReturnStatementContext context)
        {
            return base.VisitReturnStatement(context);
        }

        public override object? VisitAssignment([NotNull] AssignmentContext context)
        {
            return base.VisitAssignment(context);
        }

        public override object? VisitExpression([NotNull] ExpressionContext context)
        {
            return base.VisitExpression(context);
        }

        public override object? VisitSimpleExpression([NotNull] SimpleExpressionContext context)
        {
            return base.VisitSimpleExpression(context);
        }

        public override object? VisitTerm([NotNull] TermContext context)
        {
            return base.VisitTerm(context);
        }

        public override object? VisitProcedureCall([NotNull] ProcedureCallContext context)
        {
            return base.VisitProcedureCall(context);
        }

        public override object? VisitLiteral([NotNull] LiteralContext context)
        {
            return base.VisitLiteral(context);
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

        private LLVMTypeRef GetLLVMType(DataType dataType)
        {
            if (dataType == DataType.INT)
            {
                return LLVMTypeRef.Int32;
            }
            else if (dataType == DataType.REAL)
            {
                return LLVMTypeRef.Double;
            }
            else if (dataType == DataType.BOOL)
            {
                return LLVMTypeRef.Int1;
            }
            else if (dataType == DataType.VOID)
            {
                return LLVMTypeRef.Void;
            }
            else if (dataType.IsArray(out var arrayElementType))
            {
                var elementType = GetLLVMType(arrayElementType.Type);

                return LLVMTypeRef.CreateArray(elementType, (uint) arrayElementType.Size);
            }
            else if (dataType == DataType.STR)
            {
                return LLVMTypeRef.CreatePointer(LLVMTypeRef.Int8, 0);
            }
            throw new NotSupportedException($"Unsupported data type: {dataType}");
        }
    }
}

