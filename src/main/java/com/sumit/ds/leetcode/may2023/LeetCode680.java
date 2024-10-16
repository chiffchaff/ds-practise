package com.sumit.ds.leetcode.may2023;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * https://leetcode.com/problems/valid-palindrome-ii/
 * Valid Panlindrome II
 */
public class LeetCode680 {
    public boolean validPalindrome(String s) {
        int i =0;
        int j=s.length() -1;
        boolean result = true;
        boolean skipped = false;
        while(i <= j){
            if(s.charAt(i) == s.charAt(j)){
                i++;j--;
            }
            else if(!skipped && s.charAt(i+1) == s.charAt(j)){
                i++;
                skipped=true;
            }
            else if(!skipped && s.charAt(i) == s.charAt(j-1)){
                j--;
                skipped=true;
            }
            else{
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean validPalindrome1(String s) {
        int i = 0;
        int j = s.length() - 1;

        while(i <= j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
        }
        return true;
    }
    public boolean isPalindrome(String s, int i, int j){
        while(i <= j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else return false;
        }
        return true;
    }

    @ParameterizedTest//"abcca",
    @CsvSource({"ebcbbececabbacecbbcbe"})
    public void testing(String s){
        System.out.println("Input: "+s +" res:"+validPalindrome(s));
        System.out.println("Input: "+s +" res:"+validPalindrome1(s));
    }
}

