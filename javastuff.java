import java.util.*;

public abstract class Node 
{

}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~NODE TYPES~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class File extends Node
{

}
public class Statement extends Node
{

}

public class Expression extends Node
{

}
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~EXPRESSION NODES~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


public class Num extends Expression {}
public class Var extends Expression {}
public class BinaryExpression  extends Expression 
{
    String op;
    Expression left;
    Expression right;  

    BinaryExpression(Expression l, String op, Expression r){
        this.left = l;
        this.op = op;
        this.right = r;
    }

}
public class UnaryExpression extends Expression {
    String op = "";
    Expression e = new Expression();
}



public class SumExpression extends BinaryExpression{

    SumExpression(Expression l, String op, Expression r){
        super(l,op,r);
    }
  
}

public class SubtractionExpression extends BinaryExpression{}

public class MultiplicationExpression extends BinaryExpression{}

public class DivisionExpression extends BinaryExpression{}

public class Prefix extends UnaryExpression{}

public class Postfix extends UnaryExpression{}

public class AndExpression extends BinaryExpression{}

public class OrExpression extends BinaryExpression{}

public class NotExpression extends Expression{}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~STATEMENT NODES~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class Block extends Statement{
    List<Statement> statements;
}

public class VarDecl extends Statement{
    String var;     //left
    Expression e;   //right
}

public class Expression extends Statement{
    Expression expressionType;
}

public class IfElse extends Statement{
    Expression condition;
    Statement then;
    Statement else_body;
}

public class WhileLoop extends Statement{
    Expression condition;
    Statement body;
}

public class ForLoop extends Statement{
    Expression initiateVar;
    Expression condition;
    Block block;
    Expression updateCounter;
}

public class FuncDecl extends Statement{
    String functionName;
    List<Expression> parameters; 
    Block block;
}

public class FunctionCall extends Statement{
    String functionName;
    List<String> arguments;
}

public class Print extends Statement{
    List<Statement> statements;
}