package com.sbtest.projectjdbc.test.tree;

import java.util.Iterator;

/**
 * 二叉树抽象接口
 * @param <T>
 */
public interface BinaryTreeADT<T> {
    //返回指向二叉树的根的引用
    public T getRootElement();
    //判断二叉树是否为空
    public boolean isEmpty();
    //返回二叉树中元素的数量
    public int size();
    //判定指定目标是否在该树中
    public boolean contains(T targetElement);
    //如果找到指定元素，则返回指向其的引用
    public T find(T targetElement);

    public String toString();
    //返回一个迭代器遍历树
    public Iterator<T> iterator();
    //为树的中序遍历返回一个迭代器
    public Iterator<T> iteratorInOrder();
    //为树的前序遍历返回一个迭代器
    public Iterator<T> iteratorPreOrder();
    //为树的后序遍历返回一个迭代器
    public Iterator<T> iteratorPostOrder();
    //为树的层序遍历返回一个迭代器
    public Iterator<T> iteratorLevelOrder();
}
