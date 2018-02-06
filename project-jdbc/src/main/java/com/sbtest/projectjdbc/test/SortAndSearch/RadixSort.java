package com.sbtest.projectjdbc.test.SortAndSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 基数排序法
 * 排序4位数
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] list={7843,4568,8765,6542,7865,4532,9987,3241,6589,6622,1211};
        String temp;
        Integer numObj;
        int digit;
        int num;
        //Queue队列数组
        Queue<Integer>[] digitQueues=(LinkedList<Integer>[])(new LinkedList[10]);
        for(int digitVal=0;digitVal<=9;digitVal++){
            digitQueues[digitVal]=(Queue<Integer>)(new LinkedList<Integer>());
        }
        for(int position=0;position<=3;position++){
            for(int scan=0;scan<list.length;scan++){
                temp=String.valueOf(list[scan]);
                //Character.digit(char ch, int radix)方法 在指定的基数返回字符ch的数值。
                digit= Character.digit(temp.charAt(3-position),10);
                digitQueues[digit].add(new Integer(list[scan]));
            }
            //gather numbers back into list
            num=0;
            for(int digitVal=0;digitVal<=9;digitVal++){
                //从队列中提出这些数，接着再以恰当次序将它们存储回数组。
                while(!digitQueues[digitVal].isEmpty()){
                    numObj=digitQueues[digitVal].remove();
                    list[num]=numObj.intValue();
                    num++;
                }
            }
            //output the sorted list
            for(int scan=0;scan<list.length;scan++){
                System.out.println(list[scan]);
            }
        }

    }
}
