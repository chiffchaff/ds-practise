package com.sumit.ds.leetcode.apr2023;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

/**
 * 647. Palindromic Substrings
 */
public class LeetCode647 {
    public int countSubstrings(String s) {
        List<String> palindromeStrings = new ArrayList<>();
        int count =0;
        int n =s.length();
        boolean [][] dp = new boolean[n][n];

        //base case (single characters is palindrome in itself
        for(int i=0;i<n;i++){
            dp[i][i]=true;
            count++;
            palindromeStrings.add(s.substring(i,i+1));
        }

        //two characters case
        for(int i=0;i<n-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
                dp[i][i+1]=true;
                count++;
                palindromeStrings.add(s.substring(i,i+1+1));
            }
        }
//        System.out.println("length of string:"+n);
        //for characters more than two
        for(int len=3;len<=n;len++){
//            System.out.println("len:"+len);
            for(int i=0;i<=n-len;i++){
                int j = i+len-1;
//                System.out.println("[i,j]:["+i+","+j+"]");
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j]=true;
                    palindromeStrings.add(s.substring(i,j+1));
                    count++;
                }
            }
        }
        System.out.println("palindromeStrings:"+palindromeStrings);
        return count;
    }

    @ParameterizedTest
    @CsvSource({"aaa"})
    public void testCountSubStrings(String s){
        System.out.println("in:"+s +" out:"+countSubstrings(s));
    }
}
