package com.sbtest.projectjdbc.test.recursion;

public class Sum {
    public static void main(String[] args) {
        System.out.println(sum(20));
    }

    private static int sum(int num) {
        if (num == 1) {
            return 1;
        }
        return num + sum(num - 1);
    }
}
