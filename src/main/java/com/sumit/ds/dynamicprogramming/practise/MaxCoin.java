package com.sumit.ds.dynamicprogramming.practise;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Given n balloons, indexed from 0 to n-1.
 * Each balloon is painted with a number on it represented by array nums.
 * You are asked to burst all the balloons.
 * If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
 * Here left andright are adjacent indices of i. After the burst, the left and right then becomes adjacent.

 Find the maximum coins you can collect by bursting the balloons wisely.

 Note: 
 (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

 Example:

 Given [3, 1, 5, 8]

 Return 167

 nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> [] coins = 3*1*5 + 3*5*8 + 1*3*8 + 1*8*1 = 167
 * Created by root on 10/1/16.
 */
public class MaxCoin {

    public int maxCoin(int [] inputs){
        int maxCoins = 0;
        if(inputs == null)
            return maxCoins;
        else if(inputs.length == 1) {
            return 1 * inputs[0] * 1;
        }else
        {
            for(int i=0;i<inputs.length;i++){

            }

        }

        return maxCoins;
    }
}
