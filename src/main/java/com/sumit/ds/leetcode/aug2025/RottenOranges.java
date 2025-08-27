package com.sumit.ds.leetcode.aug2025;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

//Leetcode #994
public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        if (grid == null && grid.length == 0) return -1;

        int rows = grid.length;
        int cols = grid[0].length;
        int freshCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        //Step 1: Scan thru the grid to find out rotten orange location and count number of fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1)
                    freshCount++;
            }
        }
        //There's no fresh oranges, so time to rot is 0
        if (freshCount == 0) return 0;

        //Step 2: BFS Traversal
        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean infested = false;

            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                int r = pos[0];
                int c = pos[1];

                for (int[] dir : directions) {
                    int newRow = r + dir[0];
                    int newCol = c + dir[1];
                    //infest adjucent fresh oranges
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        freshCount--;
                        queue.offer(new int[]{newRow, newCol});
                        infested = true;
                    }
                }
            }
            if (infested) minutes++;
        }

        return freshCount == 0 ? minutes : -1;
    }

    @Test
    public void testEdgeCases() {
        //✅ Edge Case 1: No fresh oranges
        assertRottingTime(new int[][]{
                {0, 2, 0},
                {0, 0, 0},
                {2, 0, 0}
        }, 0);

        //✅ Edge Case 2: No rotten oranges
        assertRottingTime(new int[][]{
                {1, 1, 1},
                {1, 1, 1}
        }, -1);

        //✅ Edge Case 3: All oranges already rotten
        assertRottingTime(new int[][]{
                {2, 2},
                {2, 2}
        }, 0);

        //✅ Edge Case 4: Rotten orange completely isolated
        assertRottingTime(new int[][]{
                {2, 0, 1}
        }, -1);

        //✅ Edge Case 6: Multiple rotten sources spreading
        assertRottingTime(new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 2}
        }, 2);

        //✅ Edge Case 7: Large grid with unreachable fresh oranges
        assertRottingTime(new int[][]{
                {2,1,1,0,1},
                {0,0,0,0,0},
                {1,1,1,1,1}
        }, -1);

        //✅ Edge Case 8: Empty grid
        assertRottingTime(new int[][]{
                {}
        }, 0);


    }

    private void assertRottingTime(int[][] grid, int expected) {
        Assert.assertEquals(expected, new RottenOranges().orangesRotting(grid));
    }

}
