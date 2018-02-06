package com.sbtest.projectjdbc.test.tree;

/**
 * 跟踪记录该元素是一个数字还是一个操作符，以及该处存储的是哪个操作符或是什么值。
 */
public class ExpressionTreeOp{
    private int termType;
    private char operator;
    private int value;

    public ExpressionTreeOp(int termType, char operator, int value) {
        this.termType = termType;
        this.operator = operator;
        this.value = value;
    }

    public boolean isOperator() {
        return (termType == 1);
    }

    public char getOperator() {
        return operator;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        if (termType == 1) {
            return operator + "";
        } else {
            return value + "";
        }
    }
}
