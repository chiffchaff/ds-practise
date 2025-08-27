package com.sumit.ds.leetcode.apr2025;
import org.junit.Test;

import java.util.*;

//Max Profit
public class LeetCode2291 {
    public long maximumProfit(int[] present, int[] future) {
        int n = present.length;
        List<int[]> gainList = new ArrayList<>();

        // Step 1 & 2: Create (price, diff) pair
        for (int i = 0; i < n; i++) {
            int diff = future[i] - present[i];
            gainList.add(new int[]{present[i], diff});
        }

        // Step 3: Sort by diff descending, then price ascending
        gainList.sort((a, b) -> {
            if (b[1] != a[1]) return b[1] - a[1]; // Descending diff
            return a[0] - b[0]; // Ascending price
        });

        // Step 4: Nested iteration to calculate max gain
        long maxGain = 0;
        for (int i = 0; i < n; i++) {
            int price1 = gainList.get(i)[0];
            int gain1 = gainList.get(i)[1];
            if (gain1 <= 0) break; // No point in continuing

            long totalGain = 0;
            for (int j = i; j < n; j++) {
                int price2 = gainList.get(j)[0];
                int gain2 = gainList.get(j)[1];

                if (price2 >= price1) {
                    totalGain += gain2;
                }
            }

            maxGain = Math.max(maxGain, totalGain);
        }

        return maxGain;
    }

    @Test
    public void testing(){
        int[] present = {4, 2, 1, 10};
        int[] future = {10, 5, 2, 10};
        System.out.println(maximumProfit(present, future));  // Output: 12
    }
}