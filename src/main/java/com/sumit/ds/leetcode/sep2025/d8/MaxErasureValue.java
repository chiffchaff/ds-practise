package com.sumit.ds.leetcode.sep2025.d8;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/maximum-erasure-value/description/
 */
public class MaxErasureValue {
    public int maximumUniqueSubarray(int[] nums) {
        int maxSum = 0, l=0,r=0,sum=0,n=nums.length;
        Set<Integer> set = new HashSet();
        while(l<=r && r<n){
            while(r < n && !set.contains(nums[r]) ){
                set.add(Integer.valueOf(nums[r]));
                sum+=nums[r];
                r++;
            }
            maxSum=Math.max(maxSum,sum);
            if(l<n && set.contains(nums[l]) ){
                set.remove(Integer.valueOf(nums[l]));
                sum -=nums[l];
                l++;
            }
        }
        return maxSum;
    }

    @Test
    public void testing(){
        MaxErasureValue mx = new MaxErasureValue();
//        Assert.assertEquals(17,mx.maximumUniqueSubarray(new int[] {4,2,4,5,6}));
        Assert.assertEquals(17,mx.maximumUniqueSubarray(new int[] {4,2,2,4,5,6}));
    }
}
