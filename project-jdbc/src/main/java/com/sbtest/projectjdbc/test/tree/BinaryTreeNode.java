package com.sbtest.projectjdbc.test.tree;

public class BinaryTreeNode<T> extends LinkedBinaryTree<T> {
    private T element;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    public BinaryTreeNode(T element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }

    public BinaryTreeNode(T element, LinkedBinaryTree<T> left, LinkedBinaryTree<T> right) {
        this.element = element;
        if (left == null) {
            this.left = null;
        } else {
            this.left = left.getRootNode();
        }
        if (right == null) {
            this.right = null;
        } else {
            this.right = right.getRootNode();
        }
    }

    /**
     * 节点总数
     *
     * @return
     */
    public int numChildren() {
        int children = 0;
        if (left != null) {
            children = 1 + left.numChildren();
        }
        if (right != null) {
            children = children + 1 + right.numChildren();
        }
        return children;
    }

    public T getElement() {
        return element;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }
}
