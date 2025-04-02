package com.sumit.techdose.assignments.arrays;

import org.junit.Test;
//LeetCode: 153
public class FindMinInRotatedArray {
    public int findMin(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int left = 0;
        int right = nums.length -1;
        int min = Integer.MAX_VALUE;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(left==right){
                min = Math.min(min,nums[left]);
                break;
            }
            else if(nums[left]<=nums[mid]){ //left subarray is sorted
                min = Math.min(min,nums[left]);
                left = mid+1;
            }
            else{ // right subarray shld be sorted since its asc order rotated array
                min = Math.min(min,nums[mid]);
                right = mid-1;
            }
        }
        return min;
    }
    @Test
    public void testing(){
        int [] input = {11,13,15,17};
//        int [] input = {4,5,6,7,0,1,2};
//        int [] input = {3,4,5,1,2};
//        int [] input = {4,5,0,1,2};
        System.out.println(findMin(input));
    }
}
