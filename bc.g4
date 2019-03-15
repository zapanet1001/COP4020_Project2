/** Grammar from tour chapter augmented with actions */
grammar bc;
@header {
//package tools;
import java.util.*;
import java.lang.Math;
}

@parser::members {
    /** "memory" for our calculator; variable/value pairs go here */
    Map<String, Float> memory = new HashMap<String, Float>();
    Scanner reader = new Scanner(System.in);

    float eval(float l, int op, float r) {
        
        switch ( op ) {
            case MUL : return l * r;
            case DIV : return l / r;
            case ADD : return l + r;
            case SUB : return l - r;
        }
        return 0;
    }

    float getFloatValue(String f){
        return Float.parseFloat(f);
    }
//~~~~~~~~~~~~~~MATH FUNCTIONS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
    float solveMathFunction(String func, float val){
        switch(func){
            case "sqrt": return (float)Math.sqrt(val);
            case "s": return (float)Math.sin(val);
            case "c": return (float)Math.cos(val);
            case "l": return (float)Math.log(val);
            case "e": return (float)Math.exp(val);
        }
        return 0;
    }
//~~~~~~~~~~~~~~BOOLEAN~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  

    int evalBool(float left, String op, float right) {
        if(op.equals("&&")){
            if(left!=0 && right!=0) {return 1;}
        }
        else if (op.equals("||")){
            if(left!=0 || right!=0) {return 1;}
        }
        return 0;
    }
 
    
//~~~~~~~~~~~~~~NEGATION~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  

    int negation(String op, float val){
        if(op.equals("!") && val==0){
            return 1;
        }
        return 0;
    }
    int negation(String op, int val){
        if(op.equals("!") && val==0){
            return 1;
        }
        return 0;
    }
//~~~UNARY FUNCTIONS~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    float decrement(String s){
        if(memory.containsKey(s)){
            memory.put(s, memory.get(s) - 1); 
            return memory.get(s);
        }
        return 0;
    }

    float decrement_post(String s){
        float r;
        if(memory.containsKey(s)){
            r = memory.get(s);
            memory.put(s, memory.get(s) - 1); 
            return r;
        }
        return 0;
    }

    float increment(String s){
        if(memory.containsKey(s)){
            memory.put(s, memory.get(s) + 1); 
            return memory.get(s);
        }
        return 0;
    }    
    float increment_post(String s){
        float r;
        if(memory.containsKey(s)){
            r = memory.get(s);
            memory.put(s, memory.get(s) + 1); 
            return r;
        }
        return 0;
    }
}

prog: stat+;

functionDecl
    : 'define' ID LPAREN ID* RPAREN block; 

block: LBRACE stat* RBRACE;

stat:   block 
    |   varDecl                 
    |   expr NEWLINE            {System.out.println($expr.v);}
    |   ifelse NEWLINE          
    |   s_while NEWLINE
    |   s_for NEWLINE
    |   functionDecl NEWLINE
    |   function NEWLINE        {System.out.println($function.f);}
    |   print NEWLINE
    |   NEWLINE
    ;

varDecl 
    :   ID '=' function NEWLINE        {memory.put($ID.text, $function.f);}
    |   ID '=' expr NEWLINE            {memory.put($ID.text, $expr.v);}
    ;

ifelse 
    : 'if' a=expr b=stat 'else' c=stat 
    ;

s_while
    : 'while' expr stat
    ;

s_for
    : 'for' LPAREN varDecl expr 
    ;


function returns [float f]
    : 'read' LPAREN RPAREN                  {$f = reader.nextFloat();}
    | z=mathfunctions LPAREN a=expr RPAREN  {$f = solveMathFunction($z.text, $a.v);}
    | x=function op=(MUL|DIV) y=function    {$f = eval($x.f, $op.type, $y.f);}
    | x=function op=(ADD|SUB) y=function    {$f = eval($x.f, $op.type, $y.f);}
    | x=function op=(AND|OR) y=function     {$f = evalBool($x.f, $op.text, $y.f);}
    | LPAREN function RPAREN                {$f = $function.f;}
    ;

mathfunctions
    : 'sqrt'
    | 's'
    | 'c'
    | 'l'
    | 'e'
    ;

print: 'print' expr (',' expr)*       {System.out.println($expr.v);}
    ;


expr returns [float v]
//function call
    : ID LPAREN elist RPAREN 
     
//unary math expressions
    | '--' a=expr                   {$v = decrement($a.text);}
    | a=expr '--'                   {$v = decrement_post($a.text);}
    | '++' a=expr                   {$v = increment($a.text);}
    | a=expr '++'                   {$v = increment_post($a.text);}
//binary math expressions
    | a=expr op=(MUL|DIV) b=expr    {$v = eval($a.v, $op.type, $b.v);}
    | a=expr op=(ADD|SUB) b=expr    {$v = eval($a.v, $op.type, $b.v);}
//boolean expressions
    | a=expr op=(AND|OR) b=expr     {$v = evalBool($a.v, $op.text, $b.v);}
    | op=NOT a=expr                 {$v = negation($op.text, $a.v);}
//primitives
    | FLOAT                         {$v = getFloatValue($FLOAT.text);}
    | ID
      {
      String id = $ID.text;
      $v = memory.containsKey(id) ? memory.get(id) : 0;
      }
    | LPAREN expr RPAREN            {$v = $expr.v;}
    ;

elist: expr (','expr)*;

MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
AND : '&&' ;	    
OR : '||';			
NOT : '!' ;			
LPAREN : '(';
RPAREN : ')';
LBRACE : '{';
RBRACE : '}';


ID  :   [a-zA-Z]+ ;      
FLOAT
    :   INT+ '.' INT
    |   '.' INT+
    |   INT+
    ;
INT :   [0-9]+ ;         
NEWLINE:'\r'? '\n' ;     
WS  :   [ \t]+ -> skip ; 
COMMENT: '/*' .*? '*/' -> skip;
