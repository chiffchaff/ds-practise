package com.sumit.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int sum=0;
        int result=0;
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                sum = nums[i]+nums[j]+nums[k];
                if(Math.abs(diff)> Math.abs(target - sum)){
                    diff = Math.abs(target - sum);
                    result = sum;
                }
                if(sum > target){
                    k--;
                }
                else{
                    j++;
                }
            }
        }
        return result;
    }

    @Test
    public void testing(){
        int [] input = {-1,2,1,-4};
        int target = 1;
        int result = threeSumClosest(input,target);
        Assert.assertEquals(2,result);
    }

    @Test
    public void testing1(){
        int [] input = {1,1,1,0};
        int target = -100;
        int result = threeSumClosest(input,target);
        Assert.assertEquals(2,result);
    }
}

