package com.sumit.leetcode;

import org.junit.Test;

import java.util.Arrays;

public class SquareArray {
    public int[] sortedSquares(int[] nums) {
        int lp=0;
        int n = nums.length;
        int rp=n-1;
        int res[] = new int[n];
        int i=n-1;
        while(lp<=rp){
            if(Math.abs(nums[lp])>Math.abs(nums[rp])){
                res[i]=square(nums[lp]);
                lp++;
            }
            else{
                res[i]=square(nums[rp]);
                rp--;
            }
            i--;
        }
        return res;
    }

    public int square(int n){
        return n * n;
    }

    @Test
    public void testing(){
        int [] input = {-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(input)));
    }

    @Test
    public void testing1(){
        int [] input = {-10000,-9999,-7,-5,0,0,10000};
        System.out.println(Arrays.toString(sortedSquares(input)));
    }
}