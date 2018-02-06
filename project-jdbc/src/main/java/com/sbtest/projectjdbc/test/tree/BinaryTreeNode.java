package com.sbtest.projectjdbc.test.tree;

public class BinaryTreeNode<T> extends LinkedBinaryTree<T>{
    private T element;
    private BinaryTreeNode<T>  left;
    private BinaryTreeNode<T>  right;

    public BinaryTreeNode(T element, T leftSubtree, T rightSubtree) {
        this.element=element;
        this.left= (BinaryTreeNode<T>) leftSubtree;
        this.right= (BinaryTreeNode<T>) rightSubtree;
    }

    public int numChildren(){
        return 0;
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

    public void node(){

    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }
}
