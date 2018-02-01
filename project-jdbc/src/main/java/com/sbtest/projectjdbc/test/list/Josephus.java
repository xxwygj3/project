package com.sbtest.projectjdbc.test.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Josephus问题
 * 传说他是41个被捕后宁愿自杀也不愿向罗马屈服的犹太叛逆者之一。
 * 他们决定排成一圈，然后每数3个人就自杀一人，直到剩下一个。
 * Josephus并不想死，他计算出了他应该站的位置，那样他就可以活到最后一个，就不用去死了。
 */
public class Josephus {
    public static void main(String[] args) {
        int numPeople, skip, targetIndex;
        List<String> list = new ArrayList<String>();
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of soldiers:");
        numPeople = in.nextInt();
        in.nextLine();

        System.out.print("Enter the number of soldiers to skip:");
        skip = in.nextInt();

        for (int count = 1; count <= numPeople; count++) {
            list.add("Soldier " + count);
        }

        targetIndex = skip - 1;
        System.out.println("The order is: ");

        while (!list.isEmpty()) {
            System.out.println(list.remove(targetIndex));
            if (list.size() > 0) {
                targetIndex = (targetIndex + (skip - 1)) % list.size();
            }
        }
    }
}
