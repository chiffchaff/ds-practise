package com.sumit.leetcode;

import org.junit.Test;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 */
public class SearchInRotatedSortedArray {

    public static int search(int [] nums,int target){
        int n = nums.length;
        int left =0;
        int right = n-1;
        int mid;
        while (left <= right){
            mid = left + (right -left)/2;
            if(nums[mid] == target){
                return mid;
            }
            else{
                //First find which slope the target might be present
                if(nums[left] <= nums[mid]){ //First slope
                    if(target > nums[mid] || target < nums[left]){
                        left = mid + 1;
                    }
                    else{ //i.e target may be on the right side of mid
                        right = mid - 1;
                    }
                }
                else{ //second slope
                    if(target < nums[mid] || target > nums[right]){
                        right = mid -1;
                    }
                    else{
                        left = mid + 1;
                    }
                }
            }
        }
        return -1;
    }

    @Test
    public void testing(){
        int [] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums,target));
    }

    @Test
    public void testing1(){
        int [] nums = {1,3};
        int target = 3;
        System.out.println(search(nums,target));
    }
}
