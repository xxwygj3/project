package com.sbtest.projectjdbc.test.linkedList;

import com.sbtest.projectjdbc.test.linkedStack.LinearNode;
import com.sbtest.projectjdbc.test.list.UnorderedListADT;

public class LinkedUnorderedList<T> extends LinkedList<T> implements UnorderedListADT<T> {
    @Override
    public void addToFront(T element) {
        LinearNode<T> lt = new LinearNode<T>(element);
        lt.setNext(head);
        head = lt;
        count++;
        modCount++;
    }

    @Override
    public void addToRear(T element) {
        LinearNode<T> lt = new LinearNode<T>(element);
        lt.setNext(null);
        tail.setNext(lt);
        count++;
        modCount++;
    }

    @Override
    public void addAfter(T element, T target) {

    }
}
