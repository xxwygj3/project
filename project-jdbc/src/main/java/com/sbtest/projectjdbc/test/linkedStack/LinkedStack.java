package com.sbtest.projectjdbc.test.linkedStack;

import com.sbtest.projectjdbc.test.stack.EmptyCollectionException;
import com.sbtest.projectjdbc.test.stack.StackADT;

public class LinkedStack<T> implements StackADT<T> {
    //在栈中存储的元素的数量
    private int count;
    //指向栈顶的指针
    private LinearNode<T> top;

    public LinkedStack(){
        this.count = 0;
        this.top = null;
    }

    @Override
    public void push(T element) {
        LinearNode<T> temp = new LinearNode<T>(element);
        temp.setNext(top);//next引用设置成指向当前栈顶
        top = temp;//top引用重置为指向该新结点
        count++;//count递增
    }

    @Override
    public T pop() {
        //必须首先确保栈中至少有一个元素可返回
        if(isEmpty()){
            throw new EmptyCollectionException("Stack");
        }
        T result = top.getElement();//返回一个指向当前存储在栈顶的元素的引用
        top = top.getNext();//top引用调整为指向新栈项。
        count--;//count递减
        return result;
    }

    @Override
    public T peek() {
        return top.getElement();
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }
}
