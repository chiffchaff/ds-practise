package com.sumit.ds.leetcode.may2023;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import javax.print.attribute.standard.PresentationDirection;
import java.util.ArrayList;
import java.util.List;


/**
 * Longest Palindromic Substring
 */
public class LeetCode5 {
    public String longestPalindromeUsingTabulation(String s) {
        String ans = "";
        List<String> allPalindromes = new ArrayList<>();
        if(s == null) //input is null
            return ans;
        if(s.length() <=1){ //input is empty string or 1 length string
            return s;
        }
        int[][] dp = new int[s.length()][s.length()];

        //Fill for substring with length 1
        for(int i=0;i<s.length();i++){
            dp[i][i] = 1;
            allPalindromes.add(String.valueOf(s.charAt(i)));
            ans=String.valueOf(s.charAt(i));
        }

        //Fill for substring with length 2
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1) == s.charAt(i)){
                dp[i-1][i] = 1;
                allPalindromes.add(s.substring(i-1,i+1));
                ans=s.substring(i-1,i+1);
            }
        }

        //Fill for substring with length >= 3
        for(int i=2;i<s.length();i++){
            for(int j=0;j<s.length() - i;j++){
                if(s.charAt(i) == s.charAt(j) && dp[i-1][j+1] == 1){
                    dp[i][j] = 1;
                    String currPal = s.substring(j,i+1);
                    allPalindromes.add(currPal);
                    if(currPal.length() >= ans.length()){
                        ans=currPal;
                    }
                }
            }
        }
        System.out.println("allPalindromes ::"+allPalindromes);
        return ans;
    }


    @ParameterizedTest
    @CsvSource({"aaba"})
    public void testing(String in){
//        System.out.println(longestPalindromeUsingTabulation(in));
        System.out.println(longestPalindromeUsingRecursion(in));
    }

    private int longestPalindromeUsingRecursion(String s) {
        int dp[][] = new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                dp[i][j]=-1;
            }
        }
        return helper(s,0,s.length()-1,dp);
    }

    private int helper(String s, int start, int end,int [][]dp) {
        if(start==end) return 1;
        if(start>end) return 0;
        if(dp[start][end] > -1)
            return dp[start][end];

        int result =0;
        if(s.charAt(start) == s.charAt(end)){
            result = 2 + helper(s,start+1,end-2,dp);
        }
        else{
            result = Math.max(helper(s,start+1,end,dp),
                    helper(s,start,end-1,dp));
        }
        dp[start][end] = result;
        return result;
    }

//

}
