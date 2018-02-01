package com.sbtest.projectjdbc.test.arrayList;

import com.sbtest.projectjdbc.test.arrayList.ArrayList;
import com.sbtest.projectjdbc.test.list.NonComparableElementException;
import com.sbtest.projectjdbc.test.list.OrderedListADT;

/**
 * 数组实现有序列表
 * @param <T>
 */
public class ArrayOrderedList<T> extends ArrayList<T> implements OrderedListADT<T> {
    public ArrayOrderedList() {
        super();
    }

    public ArrayOrderedList(int initialCapacity) {
        super(initialCapacity);
    }


    @Override
    public void add(T element) {
        //只有Comparable对象才能存储在有序列表中。
        //如果试图添加一个非Comparable对象到ArrayOrderedList，将抛出一个ClassCaseException异常
        if (!(element instanceof Comparable)) {
            throw new NonComparableElementException("OrderedList");
        }
        // 可以比较的元素类型
        Comparable<T> comparableElement = (Comparable<T>) element;
        if (size() == list.length) {
            expandCapacity();
        }
        int scan = 0;
        // 找到插入位置
        while (scan < rear && comparableElement.compareTo(list[scan]) > 0) {
            scan++;
        }
        // 将元素依次后移
        for (int shift = rear; shift > scan; shift--) {
            list[shift] = list[shift - 1];
        }
        // 元素插入
        list[scan] = element;
        rear++;
        modCount++;
    }
}
