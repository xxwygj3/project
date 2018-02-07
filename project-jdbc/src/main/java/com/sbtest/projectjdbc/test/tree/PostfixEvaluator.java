package com.sbtest.projectjdbc.test.tree;

import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluator {
    private String expression;
    private Stack<ExpressionTree> treeStack;

    public PostfixEvaluator() {
        this.treeStack = new Stack<ExpressionTree>();
    }

    private ExpressionTree getOperand(Stack<ExpressionTree> treeStack) {
        ExpressionTree temp;
        temp = treeStack.pop();
        return temp;
    }

    public int evaluate(String expression) {
        ExpressionTree operand1;
        ExpressionTree operand2;
        char operator;
        String tempToken;
        Scanner parser = new Scanner(expression);
        while (parser.hasNext()) {
            tempToken = parser.next();
            operator = tempToken.charAt(0);
            if ((operator == '+') || (operator == '-') || (operator == '*') || (operator == '/')) {
                operand1 = getOperand(treeStack);
                operand2 = getOperand(treeStack);
                treeStack.push(new ExpressionTree(new ExpressionTreeOp(1, operator, 0), operand2, operand1));
            } else {
                treeStack.push(new ExpressionTree(new ExpressionTreeOp(2, ' ', Integer.parseInt(tempToken)), null, null));
            }
        }
        return (treeStack.peek()).evaluateTree();
    }

    public String getTree(){
        return (treeStack.peek()).printTree();
    }

    public static void main(String[] args) {
        String expression;
        String again;
        int result;
        Scanner in = new Scanner(System.in);
        do {
            PostfixEvaluator evaluator = new PostfixEvaluator();
            System.out.println("Enter a valid post-fix expression one token at a time with a space between each token(e.g.5 3 - 4 * 9 +)");
            System.out.println("Each token must be an integer or an operator(+，-，*，/)");
            expression = in.nextLine();
            result = evaluator.evaluate(expression);
            System.out.println();
            System.out.println("That expression equals " + result);
//            System.out.println("The Expression Tree for that expression is:");
//            System.out.println(evaluator.getTree());
            System.out.println("Evaluate another expression [Y/N]? ");
            again = in.nextLine();
            System.out.println();
        } while (again.equalsIgnoreCase("y"));
    }
}
