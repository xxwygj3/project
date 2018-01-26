package com.sbtest.projectjdbc.test.stack;

/**
 * 空栈异常
 */
public class EmptyCollectionException extends RuntimeException {
    public EmptyCollectionException(String collection){
        super("The " + collection+"is empty.");
    }
}
