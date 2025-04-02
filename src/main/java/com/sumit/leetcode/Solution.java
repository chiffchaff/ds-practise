package com.sumit.leetcode;

import org.junit.Test;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        int l=0;
        int r=nums.length-1;
        while(l<r){
            if(nums[r] == val){
                k++;
                r--;
            }
            else if(nums[l] == val){
                int temp = nums[l];
                nums[l]=nums[r];
                nums[r]=temp;
                k++;
                l++;
                r--;
            }
            else{
                l++;
            }
        }
        return nums.length-k;
    }
    @Test
    public void testing(){
        int [] input ={0,1,2,2,3,0,4,2};
        int val =2;
        System.out.println(removeElement(input,val));
    }

    @Test
    public void testing1(){
        int [] input ={0};
        int val =0;
        System.out.println(removeElement(input,val));
    }
}