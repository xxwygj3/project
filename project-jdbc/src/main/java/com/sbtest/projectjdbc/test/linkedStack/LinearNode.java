package com.sbtest.projectjdbc.test.linkedStack;

/**
 * LinearNode<T>类用作结点类，其中含有两个引用：
 * 一个指向链表的下一LinearNode<T>结点;另一个指向本结点中存储的元素。
 * 每个结点存储的是泛型数据，当结点被实例化时才确定其类型。
 */
public class LinearNode<T> {
    private LinearNode<T> next;
    private T element;
    public LinearNode(){
        this.next = null;
        this.element = null;
    }
    public LinearNode(T element){
        next = null;
        this.element = element;
    }

    public LinearNode<T> getNext() {
        return next;
    }

    public void setNext(LinearNode<T> next) {
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }
}
