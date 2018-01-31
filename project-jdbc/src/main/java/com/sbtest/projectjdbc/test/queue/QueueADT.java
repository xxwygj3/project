package com.sbtest.projectjdbc.test.queue;

import com.sbtest.projectjdbc.test.stack.EmptyCollectionException;

public interface QueueADT<T> {
    //入列
    public void enqueue(T element);
    //出列
    public T dequeue() throws EmptyCollectionException;
    public T first();
    public boolean isEmpty();
    public int size();
    public String toString();
}
