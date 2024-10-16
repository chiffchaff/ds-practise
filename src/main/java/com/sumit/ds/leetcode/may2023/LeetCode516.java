package com.sumit.ds.leetcode.may2023;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * 516. Longest Palindromic Subsequence
 */
public class LeetCode516 {
    public int longestPalindromeSubseq(String s) {
        int dp [][]= new int[s.length()][s.length()];
        //fill all the single length strings to 1
        for(int i=0;i<s.length();i++){
            dp[i][i]=1;
        }

        //fill all the two length strings
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1) == s.charAt(i)) {
                dp[i - 1][i] = 1;
            }
        }

        //now fill the result for string length greater than or equal to 3
        for(int j=2;j<s.length();j++) {
            for (int i = 0; i < s.length(); i++) {
//                if (s.charAt(i) == s.charAt(j) && dp[start + 1][end - 1] == 1) {
//                    dp[start][end] = 1;
//                }
                System.out.println("(i,j):("+i+","+j+")");
            }
        }
        return 0;
    }

    @ParameterizedTest
    @CsvSource({"aaaabbaa"})
    public void testLongestPanlindromicSubseq(String s){
        System.out.println("Longest Parlindromic subsequence for string :"+s +" is:"+longestPalindromeSubseq(s));
    }

    @Test
    public void testing(){
        int size =5;
        for(int len=1;len<size;len++) {
            System.out.println("Pairs::");
            for (int i = 0; i < size; i++) {
                int j = (len - i) +1;
                System.out.print("("+i+","+j+")");
            }
            System.out.println();
        }
        }

}
