package com.sumit.ds.leetcode.aug2025;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/count-islands-with-total-value-divisible-by-k/?envType=company&envId=intuit&favoriteSlug=intuit-six-months
 */
public class CountIslandInGrid {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        boolean [][] visited = new boolean[m][n];
        int count =0;
        //Traverse all cells
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //Start DFS if we find land & not visited
                if(grid[i][j]>0 && !visited[i][j]){
                    int []sum = new int[1];
                    dfs(grid,visited, i,j,sum);
                    if(sum[0] %k==0){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public void dfs(int[][]grid,boolean [][]visited,int i,int j,int[] sum){
        int m = grid.length;
        int n = grid[0].length;
        //Boundary & visited check
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==0 || visited[i][j]){
            return;
        }
        visited[i][j]=true;
        sum[0] +=grid[i][j];
        //4 directional dfs
        dfs(grid,visited, i-1,j,sum);
        dfs(grid,visited, i+1,j,sum);
        dfs(grid,visited, i,j-1,sum);
        dfs(grid,visited, i,j+1,sum);
    }

    @Test
    public void testing(){
        CountIslandInGrid cg = new CountIslandInGrid();
        //[[0,2,1,0,0],[0,5,0,0,5],[0,0,1,0,0],[0,1,4,7,0],[0,2,0,0,8]]
        Assert.assertEquals(2,cg.countIslands(new int[][]{{0,2,1,0,0},{0,5,0,0,5},{0,0,1,0,0},{0,1,4,7,0},{0,2,0,0,8}},5));
        //[[3,0,3,0],[0,3,0,3],[3,0,3,0]]
        Assert.assertEquals(6,cg.countIslands(new int[][]{{3,0,3,0},{0,3,0,3},{3,0,3,0}},3));

    }
}
