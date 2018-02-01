package com.sbtest.projectjdbc.test.list;

/**
 * 有序列表接口
 */
public interface OrderedListADT<T> extends ListADT<T> {
    public void add(T element);
}
