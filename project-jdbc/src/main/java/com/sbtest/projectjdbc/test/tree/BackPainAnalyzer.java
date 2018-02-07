package com.sbtest.projectjdbc.test.tree;

import java.io.FileNotFoundException;

public class BackPainAnalyzer {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("So,you're having back pain.");
        DecisionTree expert = new DecisionTree("input.txt");
        expert.evaluate();
    }
}
