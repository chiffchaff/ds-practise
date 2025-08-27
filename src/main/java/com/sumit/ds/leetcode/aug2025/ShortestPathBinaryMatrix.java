package com.sumit.ds.leetcode.aug2025;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

//Leetcode 1091
public class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0)
            return -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1; //use grid itself to track distance
        int[][] directions = {
                {0, 1}, {0, -1},
                {1, 0}, {-1, 0},
                {-1, -1}, {1, 1},
                {-1, 1}, {1, -1}
        };
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0], col = curr[1];
            int dist = grid[row][col];
            if (row == n - 1 && col == n - 1) {
                return dist;
            }

            for (int[] dir : directions) {
                int newrow = row + dir[0];
                int newcol = col + dir[1];
                if (isValid(newrow, newcol, n) && grid[newrow][newcol] == 0) {
                    queue.offer(new int[]{newrow, newcol});
                    grid[newrow][newcol] = dist + 1;//mark as visited with distance
                }
            }
        }
        return -1;
    }

    private boolean isValid(int row, int col, int n) {
        return row >= 0 && col >= 0 && row < n && col < n;
    }

    @Test
    public void testUseCase() {
        //✅ Test Case 1: Basic Path
        assertShortestPathBinaryMatrix(new int[][]{
                {0, 1},
                {1, 0}
        }, 2);

        //✅ Test Case 2: No Path
        assertShortestPathBinaryMatrix(new int[][]{
                {1, 0},
                {0, 0}
        }, -1);

        //✅ Test Case 3: Path with diagonal
        assertShortestPathBinaryMatrix(new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        }, 4);

        //✅ Test Case 4: Start or end is blocked
        assertShortestPathBinaryMatrix(new int[][]{
                {1, 0},
                {0, 0}
        }, -1);
    }

    private void assertShortestPathBinaryMatrix(int[][] grid, int expected) {
        Assert.assertEquals(expected, new ShortestPathBinaryMatrix().shortestPathBinaryMatrix(grid));
    }

}
