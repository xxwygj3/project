package com.sbtest.projectjdbc.test.list;

/**
 * 无序列表接口
 * @param <T>
 */
public interface UnorderedListADT<T> extends ListADT<T> {
    public void addToFront(T element);
    public void addToRear(T element);
    public void addAfter(T element,T target);
}
