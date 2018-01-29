package com.sbtest.projectjdbc.test.linkedStack;

import com.sbtest.projectjdbc.test.linkedStack.Position;

import java.util.*;

/**
 * 解决4*5迷宫
 */
public class MyMaze {
    private static int n = 0;

    //1,1,1,1,1
    //1,0,1,0,1
    //1,1,1,1,1
    //1,0,1,0,1
    //(0,0)==>(0,1)==>(0,2)==>(0,3)==>(0,4)==>(1,4)==>(2,4)   ==>(2,3)==>(2,2)==>(2,1)==>(2,0)==>   (3,4)==>
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("迷宫入口位置 x y:");//0 2
        int inx = scan.nextInt();
        int iny = scan.nextInt();
        System.out.println("迷宫出口位置 x y:");//1 4
        int outx = scan.nextInt();
        int outy = scan.nextInt();
        int[][] maze = new int[][]{{1, 1, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 1, 1, 1, 1}, {1, 0, 1, 0, 1}};
        toString(maze);
        Stack<Position> stack = new Stack<Position>();
        List<Position> success = new ArrayList<Position>();
        stack.push(setPosition(inx, iny));//压入栈x=0,y=0，maze[0][0]=1,
        boolean falg = false;//结束条件
        while (!false && !stack.isEmpty()) {//栈不为空
            Position temp = stack.pop();//弹出栈
            int x = temp.getX();
            int y = temp.getY();
            maze[x][y] = 2;//表示已走过
            toString(maze);
            if (x == outx && y == outy) {
                success.add(temp);
                falg = true;
                break;
            } else {
                int sum = 0;
                //上下左右
                if (x - 1 >= 0) {//注意边界[0,n]
                    if (maze[x - 1][y] == 1) {
                        stack.push(setPosition(x - 1, y));//压入栈
                        sum++;
                    }
                }
                if (x + 1 < maze.length) {
                    if (maze[x + 1][y] == 1) {
                        stack.push(setPosition(x + 1, y));//压入栈
                        sum++;
                    }
                }
                if (y - 1 >= 0) {
                    if (maze[x][y - 1] == 1) {
                        stack.push(setPosition(x, y - 1));//压入栈
                        sum++;
                    }
                }
                if (y + 1 < maze[0].length) {
                    if (maze[x][y + 1] == 1) {
                        stack.push(setPosition(x, y + 1));//压入栈
                        sum++;
                    }
                }
                if (sum > 0) {
                    success.add(temp);
                }
            }
        }
        if (falg) {
            System.out.println("maze is solver!");
            //标记出一条成功的通道
            for (Position pos : success) {
                System.out.print("(" + pos.getX() + "," + pos.getY() + ")==>");
            }
        } else {
            System.out.println("maze is not solver!");
        }
    }

    private static Position setPosition(int x, int y) {
        Position newPosition = new Position();
        newPosition.setX(x);
        newPosition.setY(y);
        return newPosition;
    }

    private static void toString(int[][] maze) {
        //打印输出
        System.out.println("=============第" + n++ + "步===============");
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
        System.out.println("======================================");
    }
}
