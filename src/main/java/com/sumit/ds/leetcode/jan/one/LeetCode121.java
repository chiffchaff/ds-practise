package com.sumit.ds.leetcode.jan.one;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class LeetCode121 {
    public static void main(String[] args) {
        int [] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));

        System.out.println(maxProfit(new int []{7,1,2,5,0,1}));
    }

    public static int maxProfit(int[] prices) {
        int profit = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            // The day we should buy at
            min = Math.min(min, prices[i-1]);
            // Check if selling at the current day gives us the most profit
            profit = Math.max(prices[i]-min, profit);
        }
        return profit;
    }

}
