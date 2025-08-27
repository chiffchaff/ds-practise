package com.sumit.ds.leetcode.aug2025;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

//31. Next Permutation
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <=1)
            return;
        int i = nums.length - 2;
        //Step 1: Find first decreasing element from right
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }

        //Step 2: If such element is found, swap with next greater element on the right
        if(i>=0){
            int j = nums.length -1;
            while(nums[j]<=nums[i]){
                j--;
            }
            swap(nums,i,j);
        }

        //Step 3: Reverse the elements after index i (converting descending order to ascending order)
        reverse(nums,i+1,nums.length-1);
    }

    private void swap(int []nums, int i,int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    private void reverse(int [] nums, int left,int right){
        while(left < right){
            swap(nums,left++,right--);
        }
    }

    @Test
    public void testEdgeCases() {
        assertNextPermutation(new int[]{3, 2, 1}, new int[]{1, 2, 3});
        assertNextPermutation(new int[]{1, 1, 5}, new int[]{1, 5, 1});
        assertNextPermutation(new int[]{1, 2}, new int[]{2, 1});
        assertNextPermutation(new int[]{2, 1}, new int[]{1, 2});
        assertNextPermutation(new int[]{1}, new int[]{1});
        assertNextPermutation(new int[]{1, 3, 2}, new int[]{2, 1, 3});
        assertNextPermutation(new int[]{2, 2, 0, 1}, new int[]{2, 2, 1, 0});
    }

    private void assertNextPermutation(int[] input, int[] expected) {
        new NextPermutation().nextPermutation(input);
        Assert.assertArrayEquals(expected, input);
    }
}
