package com.sbtest.projectjdbc.test.myStack;

import java.util.Stack;

/**
 * 回溯法是一种不断试探且及时纠正错误的搜索方法，下面的求解过程采用回溯法。
 * 从入口出发，按某一方向向前探索，若能走通（未走过的），即某处可以到达，则到达一个新点，否则试探下一个方向；
 * 若所有的方向均没有通路，则沿原路返回前一点，换下一个方向继续试探，直到所有可能的通路都搜索到，或找到一条通路，或无路可走又返回到入口点。
 * 这里可以用一个栈来实现，每走一步，将该位置压入栈中，若该点无路可走，则出栈返回上一位置。
 */
public class MazeTest {
//       {{0,0,0,0,0,0,0,0,0,0},
//        {0,1,0,0,0,1,0,0,0,0},
//        {0,0,1,0,1,0,0,0,0,0},
//        {0,1,0,1,1,1,1,1,0,0},
//        {0,1,0,0,0,1,0,0,0,0},
//        {0,0,1,1,0,0,1,1,1,0},
//        {0,1,0,0,1,1,0,0,1,0},
//        {0,0,0,0,0,0,0,0,0,0}};
    public static void main(String[] args) {
        // 迷宫定义
        int[][] maze = {{0,0,0,0,0,0,0,0,0,0},
                {0,1,0,0,0,1,0,0,0,0},
                {0,0,1,0,1,0,0,0,0,0},
                {0,1,0,1,1,1,1,1,0,0},
                {0,1,0,0,0,1,0,0,0,0},
                {0,0,1,1,0,0,1,1,1,0},
                {0,1,0,0,1,1,0,0,1,0},
                {0,0,0,0,0,0,0,0,0,0}};
        int[][] move = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
        Stack<Step> s = new Stack<Step>();
        int a = path(maze, move, s);
        while(!s.isEmpty()){
            Step step = s.pop();
            System.out.println(step.x+":"+step.y);
        }
    }
    public static int path(int[][] maze,int[][] move,Stack<Step> s){
        Step temp = new Step(1,1,-1); //起点
        s.push(temp);
        while(!s.isEmpty()){
            temp = s.pop();
            int x = temp.x;
            int y = temp.y;
            int d = temp.d+1;
            while(d<8){
                int i = x + move[d][0];
                int j = y + move[d][1];
                if(maze[i][j] == 1){    //该点可达
                    temp = new Step(i,j,d); //到达新点
                    s.push(temp);
                    x = i;
                    y = j;
                    maze[x][y] = 2;  //到达新点，标志已经到达
                    if(x == 6 && y == 8){
                        return 1;  //到达出口，迷宫有路，返回1
                    }else{
                        d = 0;  //重新初始化方向
                    }
                }else{
                    d++; //改变方向
                }
            }
        }
        return 0;
    }
}
