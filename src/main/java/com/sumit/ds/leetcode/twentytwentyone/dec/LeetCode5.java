package com.sumit.ds.leetcode.twentytwentyone.dec;

/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LeetCode5 {
    private static int startIndex=0;
    private static int subStringLength=0;

    public static void main(String[] args) {
        String input = "babad";
        String output= "bab";
        output= "aba";

        //input ="cbbd";
        output = "bb";

        System.out.println(findPalindrome(input));
    }

    private static String findPalindrome(String input) {
        String subStringPalindrome = "";
        if(input.length() < 2){
            subStringPalindrome=input;
        }else{

            for(int start=0;start<input.length();start++){
                findSubStringPalindrome(input,start,start);
                findSubStringPalindrome(input,start,start+1);
            }
            subStringPalindrome = input.substring(startIndex,startIndex+subStringLength);
        }
        return  subStringPalindrome;
    }

    private static void findSubStringPalindrome(String input, int start, int end) {
        while(start >=0 && end < input.length() && input.charAt(start) == input.charAt(end)){
            start--;
            end++;
        }
        if(subStringLength < end - start -1){
            startIndex = start + 1;
            subStringLength = end - start - 1;
        }
    }
}
