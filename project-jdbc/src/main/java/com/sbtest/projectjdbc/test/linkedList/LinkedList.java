package com.sbtest.projectjdbc.test.linkedList;

import com.sbtest.projectjdbc.test.linkedStack.LinearNode;
import com.sbtest.projectjdbc.test.list.ElementNotFoundException;
import com.sbtest.projectjdbc.test.list.ListADT;
import com.sbtest.projectjdbc.test.stack.EmptyCollectionException;

import java.util.Iterator;

/**
 * 链表实现列表共有操作的抽象类的定义
 *
 * @param <T>
 */
public class LinkedList<T> implements ListADT<T> {
    protected int count;
    protected LinearNode<T> head, tail;
    protected int modCount;// 修改计数

    public LinkedList() {
        this.count = 0;
        this.head = null;
        this.tail = null;
        this.modCount = 0;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new EmptyCollectionException("LinkedList");
        }
        LinearNode<T> current = head;// 当前的结点
        //是否相等
        if (size() == 1) {
            head = tail = null;
        } else {
            head = current.getNext();//
        }
        count--;
        modCount++;
        return current.getElement();
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new EmptyCollectionException("LinkedList");
        }
        boolean found = false;
        // 使用两个引用遍历
        LinearNode<T> previous = null;// 前一结点的设置
        LinearNode<T> current = head;// 当前的结点
        // 找最后的结点
        while (current != null && !found) {
            if (current.equals(tail)) {
                found = true;
            } else {
                previous = current;
                current = current.getNext();
            }
        }
        //是否相等
        if (size() == 1) {
            head = tail = null;
        } else {
            tail = previous;
            tail.setNext(null);
        }
        count--;
        modCount++;
        return current.getElement();
    }

    /**
     * 确认列表非空，查找要删除的元素，然后处理以下4种情况之一：
     * 要删除的元素是列表中的唯一元素，要删除的元素是列表中的首元素，
     * 要删除的元素是列表中末尾元素，或者要删除的元素处于列表当中位置。
     * @param targetElement
     * @return
     */
    @Override
    public T remove(T targetElement) {
        if (isEmpty()) {
            throw new EmptyCollectionException("LinkedList");
        }
        boolean found = false;
        // 使用两个引用遍历
        LinearNode<T> previous = null;// 前一结点的设置
        LinearNode<T> current = head;// 当前的结点
        while (current != null && !found) {
            if (targetElement.equals(current.getElement())) {
                found = true;
            } else {
                previous = current;
                current = current.getNext();
            }
        }
        // 如果没有发现需要删除的结点
        if (!found) {
            throw new ElementNotFoundException("LinkedList");
        }
        if (size() == 1) { // only one element in the list
            head = tail = null;
        } else if (current.equals(head)) { // target is at the head
            head = current.getNext();
        } else if (current.equals(tail)) { // target is at the tail
            tail = previous;
            tail.setNext(null);
        } else {// target is in the middle
            previous.setNext(current.getNext());
        }
        count--;
        modCount++;
        return current.getElement();
    }

    @Override
    public T first() {
        return null;
    }

    @Override
    public T last() {
        return null;
    }

    @Override
    public boolean contains(T target) {
        return false;
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
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    /**
     * 内部类 的实现iterator
     *当创建一个新迭代器时，其修改计数就设置为等于集合自己的计数。
     * 如果两个值不致了（由于集合进行了更新），那么迭代器将抛出ConcurrentModificationException异常。
     */
    private class LinkedListIterator implements Iterator<T> {
        private int iteratorModCount; // the number of elements in the
        private LinearNode<T> current; // the current position

        public LinkedListIterator() {
            this.current = head;
            this.iteratorModCount = modCount;
        }

        /**
         * 判定是否还有下一个结点
         */
        public boolean hasNext() throws ConcurrentModificationException {
            if (iteratorModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return (current != null);
        }

        /**
         * 返回元素
         */
        public T next() throws ConcurrentModificationException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T result = current.getElement();
            current = current.getNext();
            return result;
        }

        /**
         * 移除元素
         */
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
    }
}
