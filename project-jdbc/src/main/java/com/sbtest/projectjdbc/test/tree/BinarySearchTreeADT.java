package com.sbtest.projectjdbc.test.tree;

/**
 * 二叉查找树抽象接口
 * @param <T>
 */
public interface BinarySearchTreeADT<T> extends BinaryTreeADT<T> {
    //往树中添加一个元素
    public void addElement(T element);

    //从树中删除一个元素
    public T removeElement(T targetElement);

    //从树中删除所指定元素的任何存在
    public void removeAllOccurrences(T targetElement);

    //删除树中的最小元素
    public T removeMin();

    //删除树中的最大元素
    public T removeMax();

    //返回一个指向树中最小元素的引用
    public T findMin();

    //返回一个指向树中最大元素的引用
    public T findMax();
}
