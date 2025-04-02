package com.sumit.techdose.assignments.stack;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

//Leetcode : 503
public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack();
        int []nge = new int[nums.length];
        Arrays.fill(nge,-1);

        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[i]>nums[st.peek()]){
                nge[st.pop()]=nums[i];
            }
            st.push(i);
        }

        for(int i=0;i<nums.length && !st.isEmpty();i++){
//            System.out.println("Processing for i="+i+ " nums[i]="+nums[i]+" nums[st.peek()]:"+nums[st.peek()] +" :st.peek():"+st.peek());
            while(!st.isEmpty() && nums[i]>nums[st.peek()]){
//                System.out.println("inside for i="+i+ " nums[i]="+nums[i]+" st.peek():"+nums[st.peek()] +" :st.peek():"+st.peek());
                nge[st.pop()]=nums[i];
            }
        }
        return nge;
    }
    @Test
    public void testing(){
//        int input[] = {1,2,1}; // [2,-1,2]
        int input[] = {5,6,3,8,4,7,1}; // [6,8,8,-1,7,8,5]
        System.out.println(Arrays.toString(nextGreaterElements(input)));
    }

}
