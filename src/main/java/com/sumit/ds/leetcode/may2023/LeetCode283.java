package com.sumit.ds.leetcode.may2023;

import org.junit.Test;

/**
 * 283. Move Zeroes
 * https://leetcode.com/problems/move-zeroes/
 */
public class LeetCode283 {
    public int[] moveZeroes(int[] nums) {
        int []nums1= new int[nums.length];
        int counter=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                nums1[counter++]=nums[i];
            }
        }
        nums=nums1;
        return nums;
    }

    public int[] moveZeroes1(int[] nums) {
        int index=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                nums[index++]=nums[i];
            }
        }
        for(int i=index;i<nums.length;i++){
            nums[i]=0;
        }
        return nums;
    }

    @Test public void testing(){
        int [] in = {0,1,0,3,12};
        //int []nums = moveZeroes(in);
        int []nums = moveZeroes1(in);
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }

    }
}
