package com.sbtest.projectjdbc.test.recursion;

/**
 * 汉诺塔
 * ABC三个柱子,3个盘片在A柱子(上到下是小盘到大盘),要求把盘片移动到C柱子
 * 移动过程中,柱子不能出现小盘在下面,
 * A柱子的3个盘子,两个盘子肯定借助C移动到B,完成一个大阶段:
 * 当A柱子的只剩下最大盘子,那么移动到C
 * B柱子的两个盘借助A移动到C
 */
public class TowersOfHanoi {
    private int moveCount;//移动次数
    private int totalDisks;

    public TowersOfHanoi(int disks) {
        this.moveCount = 0;
        this.totalDisks = disks;
    }

    public void solve() {
        moveTower(totalDisks, 'A', 'B', 'C');
        System.out.println("共移动" + moveCount + "次");
    }

    private void moveTower(int moveNum, char start, char temp, char end) {
        moveCount++;
        //只有一个时,A把("第"n)个移动到C
        if (moveNum == 1) {
            moveOneDisk(moveNum, start, end);
        } else {
            //System.out.println(start + "柱借" + end + "柱把(共" + (moveNum - 1) + "个)移动到" + temp + "柱");
            moveTower(moveNum - 1, start, end, temp);//A借C把("共"n-1个)移动到B
            moveOneDisk(moveNum, start, end);
            //System.out.println(temp + "柱借" + start + "柱把(共" + (moveNum - 1) + "个)移动到" + end + "柱");
            moveTower(moveNum - 1, temp, start, end);//B借A把("共"n-1)个移动到C
        }
    }

    private void moveOneDisk(int diskNumber, char start, char end) {
        System.out.println("from - " + start + "柱 " + " move " + diskNumber + " to " + end + "柱");
    }

    public static void main(String[] args) {
        TowersOfHanoi towers = new TowersOfHanoi(4);
        towers.solve();
    }

}
