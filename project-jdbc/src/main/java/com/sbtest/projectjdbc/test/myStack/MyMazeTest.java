package com.sbtest.projectjdbc.test.myStack;

import com.sbtest.projectjdbc.test.linkedStack.Position;

import java.util.Scanner;
import java.util.Stack;

/**
 * 回溯法解决4*5迷宫
 * 回溯法是一种不断试探且及时纠正错误的搜索方法，下面的求解过程采用回溯法。
 * 从入口出发，按某一方向向前探索，若能走通（未走过的），即某处可以到达，则到达一个新点，否则试探下一个方向；
 * 若所有的方向均没有通路，则沿原路返回前一点，换下一个方向继续试探，直到所有可能的通路都搜索到，或找到一条通路，或无路可走又返回到入口点。
 * 这里可以用一个栈来实现，每走一步，将该位置压入栈中，若该点无路可走，则出栈返回上一位置。
 */
public class MyMazeTest {
    private static int MAZE_ROW;
    private static int MAZE_COLUMN;
    private static int CAN_ARRIVE = 1;
    private static int ARRIVED = 2;
    private static int N = 0;
    private static Stack<Position> stack = null;
    private static Position mazein = new Position();
    private static Position mazeout = new Position();

    public static void main(String[] args) {
        // 迷宫定义
        // {{1, 1, 1, 1, 1},
        //  {1, 0, 1, 0, 1},
        //  {1, 1, 1, 1, 1},
        //  {1, 0, 1, 0, 1}};
        Scanner scan = new Scanner(System.in);
        System.out.print("请输入迷宫行数MAZE_ROW：");
        MAZE_ROW = scan.nextInt();
        System.out.print("请输入迷宫列数MAZE_COLUMN：");
        MAZE_COLUMN = scan.nextInt();
        int[][] maze = new int[MAZE_ROW][MAZE_COLUMN];

        System.out.println("请输入(MAZE_ROW * MAZE_COLUMN)迷宫(1表示可通过，0表示墙)：");
        for (int i = 0; i < MAZE_ROW; i++) {
            for (int j = 0; j < MAZE_COLUMN; j++) {
                maze[i][j] = scan.nextInt();
            }
        }
        toString(maze);
        do{
            System.out.print("请输入迷宫入口位置（MAZE_IN_X,MAZE_IN_Y）：");
            mazein.setX(scan.nextInt());
            mazein.setY(scan.nextInt());
        }while(isNotMaze(maze, mazein.getX(),mazein.getY()));
        maze[mazein.getX()][mazein.getY()] = ARRIVED;//默认已到达过
        do{
            System.out.print("请输入迷宫出口位置（MAZE_OUT_X,MAZE_OUT_Y）：");
            mazeout.setX(scan.nextInt());
            mazeout.setY(scan.nextInt());
        }while(isNotMaze(maze, mazeout.getX(),mazeout.getY()));
        if(path(maze,mazein,mazeout)){
            System.out.println("maze is solver!");
            //倒序
            Stack<Position> prt = new Stack<Position>();
            while(!stack.isEmpty()){
                prt.push(stack.pop());
            }
            System.out.print("(" + 0 + "," + 0 + ")");
            while(!prt.isEmpty()){
                Position pos = prt.pop();
                System.out.print("==>(" + pos.getX() + "," + pos.getY() + ")");
            }
            System.out.println();
        }else{
            System.out.println("maze is not solver!");
        }
    }

    //走出迷宫路线
    private static boolean path(int[][] maze,Position mazein,Position mazeout) {
        stack = new Stack<Position>();
        stack.push(mazein);
        int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};//正东，正南，正西，正北
        boolean flag = false;//成功标识
        while (!stack.isEmpty()) {
            Position temp = stack.pop();
            int i = 0;
            while (i < 4) {
                //先向正东试探
                int x = temp.getX() + move[i][0];
                int y = temp.getY() + move[i][1];
                if (isNotMaze(maze, x, y)) {
                    //试探下一个方向(正南，正西，正北)
                    i++;
                    continue;
                }
                if (maze[x][y] == CAN_ARRIVE) {//可以到达
                    temp = new Position(x, y);//temp
                    stack.push(temp);
                    maze[x][y] = ARRIVED;//到达新位置
                    if (x == mazeout.getX() && y == mazeout.getY()) {//是否到达出口
                        flag = true;
                        return flag;
                    } else {
                        i = 0;//重新初始化方向
                    }
                } else {
                    //试探下一个方向(正南，正西，正北)
                    i++;
                }
            }
        }
        return flag;
    }

    //如果不是迷宫位置，返回true;否则，返回false
    private static boolean isNotMaze(int[][] maze, int xx, int yy) {
        return xx < 0 || xx >= getMazeRow(maze) || yy < 0 || yy >= getMazeColumn(maze);
    }

    //返回迷宫行数
    private static int getMazeRow(int[][] maze) {
        return maze.length;
    }

    //返回迷宫列数
    private static int getMazeColumn(int[][] maze) {
        return maze[0].length;
    }

    //打印输出
    private static void toString(int[][] maze) {
        System.out.println("=============第" + N + "步===============");
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
        System.out.println("======================================");
    }
}
