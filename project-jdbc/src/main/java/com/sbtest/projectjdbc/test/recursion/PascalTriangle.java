package com.sbtest.projectjdbc.test.recursion;

import java.util.Scanner;

public class PascalTriangle {
    private static int MAX_LINE;
    private static int[][] triangle;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入帕斯卡三角形的行数N：");
        MAX_LINE = scan.nextInt();
        System.out.println("开始打印" + (MAX_LINE) + "行帕斯卡三角形");
        triangle = new int[MAX_LINE][MAX_LINE];
        //setTriangleValue();
        for (int i = 0; i < MAX_LINE; i++) {
            for (int j = 0; j < MAX_LINE; j++) {
                triangle[i][j] = setTriangleValue(i, j);
            }
        }
        toPrint();
    }

    /**
     * 递归法
     *
     * @param i
     * @param j
     * @return
     */
    private static int setTriangleValue(int i, int j) {
        if (j == 0) {
            return 1;
        } else if (j > i) {
            return 0;
        }
        return setTriangleValue(i - 1, j - 1) + setTriangleValue(i - 1, j);
    }

    /**
     * 迭代法
     */
    private static void setTriangleValue() {
        for (int i = 0; i <= MAX_LINE; i++) {
            for (int j = 0; j <= MAX_LINE; j++) {
                if (j == 0) {//第一列
                    triangle[i][j] = 1;
                } else if (j > i) {
                    triangle[i][j] = 0;
                } else {//其他行列
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
            }
        }
    }

    private static void toPrint() {
        for (int i = 0; i < MAX_LINE; i++) {
            for (int j = 0; j <= i; j++) {
                if (triangle[i][j] > 10) {
                    System.out.print(" ");
                }
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }
}
