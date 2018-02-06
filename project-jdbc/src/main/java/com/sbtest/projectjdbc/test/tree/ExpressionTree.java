package com.sbtest.projectjdbc.test.tree;

import com.sbtest.projectjdbc.test.arrayList.ArrayUnorderedList;
import com.sbtest.projectjdbc.test.list.UnorderedListADT;

public class ExpressionTree extends LinkedBinaryTree<ExpressionTreeOp> {
    public ExpressionTree() {
        super();
    }

    public ExpressionTree(ExpressionTreeOp element, ExpressionTree leftSubtree, ExpressionTree rightSubtree) {
        root = new BinaryTreeNode<ExpressionTreeOp>(element, leftSubtree, rightSubtree);
    }

    public int evaluateTree() {
        return evaluateNode(root);
    }

    public int evaluateNode(BinaryTreeNode root) {
        int result;
        int operand1;
        int operand2;
        ExpressionTreeOp temp = null;
        if (root == null) {
            result = 0;
        } else {
            temp = (ExpressionTreeOp) root.getElement();
        }
        if (temp.isOperator()) {
            operand1 = evaluateNode(root.getLeft());
            operand2 = evaluateNode(root.getRight());
            result = computeTerm(temp.getOperator(), operand1, operand2);
        } else {
            result = temp.getValue();
        }
        return result;
    }

    private static int computeTerm(char operator, int operand1, int operand2) {
        int result = 0;
        if (operator == '+') {
            result = operand1 + operand2;
        } else if (operator == '-') {
            result = operand1 - operand2;
        } else if (operator == '*') {
            result = operand1 * operand2;
        } else {
            result = operand1 / operand2;
        }
        return result;
    }

    public String printTree() {
        UnorderedListADT<BinaryTreeNode<ExpressionTreeOp>> nodes = new ArrayUnorderedList<BinaryTreeNode<ExpressionTreeOp>>();
        UnorderedListADT<Integer> levelList = new ArrayUnorderedList<Integer>();
        BinaryTreeNode<ExpressionTreeOp> current;
        String result = "";
        int printDepth = this.getHeight();
        int possibleNodes = (int) Math.pow(2, printDepth + 1);
        int countNodes = 0;
        nodes.addToRear(root);
        Integer currentLevel = 0;
        Integer previousLevel = -1;
        levelList.addToRear(currentLevel);
        while (countNodes < possibleNodes) {
            countNodes = countNodes + 1;
            current = nodes.removeFirst();
            currentLevel = levelList.removeFirst();
            if (currentLevel > previousLevel) {
                result = result + "\n\n";
                previousLevel = currentLevel;
                for (int j = 0; j < ((Math.pow(2, (printDepth - currentLevel))) - 1); j++) {
                    result = result + " ";
                }
            } else {
                for (int i = 0; i < ((Math.pow(2, (printDepth - currentLevel + 1)) - 1)); i++) {
                    result = result + " ";
                }
            }
            if (current != null) {
                result = result + (current.getElement()).toString();
                nodes.addToRear(current.getLeft());
                levelList.addToRear(currentLevel + 1);
                nodes.addToRear(current.getRight());
                levelList.addToRear(currentLevel + 1);
            } else {
                nodes.addToRear(null);
                levelList.addToRear(currentLevel + 1);
                nodes.addToRear(null);
                levelList.addToRear(currentLevel + 1);
                result = result + " ";
            }
        }
        return result;
    }
}
