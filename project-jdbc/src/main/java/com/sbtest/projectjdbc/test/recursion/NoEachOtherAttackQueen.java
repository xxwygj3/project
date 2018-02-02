package com.sbtest.projectjdbc.test.recursion;

import com.sbtest.projectjdbc.test.linkedStack.Position;

import java.util.*;

public class NoEachOtherAttackQueen {
    private static Set<String> checkerboardSet = new HashSet<String>();
    private static int[][] checkerboard = new int[8][8];
    private static List<List<Position>> posList = new ArrayList<List<Position>>();
    private static List<Position> pos;
    private static int EXIST = 1;

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                initCheckerboard();
                pos = new ArrayList<Position>();
                //EXIST = 1;
                //System.out.println("-----------------第一个皇后位置：(" + i + "," + j + ")----------------");
                //checkerboard[i][j] = EXIST++;
                checkerboard[i][j] = EXIST;
                pos.add(new Position(i, j));
                solveEightQueen();
                //System.out.println("-------------------------------------------------------------");
            }
        }
        System.out.println("共有" + posList.size() + "方法");
        //toPrintList();
        System.out.println("删除重复的方法后，还有" + checkerboardSet.size() + "方法");
        toPrintSet();
    }

    private static void solveEightQueen() {
        //8个互不攻击皇后=第8个皇后与共7个皇后互不攻击
        if (pos.size() == 8) {
            //toPrint();
            String result = toCheckString();
            System.out.println(result);
            checkerboardSet.add(result);//会自动去重
            posList.add(pos);
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    //2个互不攻击皇后=第2个皇后与共1个皇后互不攻击
                    if (!isAttack(i, j)) {
                        //checkerboard[i][j] = EXIST++;
                        checkerboard[i][j] = EXIST;
                        pos.add(new Position(i, j));
                        solveEightQueen();
                    }
                }
            }
        }
    }

    /**
     * 判断是否会互相攻击，是，返回true
     *
     * @param x
     * @param y
     * @return
     */
    private static boolean isAttack(int x, int y) {
        if (x < 0 || x >= 8 || y < 0 || y >= 8) {//棋盘越界
            return true;
        }
        if (checkerboard[x][y] != 0) {//该位置皇后已存在
            return true;
        }
        // 不同行i 不同列j 不同对角线 左对角线i=j 右对角线j+j==7
        for (Position temp : pos) {
            if (x == temp.getX() || y == temp.getY()) {
                return true;
            }
            if (x == y && temp.getX() == temp.getY()) {
                return true;
            }
            if (x + y == 7 && temp.getX() + temp.getY() == 7) {
                return true;
            }
        }
        return false;
    }

    private static void initCheckerboard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                checkerboard[i][j] = 0;//表示该位置未落子
            }
        }
    }

    private static String toCheckString(){
        String result ="";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                result += checkerboard[i][j];
            }
        }
        return result;
    }

    private static void toPrintSet(){
        for(String value:checkerboardSet){
            System.out.println(value);
        }
    }

    private static void toPrint() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(checkerboard[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void toPrintList() {
        int n = 1;
        System.out.println("-----------------------------第" + n + "种方法--------------------------------");
        for (List<Position> list : posList) {
            for (Position pos : list) {
                System.out.print("(" + pos.getX() + "," + pos.getY() + ")==>");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------");
    }
}
