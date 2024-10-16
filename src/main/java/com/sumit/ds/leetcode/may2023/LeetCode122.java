package com.sumit.ds.leetcode.may2023;

import org.junit.Test;

/**
 * 122. Best Time to Buy and Sell Stock II
 */
public class LeetCode122 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i=1;i <prices.length;i++){
            if(prices[i] > prices[i-1]){
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }

    @Test public void testing(){
//        int [] prices = {7,1,5,3,6,4};
        int [] prices = {1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }

}
