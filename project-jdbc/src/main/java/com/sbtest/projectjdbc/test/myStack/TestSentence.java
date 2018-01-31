package com.sbtest.projectjdbc.test.myStack;

import org.springframework.util.StopWatch;

import java.util.Scanner;
import java.util.Stack;

public class TestSentence {
    public static void main(String[] args) {
        //I am a student,and my name is John.
        System.out.println("请输入一个句子：");
        Scanner scan = new Scanner(System.in);
        String temp = scan.nextLine();
        System.out.println(temp);
        Stack<Character> stack = new Stack<Character>();
        StopWatch sw = new StopWatch();
        sw.start();
        for(char tp: temp.toCharArray()){
            if(tp == ' '||tp == '.'||tp == ','){
                while(!stack.isEmpty()){
                    System.out.print(stack.pop());
                }
                System.out.print(tp);
            }else{
                stack.push(tp);
            }
        }
        sw.stop();
        System.out.println("\n用时"+sw.getTotalTimeMillis()+"ms");
    }
}
