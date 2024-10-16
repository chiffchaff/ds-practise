package com.sumit.ds.leetcode.may2023;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 125. Valid Palindrome
 */
public class LeetCode125 {
    public boolean isPalindrome(String s) {
        if(s == null)
            return false;
        if(s.trim().length() <= 1) // for empty string and single length string
            return true;
        boolean res = true;
        int i =0;
        int j = s.length() -1;
        int count=0;
        while(i<=j){
            while(i<=j && !isValidChar(s.charAt(i))){
                i++;
            }
            while(i<=j && !isValidChar(s.charAt(j))){
                j--;
                count++;
            }
            if(i>j && count == 0){
                res = true;
                break;
            }
            if(i<=j && toLower(s.charAt(i)) == toLower(s.charAt(j))){
                i++;j--;
            }
            else{
                res = false;
                break;
            }
        }
        return res;
    }
    public boolean isValidChar(char ch){
        boolean res = false;
        if((ch >='a' && ch <='z') ||(ch >='A' && ch <='Z')
        || (ch>='0' && ch<='9')){
            res = true;
        }
        return res;
    }
    public char toLower(char ch){
        int res = ch;
        if(ch >='A' && ch <='Z'){
            res = 'a' + ch - 'A';
        }
        return (char)res;
    }
    @ParameterizedTest
    @CsvSource({"a$b%a"})
    public void testing(String s){
        System.out.println("input: "+ s + " res :"+isPalindrome(s));
    }

    @Test public void test1(){
        String s ="A man, a plan, a canal: Panama";
        s = "race a car";
        s = " ";
        s=".,";
        s="Never a foot too far, even.";

        System.out.println("input: "+ s + " res :"+isPalindrome(s));
    }
}
