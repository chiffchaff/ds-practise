package com.sumit.techdose.assignments.arrays;

import org.junit.Test;

//LeetCode: 33
public class SearchInRotatedArray {
    public int search1(int[] nums, int target) {
        int result = -1;

        if(nums.length==1){
            return (nums[0]==target)?0:-1;
        }

        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                result= mid;
                break;
            }
            else if((nums[left]<=target && target <= nums[mid]) || (nums[left]==target)){ //if target is in the left subarray
                //perform binary search on left subarray
                right = mid-1;
            }
            else{//target might be on right subarray, perform binary serch on right subarray
                left=mid+1;
            }

        }
        return result;
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int result = -1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                result=mid;
                break;
            }
            else if(nums[left]<=nums[mid]){ //if left subarray is in strictly increasing order
                if(nums[left] >=target && target <=nums[mid]){ //check if target is within range of left and mid index
                    right=mid-1; //target may be on left subarray
                }
                else{
                    left=mid+1;//target may be on right subarray
                }
            }
            else{//then right subarray is strictly increasing order
                if(nums[mid]>=target && target <=nums[right]){ // check if target is within range of mid and right index
                    left=mid+1; //search on the right subarray
                }
                else{
                    right=mid-1;//search on the left subarray
                }
            }
        }
        return result;
    }

    @Test
    public void testing(){
        int [] input = {5,1,2,3,4};
        int target = 1;
        System.out.println(search(input,target));
    }
}
