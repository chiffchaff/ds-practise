package com.sumit.ds.leetcode.apr2023;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * 739. Daily Temperatures
 */
public class LeetCode739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Iterate through the temperatures array from left to right
        for (int i = 0; i < n; i++) {
            // Pop temperatures off the stack while the current temperature is greater than the stack's top temperature
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }

    @Test
    public void testDailyTemperatures(){
        int [] temps = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temps)));
    }

}

