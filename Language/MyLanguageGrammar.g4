﻿grammar MyLanguageGrammar;

// lexer
MODULE: 'MODULE';
IMPORT: 'IMPORT';
VARIABLES: 'VARIABLES';

INT: 'INT';
INT_V: [0-9]+;

REAL: 'REAL';
REAL_V: [0-9]+ '.' [0-9]+;

STR: 'STR';
STR_V: [a-zA-Z_][a-zA-Z_0-9]*;

ARRAY: 'ARRAY';
OF: 'OF';

PROCEDURE: 'PROCEDURE';

IF: 'IF';
THEN: 'THEN';
ELSIF: 'ELSIF';
ELSE: 'ELSE';

WHILE: 'WHILE';
DO: 'DO';

START: 'START';
END: 'END';
RETURN: 'RETURN';

SEMI : ';' ;
COMMA : ',' ;
LPAREN : '(' ;
RPAREN : ')' ;
EQ : ':=' ;
COLON : ':' ;
PERIOD : '.' ; 

IDENT_V: [a-zA-Z_] [a-zA-Z_0-9]* ;

WS: [ \t\r\n]+ -> skip; // ignore whitespace and tabs 

// parser
module: MODULE IDENT_V SEMI moduleStatements? PERIOD ;

moduleStatements: (IMPORT IDENT_V SEMI)* variablesDeclarationBlock? procedure* procedureBody IDENT_V ;

variablesDeclarationBlock: VARIABLES (variablesDeclaration SEMI)+ ;

variablesDeclaration: IDENT_V (COMMA IDENT_V)* COLON type ;

type: INT 
    | REAL 
    | STR 
    | ARRAY OF type;

procedure: procedureDeclaration variablesDeclarationBlock? procedureBody SEMI ;

procedureDeclaration: PROCEDURE IDENT_V (LPAREN procedureParameters RPAREN)? (COLON type)? ;

procedureParameters: variablesDeclaration (COMMA variablesDeclaration)* ;

procedureBody: START statement* END ;

statement: (
    procedureCall 
    | assignment 
    | ifStatement 
    | whileStatement 
    | returnStatement
    ) SEMI ;

procedureCall: IDENT_V LPAREN (expression (COMMA expression)*)? RPAREN ;

expression: simpleExpression (relation simpleExpression)? ;

simpleExpression: addOperator? term (addOperator term)* ;

addOperator
    : '+'
    | '-';

relation
    : '='
    | '#'
    | '<'
    | '<='
    | '>'
    | '>=';

term : factor (mulOperator factor)*;

mulOperator
    : '*'
    | '/'
    | '&';

factor: '~' factor 
    | LPAREN expression RPAREN
    | procedureCall 
    | IDENT_V 
    | literal;

literal: REAL_V 
    | INT_V 
    | STR_V ;

assignment: IDENT_V EQ expression ;

ifStatement: IF expression THEN statement* (elseIfStatement)? (elseStatement)? END ;
elseIfStatement: ELSIF expression THEN statement* ;
elseStatement: ELSE statement* ;

whileStatement: WHILE expression DO statement* END ;

returnStatement: RETURN expression ;

