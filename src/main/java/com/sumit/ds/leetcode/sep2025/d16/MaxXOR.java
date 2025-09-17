package com.sumit.ds.leetcode.sep2025.d16;

import org.junit.Assert;
import org.junit.Test;

/**
 * TC = O(n)
 * SC = O(n)
 * https://leetcode.com/problems/maximum-xor-for-each-query/description/
 * https://www.youtube.com/watch?v=ES2dF8nO6yI
 */
public class MaxXOR {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int [] prefixXOR = new int[nums.length];
        prefixXOR[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            prefixXOR[i] = prefixXOR[i-1] ^ nums[i];
        }

        int [] result = new int[nums.length];
        int maxVal = (1 << maximumBit) - 1; // e.g., for maximumBit=3, maxVal=7 (binary: 111)
        for(int i=0;i<nums.length;i++){
            result[i] = prefixXOR[nums.length-i-1] ^ maxVal;
        }
        return result;
    }


    @Test
    public void testing(){
        MaxXOR maxXOR = new MaxXOR();
        Assert.assertArrayEquals(new int[]{0,3,2,3},maxXOR.getMaximumXor(new int[]{0,1,1,3},2));
        Assert.assertArrayEquals(new int[]{5,2,6,5},maxXOR.getMaximumXor(new int[]{2,3,4,7},3));
        Assert.assertArrayEquals(new int[]{4,3,6,4,6,7},maxXOR.getMaximumXor(new int[]{0,1,2,2,5,7},3));
    }
}

