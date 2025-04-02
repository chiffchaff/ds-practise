package com.sumit.techdose.assignments.stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

//https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int [] nextGreaterElement = new int[nums.length];
        Arrays.fill(nextGreaterElement,-1);

        //Monotonically Decreasing Stack
        //Rule: if current element <= top of the stack, push index of current element
        // if current element > top of the stack, keep popping the top of the stack and update index nextGE
        // until current element <= top of stack
        for(int i=0;i<nums.length;i++){
            if(st.empty()){
                st.push(i);
            }
            while(!st.isEmpty() && nums[i]>nums[st.peek()]){
                int indexToUpdate = st.pop();
                nextGreaterElement[indexToUpdate]=nums[i]; //update the nextgreaterelement with current value
            }
            if(st.empty() || (!st.empty() && nums[i]<=nums[st.peek()]))
                st.push(i);
        }
        return nextGreaterElement;
    }

    @Test
    public void testing(){
//        int input[] = {1, 3, 2, 4};
//        int input[] = {6, 8, 0, 1, 3}; //[8,-1,1,3,-1]
//        int input[] = {10, 20, 30, 50}; //[20,30,50,-1]
        int input[] = {50, 40, 30, 10}; //[-1,-1,-1,-1]

        System.out.println(Arrays.toString(nextGreaterElement(input)));
    }
}

