package com.sbtest.projectjdbc.test.arrayList;

import com.sbtest.projectjdbc.test.linkedList.ConcurrentModificationException;
import com.sbtest.projectjdbc.test.list.ElementNotFoundException;
import com.sbtest.projectjdbc.test.list.ListADT;
import com.sbtest.projectjdbc.test.linkedList.NoSuchElementException;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 数组实现列表共有操作的抽象类的定义
 *
 * @param <T>
 */
public abstract class ArrayList<T> implements ListADT<T>, Iterable<T> {
    private final static int DEFAULT_CAPACITY = 100;
    private final static int NOT_FOUND = -1;

    protected int rear;// 表示列表中的元素数目
    protected T[] list;// 表示列表
    protected int modCount;// 修改计数

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int initialCapacity) {
        this.rear = 0;
        this.list = (T[]) (new Object[initialCapacity]);
        this.modCount = 0;
    }

    /**
     * 获取需要删除的元素的索引
     *
     * @param elem
     * @return
     */
    private int find(T elem) {
        int scan = 0;
        int result = NOT_FOUND;

        if (!isEmpty())
            while (result == NOT_FOUND && scan < rear)
                if (elem.equals(list[scan]))
                    result = scan;
                else
                    scan++;

        return result;
    }

    /**
     * 盘算是否存在当前元素
     */
    public boolean contains(T target) {
        return (find(target) != NOT_FOUND);
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T remove(T element) {
        T result;
        int index = find(element);
        if (index == NOT_FOUND) {
            throw new ElementNotFoundException("ArrayList");
        }
        result = list[index];// 结果找到
        rear--;
        // 移动
        for (int i = index; i < rear; i++) {
            list[i] = list[i++];// 元素向前移动
        }
        list[rear] = null;// 最后一个置空
        modCount++;
        return result;
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
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    /**
     * 集合内部的Iterator
     * 当创建一个新迭代器时，其修改计数就设置为等于集合自己的计数。
     * 如果两个值不致了（由于集合进行了更新），那么迭代器将抛出ConcurrentModificationException异常。
     */
    private class ArrayListIterator implements Iterator<T> {
        int iteratorModCount;// 检查修改计数
        int current;

        public ArrayListIterator() {
            this.iteratorModCount = modCount;// /初始化
            this.current = 0;
        }

        /**
         * 判定是否还有元素
         */
        public boolean hasNext() throws ConcurrentModificationException {
            // 不断检查当前的修改计数是否一致不变
            if (iteratorModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return (current < rear);
        }

        /**
         * 返回当前的元素
         */
        public T next() throws ConcurrentModificationException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            current++;
            return list[current - 1];
        }

        /**
         * 当从列表中移除元素的时候会报异常
         */
        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

    }

    /**
     * 数组扩大容量
     */
    protected void expandCapacity() {
        //数组复制扩容
        list = Arrays.copyOf(list, list.length * 2);
    }

}
