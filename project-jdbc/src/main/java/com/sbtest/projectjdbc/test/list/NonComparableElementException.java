package com.sbtest.projectjdbc.test.list;

public class NonComparableElementException extends RuntimeException {
    public NonComparableElementException(String collection) {
        super("The " + collection + "is empty.");
    }
}
