package com.sbtest.projectjdbc.test.recursion;

/**
 * 递归最大公约数
 * 最大公约数是可以被这两个数整除而没有余数的最大整数
 */
public class DivisorCalc {
    public static int gcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        } else {
            int temp = num1 % num2;
            return gcd(num2, temp);
        }
    }

    public static void main(String[] args) {
        System.out.println("最大公约数为："+gcd(9,6));
    }
}
