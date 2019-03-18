parser grammar bcParser;

options { tokenVocab = bc; }

bc : lines=line+;

line    : statement (NEWLINE | EOF) ;

statement   : varDeclaration    // varDeclarationStatement
            | assignment        // assignmentStatement
            ;

varDeclaration  :   VAR assignment ;

assignment  :   ID ASSIGN expression ;

expression  :   left = expression operator = (DIV|MUL) right = expression
            |   left = expression operator = (ADD|SUB) right = expression
            |   ID
            |   SUB expression
            |   INT
            |   FLOAT
            ;

type    :   INT
        |   FLOAT
        ;