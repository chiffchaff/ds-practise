package com.sumit.ds.leetcode.may2023;

import org.junit.Test;

public class LeetCode162 {
    public int findPeakElement(int[] nums) {
        int index = Integer.MIN_VALUE;
        for(int i=1;i<nums.length-1;i++){
            if(nums[i]>nums[i-1] && nums[i] > nums[i+1]){
                index=i;
            }
        }
        return index;
    }

    @Test
    public void testing(){
        int in[] = { 1,2,3,1};
        System.out.println(findPeakElement(in));

    }
}
