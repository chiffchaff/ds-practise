package com.sumit.ds.leetcode.jan.two;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-colors/
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 */
public class LeetCode75 {

    @Test
    public void test(){
        {
            int input[] = {2, 0, 2, 1, 1, 0};
            callSort(input);
        }
        {
            int input [] = {1,1,1,0,0,2};
            callSort(input);
        }
        {
            int input [] = {2,2,2,2,2,2,2,1};
            callSort(input);
        }
        {
            int input [] = {};
            callSort(input);
        }
        {
            int input [] = {1};
            callSort(input);
        }
        {
            int input [] = {2};
            callSort(input);
        }
        {
            int input [] = {0};
            callSort(input);
        }
        {
            int input [] = {1,1,1};
            callSort(input);
        }
        {
            int input [] = {2,2,0};
            callSort(input);
        }
    }

    private void callSort(int[] input) {
        System.out.println("-----------");
        System.out.println("Before Sorting:" + Arrays.toString(input));
        sortColors(input);
        System.out.println("After Sorting:" + Arrays.toString(input));
        System.out.println("-------------");
    }

    public void sortColors(int[] nums) {
        int left=-1;
        int right=nums.length;
        int i =0;
        while(i<right){
            if(nums[i] == 0){
                nums[i] = nums[++left];
                nums[left]=0;
            }
            else if(nums[i] == 2 ){
                nums[i] = nums[--right];
                nums[right]=2;
                i-=1;
            }
            i+=1;
        }
    }
}
