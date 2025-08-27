package com.sumit.ds.leetcode.aug2025;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int [] result = new int[temperatures.length];
        Stack<Integer> st = new Stack<>(); //Monotonically decreasing stack
        for(int i=0;i<temperatures.length;i++){
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                int index = st.pop();
                result[index] = i- index;
            }
            st.push(i);
        }
        return result;
    }

    @Test
    public void testing(){
        DailyTemperatures d = new DailyTemperatures();

        Assert.assertArrayEquals(new int[]{1,0},d.dailyTemperatures(new int[] {73,74}));
        Assert.assertArrayEquals(new int[]{0,0},d.dailyTemperatures(new int[] {74,73}));
        Assert.assertArrayEquals(new int[]{2,1,0},d.dailyTemperatures(new int[] {73,73,75}));
        Assert.assertArrayEquals(new int[]{2,1,0,0},d.dailyTemperatures(new int[] {73,73,75,72}));
        Assert.assertArrayEquals(new int[]{2,1,2,1,0},d.dailyTemperatures(new int[] {73,73,75,72,80}));

    }
}
