package com.sumit.ds.leetcode.mar2023;

import org.junit.Test;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class LeetCode121 {

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0;i<prices.length;i++){
            minPrice = Math.min(minPrice,prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }
    @Test
    public void testing(){
        int [] input = {7,1,5,3,6,4};
        System.out.println(LeetCode121.maxProfit(input));
    }
}
