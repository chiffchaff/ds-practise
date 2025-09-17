package com.sumit.ds.leetcode.sep2025.d9;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/maximum-profit-of-operating-a-centennial-wheel/description/
 */
public class MaxProfit {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int seats = 4, rem =0, profit = 0, trounds=0;
        for(int cs:customers){
            int rounds = (cs+rem)/seats;
            rem = (cs+rem)%seats;
            if(rounds ==0 && rem != 0){
                rounds=1;
                rem=0;
            }
            int tBoardingCost = boardingCost * ((rem==0)? seats * rounds:rem * rounds);
            profit += tBoardingCost - (runningCost * rounds);
            trounds += rounds;
        }
        if(rem != 0){
            profit += boardingCost * rem - runningCost;
            trounds++;
        }
        return (profit >=0)?trounds:-1;
    }

    @Test
    public void testing(){
        MaxProfit mx = new MaxProfit();
//        Assert.assertEquals(3,mx.minOperationsMaxProfit(new int[]{8,3},5,6));
//        Assert.assertEquals(7,mx.minOperationsMaxProfit(new int[]{10,9,6},6,4));
//        Assert.assertEquals(-1,mx.minOperationsMaxProfit(new int[]{3,4,0,5,1},1,92));
        Assert.assertEquals(9,mx.minOperationsMaxProfit(new int[]{10,10,6,4,7},3,8));
    }

}
