package com.sbtest.projectjdbc.test.tree;

import java.util.Iterator;

public class LinkedBinaryTree<T> implements BinaryTreeADT<T>{
    protected BinaryTreeNode<T> root;
    protected int height;

    public LinkedBinaryTree() {
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public T getRootElement() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean contains(T targetElement) {
        return false;
    }

    @Override
    public T find(T targetElement) {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Iterator<T> iteratorIOrder() {
        return null;
    }

    @Override
    public Iterator<T> iteratorPreOrder() {
        return null;
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        return null;
    }

    @Override
    public Iterator<T> iteratorLevelOrder() {
        return null;
    }
}
