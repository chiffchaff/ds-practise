package com.sumit.ds.leetcode.may2023;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * 1143. Longest Common Subsequence
 * Dynamic Programming
 */
public class LeetCode1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int result = 0;
        int dp[][] = new int[text1.length()+1][text2.length()+1];
        //initially all the zero row and zero columns will be filled with zero
        //Default behaviour since int[] is initialized with zero

        for(int i=1;i<=text1.length();i++){
            for(int j=1;j<=text2.length();j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        result = dp[text1.length()][text2.length()];
        return result;
    }

    @ParameterizedTest
    @CsvSource({"sumit,amit"})
    public void testLongestCommonSubsequence(String s1,String s2){
        System.out.println("Longest common substring for string :"+s1 +" and:"+s2+" = "+longestCommonSubsequence(s1,s2));
    }
}

