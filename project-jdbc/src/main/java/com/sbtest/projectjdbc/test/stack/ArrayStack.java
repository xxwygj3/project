package com.sbtest.projectjdbc.test.stack;

import java.util.Arrays;

/**
 * 基于数组的栈实现
 * 出于运行效率的考虑，基于数组的栈实现总是使栈底位于数组的索引0处
 * @param <T>
 */
public class ArrayStack<T> implements StackADT<T> {
    private final int DEFAULT_CAPACITY = 100;// 默认容量
    private int top;// 指向实际栈顶的下一个数组位置，表示下一个单元（将要压入元素就存储在这里），也表示了当前栈中的元素数量
    private T[] stack;// 泛型数组来存储该栈

    /* 使用默认容量创建一个空栈 */
    @SuppressWarnings("uncheched")
    public ArrayStack() {
        top = 0;
        // 实例化一个Object数组，然后把它转换为一个泛型数组。
        // 不要试图创建一个泛型数组：stack = new T[DEFAULT_CAPACITY]（泛型数组不能被实例化）
        stack = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    /* 使用指定容量创建一个空栈，参数initialCapacity表示的是指定容量 */
    @SuppressWarnings("uncheched")
    public ArrayStack(int initialCapacity) {
        top = 0;
        stack = (T[]) (new Object[initialCapacity]);
    }

    /**
     * 要把一个元素压入到栈中，更新变量top的值
     * 必须确定该数组是否已满，是否需要扩充其容量
     * @param element
     */
    @Override
    public void push(T element) {
        if (size() == stack.length) {
            expandCapacity();
        }
        stack[top] = element;
        top++;
    }

    /**
     * 使数组的大小加倍
     */
    private void expandCapacity() {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    /**
     * pop操作移出并返回栈顶元素，然后把数组中的该单元设置为空
     * 必须确保栈中至少有一个要返回的元素
     * @return
     */
    @Override
    public T pop() {
        if(isEmpty()){
            throw new EmptyCollectionException("Stack");
        }
        top--;
        T result = stack[top];
        stack[top] = null;
        return result;
    }

    /**
     * peek操作返回一个指向栈项元素的引用，但不把它从数组移出。
     * 对于数组实现，这意味着将返回一个指向top-1处的元素
     * @return
     */
    @Override
    public T peek() {
        if(isEmpty()){
            throw new EmptyCollectionException("Stack");
        }
        return stack[top-1];
    }

    /**
     * 如果栈为空返回真，否则返回假
     * @return
     */
    @Override
    public boolean isEmpty() {
        return stack.length == 0;
    }

    /**
     * 返回栈的元素数目
     * @return
     */
    @Override
    public int size() {
        return stack.length;
    }
}
