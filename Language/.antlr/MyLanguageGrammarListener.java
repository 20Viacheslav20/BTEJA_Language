// Generated from c:/Users/slavi/Downloads/for study/BTEJA - Teorie jazyku/my/Language/Language/MyLanguageGrammar.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MyLanguageGrammarParser}.
 */
public interface MyLanguageGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MyLanguageGrammarParser#module}.
	 * @param ctx the parse tree
	 */
	void enterModule(MyLanguageGrammarParser.ModuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageGrammarParser#module}.
	 * @param ctx the parse tree
	 */
	void exitModule(MyLanguageGrammarParser.ModuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageGrammarParser#moduleStatements}.
	 * @param ctx the parse tree
	 */
	void enterModuleStatements(MyLanguageGrammarParser.ModuleStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageGrammarParser#moduleStatements}.
	 * @param ctx the parse tree
	 */
	void exitModuleStatements(MyLanguageGrammarParser.ModuleStatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageGrammarParser#variablesDeclarationBlock}.
	 * @param ctx the parse tree
	 */
	void enterVariablesDeclarationBlock(MyLanguageGrammarParser.VariablesDeclarationBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageGrammarParser#variablesDeclarationBlock}.
	 * @param ctx the parse tree
	 */
	void exitVariablesDeclarationBlock(MyLanguageGrammarParser.VariablesDeclarationBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageGrammarParser#variablesDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariablesDeclaration(MyLanguageGrammarParser.VariablesDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageGrammarParser#variablesDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariablesDeclaration(MyLanguageGrammarParser.VariablesDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MyLanguageGrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageGrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MyLanguageGrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageGrammarParser#procedure}.
	 * @param ctx the parse tree
	 */
	void enterProcedure(MyLanguageGrammarParser.ProcedureContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageGrammarParser#procedure}.
	 * @param ctx the parse tree
	 */
	void exitProcedure(MyLanguageGrammarParser.ProcedureContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageGrammarParser#procedureDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterProcedureDeclaration(MyLanguageGrammarParser.ProcedureDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageGrammarParser#procedureDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitProcedureDeclaration(MyLanguageGrammarParser.ProcedureDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageGrammarParser#procedureParameters}.
	 * @param ctx the parse tree
	 */
	void enterProcedureParameters(MyLanguageGrammarParser.ProcedureParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageGrammarParser#procedureParameters}.
	 * @param ctx the parse tree
	 */
	void exitProcedureParameters(MyLanguageGrammarParser.ProcedureParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageGrammarParser#procedureBody}.
	 * @param ctx the parse tree
	 */
	void enterProcedureBody(MyLanguageGrammarParser.ProcedureBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageGrammarParser#procedureBody}.
	 * @param ctx the parse tree
	 */
	void exitProcedureBody(MyLanguageGrammarParser.ProcedureBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MyLanguageGrammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageGrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MyLanguageGrammarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageGrammarParser#procedureCall}.
	 * @param ctx the parse tree
	 */
	void enterProcedureCall(MyLanguageGrammarParser.ProcedureCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageGrammarParser#procedureCall}.
	 * @param ctx the parse tree
	 */
	void exitProcedureCall(MyLanguageGrammarParser.ProcedureCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MyLanguageGrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageGrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MyLanguageGrammarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageGrammarParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void enterSimpleExpression(MyLanguageGrammarParser.SimpleExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageGrammarParser#simpleExpression}.
	 * @param ctx the parse tree
	 */
	void exitSimpleExpression(MyLanguageGrammarParser.SimpleExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageGrammarParser#addOperator}.
	 * @param ctx the parse tree
	 */
	void enterAddOperator(MyLanguageGrammarParser.AddOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageGrammarParser#addOperator}.
	 * @param ctx the parse tree
	 */
	void exitAddOperator(MyLanguageGrammarParser.AddOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageGrammarParser#relation}.
	 * @param ctx the parse tree
	 */
	void enterRelation(MyLanguageGrammarParser.RelationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageGrammarParser#relation}.
	 * @param ctx the parse tree
	 */
	void exitRelation(MyLanguageGrammarParser.RelationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(MyLanguageGrammarParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageGrammarParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(MyLanguageGrammarParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageGrammarParser#mulOperator}.
	 * @param ctx the parse tree
	 */
	void enterMulOperator(MyLanguageGrammarParser.MulOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageGrammarParser#mulOperator}.
	 * @param ctx the parse tree
	 */
	void exitMulOperator(MyLanguageGrammarParser.MulOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(MyLanguageGrammarParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageGrammarParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(MyLanguageGrammarParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageGrammarParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(MyLanguageGrammarParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageGrammarParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(MyLanguageGrammarParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(MyLanguageGrammarParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageGrammarParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(MyLanguageGrammarParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageGrammarParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MyLanguageGrammarParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageGrammarParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MyLanguageGrammarParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageGrammarParser#elseIfStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseIfStatement(MyLanguageGrammarParser.ElseIfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageGrammarParser#elseIfStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseIfStatement(MyLanguageGrammarParser.ElseIfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageGrammarParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void enterElseStatement(MyLanguageGrammarParser.ElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageGrammarParser#elseStatement}.
	 * @param ctx the parse tree
	 */
	void exitElseStatement(MyLanguageGrammarParser.ElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageGrammarParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MyLanguageGrammarParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageGrammarParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MyLanguageGrammarParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MyLanguageGrammarParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(MyLanguageGrammarParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MyLanguageGrammarParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(MyLanguageGrammarParser.ReturnStatementContext ctx);
}