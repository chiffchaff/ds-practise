package com.sumit.ds.leetcode.apr2023;

import org.junit.Test;

import java.util.Arrays;

public class LeetCode1381 {
    int[] stack;
    int top = 0;

    public LeetCode1381(int maxSize) {
        stack = new int[maxSize];
        Arrays.fill(stack,-1);
    }

    public void push(int x) {
        if (top < stack.length) {
            stack[top++] = x;
        }
    }

    public int pop() {
        if (top > 0) {
            int result = stack[--top];
            stack[top] = -1;
            return result;
        }
        return -1;
    }

    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(stack.length, k); i++) {
            stack[i] += val;
        }
    }

    public static void main(String[] args) {

            LeetCode1381 leetCode1381 = new LeetCode1381(3);
            leetCode1381.push(3);
            leetCode1381.push(1);
            System.out.println(leetCode1381.pop());
            leetCode1381.push(2);
            leetCode1381.push(3);
            leetCode1381.push(4);
            leetCode1381.increment(5,100);
            leetCode1381.increment(2,100);
            System.out.println(leetCode1381.pop());
            System.out.println(leetCode1381.pop());
            System.out.println(leetCode1381.pop());
            System.out.println(leetCode1381.pop());


    }
}


