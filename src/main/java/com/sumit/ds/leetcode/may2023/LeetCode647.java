package com.sumit.ds.leetcode.may2023;

import org.junit.Test;

/**
 * 647. Palindromic Substrings
 */
public class LeetCode647 {
    public int countSubstrings(String s) {
        int count =0;
        int [][] dp = new int[s.length()][s.length()];
        //
        return count;
    }

    @Test
    public void testing(){
        String in = "aabaac";
        System.out.println("No of palindromic substring : "+countSubstrings(in));
    }
}


