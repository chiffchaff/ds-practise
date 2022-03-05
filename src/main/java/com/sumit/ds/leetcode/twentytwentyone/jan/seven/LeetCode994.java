package com.sumit.ds.leetcode.twentytwentyone.jan.seven;

import org.junit.Test;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/rotting-oranges/
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 */
public class LeetCode994 {
    class Point{
        int x;
        int y;
        Point(int i,int j){
            this.x = i;
            this.y=j;
        }
    }
    @Test
    public void test(){
        int grid[][] = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println("Number of minutes: "+orangesRotting(grid));

    }

    public int orangesRotting(int[][] grid) {
        LinkedList<Point> rottenOrangePlacements = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        // Find out initial rotten oranges in the grid
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == 2){
                    rottenOrangePlacements.offer(new Point(i,j));
                }
            }
        }

        // Find out min no of minutes for rotting all the oranges in the grid
        int minMinutesforRotting = -1;
        if(!rottenOrangePlacements.isEmpty()){
            minMinutesforRotting = 0;

            int movementGridRow[] = {-1,1,0,0};
            int movementGridCol[] = {0,0,-1,1};

            while(!rottenOrangePlacements.isEmpty()){
                for(int i=0;i<movementGridCol.length;i++){
                    Point rottenPoint = rottenOrangePlacements.poll();
                    //if(grid[rottenPoint.x + movementGridRow[i],rottenPoint.y)
                }
            }
        }

        return minMinutesforRotting;
    }


}
