grammar MyLanguageGrammar;

// Lexer rules

MODULE: 'MODULE';
IMPORT: 'IMPORT';
VARIABLES: 'VARIABLES';

INT: 'INT';
INT_L: [0-9]+;

REAL: 'REAL';
REAL_L: [0-9]+ '.' [0-9]+;

STR: 'STR';
STR_L: '"' .*? '"' ;

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

SEMI: ';' ;
COMMA: ',' ;
LPAREN: '(' ;
RPAREN: ')' ;
EQ: ':=' ;
COLON: ':' ;
PERIOD: '.' ; 

IDENT_L: [a-zA-Z_] [a-zA-Z_0-9]*;

WS: [ \t\r\n]+ -> skip;

// Parser rules

start: module EOF;

module: MODULE IDENT_L SEMI moduleStatements? PERIOD ;

moduleStatements: (IMPORT IDENT_L SEMI)* variablesDeclarationBlock? procedure* procedureBody IDENT_L ;

variablesDeclarationBlock: VARIABLES (variablesDeclaration SEMI)+ ;

variablesDeclaration: IDENT_L (COMMA IDENT_L)* COLON type ;

type: INT 
    | REAL 
    | STR 
    | ARRAY INT_L OF type;

procedure: procedureDeclaration variablesDeclarationBlock? procedureBody SEMI ;

procedureDeclaration: PROCEDURE IDENT_L (LPAREN procedureParameters RPAREN)? (COLON type)? ;

procedureParameters: variablesDeclaration (COMMA variablesDeclaration)* ;

procedureBody: START statement* END ;

statement: (procedureCall 
    | assignment 
    | ifStatement 
    | whileStatement 
    | returnStatement
    ) SEMI ;

procedureCall: IDENT_L LPAREN (expression (COMMA expression)*)? RPAREN ;

expression: simpleExpression (relation simpleExpression)? ;

simpleExpression: addOperator? term (addOperator term)* ;

addOperator: '+'
    | '-';

relation: '='
    | '<'
    | '<='
    | '>'
    | '>=';

term: factor (('*' | '/' | '&') factor)*;

factor: '~' factor 
    | LPAREN expression RPAREN
    | procedureCall 
    | IDENT_L 
    | literal;

literal: REAL_L 
    | INT_L 
    | STR_L ;

assignment: IDENT_L EQ expression ;

ifStatement: IF expression THEN statement* (elseIfStatement)? (elseStatement)? END ;
elseIfStatement: ELSIF expression THEN statement* ;
elseStatement: ELSE statement* ;

whileStatement: WHILE expression DO statement* END ;

returnStatement: RETURN expression ;