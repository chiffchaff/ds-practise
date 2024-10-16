package com.sumit.ds.leetcode.nov2023.day4;

import org.junit.Test;

public class LeetCode2733 {
    public int findNonMinOrMax(int[] nums) {
        int res = -1;
        if (nums.length >= 3) {
            int z = nums[2];
            int x = Math.min(nums[0], nums[1]);
            int y = Math.max(nums[0], nums[1]);
            res = (y < z) ? y : (z < x) ? x : z;
        }
        return res;
    }
    @Test
    public void testing(){
        int [] nums = {3,2,1,4};
        System.out.println(findNonMinOrMax(nums));

    }
}
