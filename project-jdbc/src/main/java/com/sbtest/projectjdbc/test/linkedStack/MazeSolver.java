package com.sbtest.projectjdbc.test.linkedStack;

import java.io.FileNotFoundException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 迷宫解决
 */
public class MazeSolver {
    private Maze maze;
    private static Stack<Position> stack = new Stack<Position>();


    public MazeSolver(Maze maze) {
        this.maze = maze;
    }

    /**
     * 回溯法
     * @return
     */
    public boolean traverse() {
        boolean done = false;
        int row, column;
        Position pos = new Position();
        Deque<Position> stack = new LinkedList<Position>();
        stack.push(pos);
        while (!(done) && !stack.isEmpty()) {
            pos = stack.pop();
            // this cell has been tried
            maze.tryPosition(pos.getX(), pos.getY());
            if (pos.getX() == maze.getRows() - 1 && pos.getY() == maze.getColumns() - 1) {
                done = true;//the maze is solved
            } else {
                push_new_pos(pos.getX()-1,pos.getY(),stack);
                push_new_pos(pos.getX()+1,pos.getY(),stack);
                push_new_pos(pos.getX(),pos.getY()-1,stack);
                push_new_pos(pos.getX(),pos.getY()+1,stack);
            }
        }
        return done;
    }

    /**
     * 递归法
     * @param row
     * @param column
     * @return
     */
    public boolean traverse(int row, int column) {
        boolean done = false;
        if(maze.validPosition(row,column)){
            maze.tryPosition(row,column);
            if(row == maze.getRows()-1 && column == maze.getColumns()-1){
                done = true;
            }else {
                done = traverse(row+1,column);//正南
                if(!done){
                    done = traverse(row,column+1);//正东
                }
                if(!done){
                    done = traverse(row-1,column);//正北
                }
                if(!done){
                    done = traverse(row,column-1);//正西
                }
            }
            if(done){
                maze.markPath(row,column);
                stack.push(new Position(row,column));
            }
        }
        return done;
    }

    private void push_new_pos(int x,int y,Deque<Position> stack){
        Position npos = new Position();
        npos.setX(x);
        npos.setY(y);
        if(maze.validPosition(x,y)){
            stack.push(npos);
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        Scanner scan = new Scanner(System.in);
        //d://test_maze_9_13.txt
        System.out.println("Enter the name of the file containing the maze:");
        String filename = scan.nextLine();
        Maze labyrinth = new Maze(filename);
        System.out.println(labyrinth);
        MazeSolver solver = new MazeSolver(labyrinth);
//        //回溯法
//        if(solver.traverse()){
//            System.out.println("The maze was successfully traversed!");
//        }else {
//            System.out.println("There is no possible path.");
//        }
        System.out.println(labyrinth);
        //递归法
        if (solver.traverse(0, 0)) {
            System.out.println("The maze was successfully traversed!");
            while (!stack.isEmpty()){
                Position pos = stack.pop();
                System.out.print("("+pos.getX()+","+pos.getY()+")==>");
            }
        } else {
            System.out.println("There is no possible path.");
        }
        System.out.println(labyrinth);
    }

}
