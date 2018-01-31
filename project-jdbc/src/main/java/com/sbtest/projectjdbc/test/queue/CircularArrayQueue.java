package com.sbtest.projectjdbc.test.queue;

import com.sbtest.projectjdbc.test.stack.EmptyCollectionException;

/**
 * 环形数组队列
 * 当队列的末端到达数组末端时，它将“环绕”
 * 用两个整数值来表示队列的前端和末端
 * front的值表示的是队列的首元素存储的位置，rear的值表示的是数组的下一个可用单元
 * count来跟踪元素计数
 *
 * @param <T>
 */
public class CircularArrayQueue<T> implements QueueADT<T> {
    private static final int DEFAULT_CAPACITY = 100;
    private int front, rear, count;
    private T[] queue;

    public CircularArrayQueue() {
        this(DEFAULT_CAPACITY);
    }

    public CircularArrayQueue(int initialCapacity) {
        this.front = 0;
        this.rear = 0;
        this.count = 0;
        this.queue = ((T[]) (new Object[initialCapacity]));
    }

    /**
     * 一个元素入列后，rear的值要递增。
     * 但当填充了数组的最后一个单元时，rearR的值必须设置为0。
     * rear值的正确更新可以在一个计算中使用余数操作符（%）来完成。
     * rear = (rear+1) % queue.length
     *
     * @param element
     */
    @Override
    public void enqueue(T element) {
        if (size() == queue.length) {
            expandCapacity();
        }
        queue[rear] = element;
        rear = (rear + 1) % queue.length;
        count++;
    }

    /**
     * 扩大数组
     * 注意：已有数组的元素必须按其在队列中的正确顺序复制到新数组中。
     */
    private void expandCapacity() {
        T[] larger = (T[]) (new Object[queue.length * 2]);
        for (int scan = 0; scan < count; scan++) {
            larger[scan] = queue[front];
            front = (front + 1) % queue.length;
    }
        front = 0;
        rear = count;
    }

    /**
     * 一个元素出列后，front的值要减
     * 当最大索引处的元素被删除后，front的值必须设置为0而不是递减。
     * @return
     * @throws EmptyCollectionException
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        if(isEmpty()){
            throw new EmptyCollectionException("queue");
        }
        T result = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        count--;
        return result;
    }

    @Override
    public T first() {
        return queue[front];
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
