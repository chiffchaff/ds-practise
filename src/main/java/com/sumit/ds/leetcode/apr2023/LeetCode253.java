package com.sumit.ds.leetcode.apr2023;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * 253. Meeting Rooms II
 */
public class LeetCode253 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals,(a, b)->(a[0]-b[0]));
        Stack<Integer> st = new Stack<>();
        for(int[] interval:intervals){
            if(!st.isEmpty() && st.peek() <= interval[0]){
                st.pop();
            }
            st.push(interval[1]);
        }
        return st.size();
    }

    @Test
    public void testCode(){
//        int input [][] = {{0,30}, {5,10},{15,20}};
        int input [][] = {{7,10},{2,4}};
        System.out.println(minMeetingRooms(input));
    }
}
