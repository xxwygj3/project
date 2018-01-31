package com.sbtest.projectjdbc.test.queue;

import com.sbtest.projectjdbc.test.linkedStack.LinearNode;
import com.sbtest.projectjdbc.test.stack.EmptyCollectionException;

/**
 * 单向链表，选择从末端入列，从前端出列。双向链表无所谓从哪端入列和出列。
 * 指向链表首元素的引用head，指向链表末元素的引用tail。
 * 对于一个空队列，head,tail引用都为null,count则为0。
 */
public class LinkedQueue<T> implements QueueADT<T> {
    private int count;
    private LinearNode<T> head,tail;

    public LinkedQueue() {
        this.count = 0;
        this.head = null;
        this.tail = null;
    }

    /**
     * 将新元素放到链表末端
     * 将当前末元素的next引用设置为指向这个新元素，并重新把tail引用设置为指向这个新添加的末元素。
     * 但如果队列目前为空，则head引用也要设置为指向这个新添元素
     * @param element
     */
    @Override
    public void enqueue(T element) {
        LinearNode<T> node = new LinearNode<T>(element);
        if(isEmpty()){
            head = node;
        }else{
            tail.setNext(node);//当前末元素的next引用设置为指向这个新元素
        }
        tail = node;//重新把tail引用设置为指向这个新添加的末元素
        count++;
    }

    /**
     * 确保至少存在一个可返回的元素。
     * 如果没有，则会抛出一个EmptyCollectionException异常。
     * 如果队列中至少有一个元素，那么会返回该链表的首元素，然后更新head引用。
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException("queue");
        }
        T result = head.getElement();
        head = head.getNext();
        count--;
        if(isEmpty()){
            tail = null;
        }
        return result;
    }

    /**
     * 返回一个指向队列前端元素的引用
     * @return
     */
    @Override
    public T first() {
        return head.getElement();
    }

    /**
     * 如果元素数目为0时，返回true
     * @return
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 返回队列中的元素数目
     * @return
     */
    @Override
    public int size() {
        return count;
    }
}
