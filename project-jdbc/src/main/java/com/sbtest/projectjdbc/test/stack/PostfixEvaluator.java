package com.sbtest.projectjdbc.test.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 7*(4*(-3)/(1+5))
 * 后缀表达式7 4 -3 * 1 5 + / *
 * 使用栈来计算后缀表达式的算法如下：从左到右扫描表达式，依次标识出每个符号（操作符或操作数）。
 * 如果是操作数，则把它压入栈中。
 * 如果是操作符，则从栈中弹出两个元素，并把该操作符应用在这两个元素之上，然后把操作结果压入到栈中。
 * 当到达表达式的末尾时，栈中所剩余的元素就是该表达式的计算结果。
 * 如果试图从栈中弹出两个元素时，该栈中并没有，那么该后缀表达式是不正确的。
 * 同样，如果到达表达式末尾时，栈中剩余的元素不止一个，该表达式也是不正确的。
 */
public class PostfixEvaluator {
    private final static char ADD = '+';
    private final static char SUBTRACT = '-';
    private final static char MULTIPLY = '*';
    private final static char DIVIDE = '/';

    private Stack<Integer> stack;

    public PostfixEvaluator() {
        stack = new Stack<Integer>();
    }

    public int evaluate(String expr) {
        int op1, op2, result = 0;
        String token;
        Scanner parser = new Scanner(expr);
        while (parser.hasNext()) {
            token = parser.next();
            if (isOperator(token)) {
                op2 = (stack.pop()).intValue();
                op1 = (stack.pop()).intValue();
                result = evaluateSingleOperator(token.charAt(0), op1, op2);
                stack.push(new Integer(result));
            }else{
                stack.push(new Integer(Integer.parseInt(token)));
            }
        }
        return result;
    }

    /**
     * 判断是操作数
     * @param token
     * @return
     */
    private boolean isOperator(String token) {
        return (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
    }

    /**
     * 计算结果
     * @param operator
     * @param op1
     * @param op2
     * @return
     */
    private int evaluateSingleOperator(char operator, int op1, int op2) {
        int result = 0;
        switch (operator) {
            case ADD:
                result = op1 + op2;
                break;
            case SUBTRACT:
                result = op1 - op2;
                break;
            case MULTIPLY:
                result = op1 * op2;
                break;
            case DIVIDE:
                result = op1 / op2;
        }
        return result;
    }

    public static void main(String[] args) {
        String expression, again;
        int result;
        Scanner in = new Scanner(System.in);
        do {
            PostfixEvaluator evaluator = new PostfixEvaluator();
            System.out.println("Enter a valid post-fix expression one token " + "at a time with a space between each token (e.g 5 4 + 3 2 1 - + *)");
            System.out.println("Each token must be an integer or an operator (+,-,*,/)");
            expression = in.nextLine();
            result = evaluator.evaluate(expression);
            System.out.println();
            System.out.println("That expression equals : " + result);

            System.out.println("Evalute another expression [Y/N]?");
            again = in.nextLine();
            System.out.println();
        } while (again.equalsIgnoreCase("y"));
    }
}
