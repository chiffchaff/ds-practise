package com.sumit.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class ProductofItself {
    public int[] productExceptSelf(int[] nums) {
        int output[]=new int[nums.length];
        int lp=1;
        for(int i=0;i<nums.length;i++){
            output[i]=lp*nums[i];
            lp=output[i];
        }
        int rp=1;
        for(int i=nums.length-1;i>=0;i--){
            if(i==0){
                output[i] = rp;
            }
            else {
                output[i] = output[i - 1] * rp;
            }
            rp = rp * nums[i];
        }
        return output;
    }
    @Test
    public void testing(){
//        int input[] = {1,2,3,4};
        int input[] = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(input)));
    }
}
