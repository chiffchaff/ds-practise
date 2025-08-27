package com.sumit.leetcode;

//Leetcode #200
//https://leetcode.com/problems/number-of-islands/description/
public class NoOfIslands {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int noOfIslands=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){
                    markCurrentIsland(grid,i,j,rows,cols);
                    noOfIslands+=1;
                }
            }
        }
        return noOfIslands;
    }

    private void markCurrentIsland(char[][] grid, int x, int y, int rows, int cols) {
        if(x<0 || x>=rows|| y<0 || y>=cols || grid[x][y]!='1'){ //Boundary Case
            return;
        }
        grid[x][y]='2'; // mark as visited
        markCurrentIsland(grid,x,y+1,rows,cols);//down
        markCurrentIsland(grid,x,y-1,rows,cols);//up
        markCurrentIsland(grid,x-1,y,rows,cols);//left
        markCurrentIsland(grid,x+1,y,rows,cols);//right
    }
}
