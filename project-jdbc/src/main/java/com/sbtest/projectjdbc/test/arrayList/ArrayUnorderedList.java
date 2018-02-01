package com.sbtest.projectjdbc.test.arrayList;

import com.sbtest.projectjdbc.test.arrayList.ArrayList;
import com.sbtest.projectjdbc.test.list.ElementNotFoundException;
import com.sbtest.projectjdbc.test.list.UnorderedListADT;

/**
 * 数组实现无序列表
 *
 * @param <T>
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedListADT<T> {
    public ArrayUnorderedList() {
        super();
    }

    public ArrayUnorderedList(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public void addToFront(T element) {
        if (size() == list.length) {
            expandCapacity();
        }
        for (int shift = rear; shift > 0; shift--) {
            list[shift] = list[shift - 1];
        }
        list[0] = element;
        rear++;
        modCount++;
    }

    @Override
    public void addToRear(T element) {
        if (size() == list.length) {
            expandCapacity();
        }
        list[rear] = element;
        rear++;
        modCount++;
    }

    /**
     * 在某个元素后面添加元素
     *
     * @param element
     * @param target
     */
    @Override
    public void addAfter(T element, T target) {
        //如果满了就要扩容
        if (size() == list.length) {
            expandCapacity();
        }
        int scan = 0;
        // 查找插入点
        while (scan < rear && !target.equals(list[scan])) {
            scan++;
        }
        if (scan == rear) {
            throw new ElementNotFoundException("UnorderedList");
        }
        scan++;
        // 元素后移
        for (int shift = rear; shift > scan; shift--) {
            list[shift] = list[shift - 1];
        }
        // 插入元素
        list[scan] = element;
        rear++;
        modCount++;
    }

}
