package com.sumit.ds.leetcode.apr2023;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * 581. Shortest Unsorted Continuous Subarray
 */
public class LeetCode581 {
    /**
     * Using two stacks for tracking minimum index and max index
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int left = n, right = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                left = Math.min(left, stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                right = Math.max(right, stack.pop());
            }
            stack.push(i);
        }
        return right - left > 0 ? right - left + 1 : 0;
    }


    /**
     * Step 1: Use simple looping to find the min and max element that needs to be placed in correct order
     * Step 2: Find the index of correct position of the min element from left
     *          and correct position of the max element from right
     * Step 3: Min no of elements to be shifted = (right index - left index) + 1
     * @param nums
     * @return
     */
    public int findUnsortedSubarray1(int[] nums){
        int result =0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // since zero or 1 element is already sorted, no of elements to be sorted = 0
        if(nums.length > 1) {
            for (int i = 0; i < nums.length; i++) {
                if(i ==0){
                    if(nums[i] > nums[i + 1]){
                        min = Math.min(min, nums[i]);
                        max = Math.max(max,nums[i]);
                    }
                }
                else if(i == nums.length -1){
                    if(nums[i] < nums[i-1]){
                        min = Math.min(min, nums[i]);
                        max = Math.max(max,nums[i]);
                    }
                }
                else {
                    if (nums[i] > nums[i + 1] || nums[i] < nums[i - 1]) {
                        min = Math.min(min, nums[i]);
                        max = Math.max(max, nums[i]);
                    }
                }
            }

            //find the positions of min and max
            int left=0;
            for(;left<nums.length && nums[left] < min;left++);
            int right=nums.length-1;
            for(;right>=0 && nums[right] > max;right--);
            result = (right - left) + 1;
        }
        return result;
    }
    @Test
    public void test(){
//        int in[] = {2,4,8,10,6,12,15};
        int in[] = {1,5,7,2,9,6,8,10};
        System.out.println(findUnsortedSubarray(in));
//        System.out.println(findUnsortedSubarray1(in));
    }


    public static void main(String[] args) {
//        int [] input = {2,4,8,10,6,12,15};
//        int input[] = {-1,4,5,6,1,2,10};
        int input[]  = {1,2,3,4};

        Stack<Integer> st1 = new Stack();
        int startIndex = input.length;
        for(int i=0;i<input.length;i++){
            while(!st1.isEmpty() && input[st1.peek()] > input[i]){
                startIndex = Math.min(st1.pop(),startIndex);
            }
            st1.push(i);
        }
        int endIndex = 0;
        Stack<Integer> st2 = new Stack();
        for(int i=input.length-1;i>=0;i--){
            while(!st2.isEmpty() && input[st2.peek()] < input[i]){
                endIndex = Math.max(st2.pop(),endIndex);
            }
            st2.push(i);
        }
        System.out.println("Start Index:"+startIndex +" :EndIndex:"+endIndex);
    }
}
