package com.haotu.designpattern.behavioral.patterns.interpreter;


import java.util.HashMap;
import java.util.Stack;

abstract class Expression {
    abstract int interpret(HashMap<String, String> var);
}
//todo 还需要加深理解，不是很清楚里面的逻辑
//有点像编译原理里面的词法分析，语法分析，语义分析
//需要深入理解一下
class Calculator {
    private Expression expression;

    public Calculator(String expStr) {
        Stack<Expression> stack = new Stack<>();
        char[] charArray = expStr.toCharArray();
        Expression left = null;
        Expression right = null;
        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case '+':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new AddExpression(left, right));
                    break;
                case '-':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(charArray[++i]));
                    stack.push(new SubExpression(left, right));
                    break;
                default:
                    stack.push(new VarExpression(String.valueOf(charArray[i])));
                    break;

            }

        }
        this.expression = stack.pop();
    }

    public int run(HashMap<String, String> var) {
        return this.expression.interpret(var);
    }
}

class SymbolExpression extends Expression {
    protected Expression left;
    protected Expression right;

    public SymbolExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    int interpret(HashMap<String, String> var) {
        return 0;
    }
}

class AddExpression extends SymbolExpression {
    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    int interpret(HashMap<String, String> var) {
        return this.left.interpret(var) + this.right.interpret(var);
    }
}

class SubExpression extends SymbolExpression {
    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    int interpret(HashMap<String, String> var) {
        return this.left.interpret(var) - this.right.interpret(var);
    }
}

class VarExpression extends Expression {
    private String key;

    public VarExpression(String key) {
        this.key = key;
    }

    @Override
    int interpret(HashMap<String, String> var) {
        return Integer.parseInt(var.get(this.key));
    }
}

public class InterperterPattern {
    public static void main(String[] args) {
        String expStr = "a+b-c";
        HashMap<String, String> var = new HashMap<>();
        var.put("a", "11");
        var.put("b", "2");
        var.put("c", "5");
        Calculator calculator = new Calculator(expStr);
        System.out.println("运算结果：" + expStr + "=" + calculator.run(var));
    }
}
