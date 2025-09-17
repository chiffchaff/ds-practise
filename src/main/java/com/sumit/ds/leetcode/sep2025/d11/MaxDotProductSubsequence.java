package com.sumit.ds.leetcode.sep2025.d11;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/max-dot-product-of-two-subsequences/
 * Dynamic Programming, Recursion, Memonization
 * https://www.youtube.com/watch?v=D_z5uzy9ZV4
 * https://www.youtube.com/watch?v=xlQAIQNlC-w
 */
public class MaxDotProductSubsequence {


    public int maxDotProduct(int[] nums1, int[] nums2) {
        Integer[][] memo = new Integer[nums1.length][nums2.length];
        return maxDotProductHelper(nums1, nums2, 0, 0, memo);
    }

    public int maxDotProductHelper(int[] nums1, int[] nums2, int i, int j, Integer[][] memo) {
        if (i >= nums1.length || j >= nums2.length) {
//            return 0;
            return Integer.MIN_VALUE / 2; // Avoid overflow
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        int product = nums1[i] * nums2[j];
        int include = product + Math.max(maxDotProductHelper(nums1, nums2, i + 1, j + 1, memo), 0);
        int skipNums1 = maxDotProductHelper(nums1, nums2, i + 1, j, memo);
        int skipNums2 = maxDotProductHelper(nums1, nums2, i, j + 1, memo);
        return memo[i][j] = Math.max(include, Math.max(skipNums1, skipNums2));
    }

    public int maxDotProduct1(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];

        // Initialize DP array with a very large negative value
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE / 2); // Use /2 to avoid overflow
        }

        // Fill DP table
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                int product = nums1[i - 1] * nums2[j - 1];
                dp[i][j] = Math.max(
                        product + Math.max(dp[i - 1][j - 1], 0), // Include current pair
                        Math.max(dp[i - 1][j], dp[i][j - 1])     // Skip from nums1 or nums2
                );
            }
        }
        return dp[n1][n2];
    }


    @Test
    public void testing() {
        MaxDotProductSubsequence ms = new MaxDotProductSubsequence();
        Assert.assertEquals(18, ms.maxDotProduct(new int[]{2, 1, -2, 5}, new int[]{3, 0, -6}));
        Assert.assertEquals(21, ms.maxDotProduct(new int[]{3, -2}, new int[]{2, -6, 7}));
        //Edge Case
        Assert.assertEquals(-1, ms.maxDotProduct(new int[]{-1, -1}, new int[]{1, 1}));
        Assert.assertEquals(-1, ms.maxDotProduct(new int[]{-1, -3}, new int[]{1, 2}));

        Assert.assertEquals(18, ms.maxDotProduct1(new int[]{2, 1, -2, 5}, new int[]{3, 0, -6}));
        Assert.assertEquals(21, ms.maxDotProduct1(new int[]{3, -2}, new int[]{2, -6, 7}));
        //Egde Case
        Assert.assertEquals(-1, ms.maxDotProduct1(new int[]{-1, -1}, new int[]{1, 1}));
        Assert.assertEquals(-1, ms.maxDotProduct1(new int[]{-1, -3}, new int[]{1, 2}));

    }
}
