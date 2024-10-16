package com.sumit.ds.leetcode.apr2024;

import org.junit.Test;

/**
 * LeetCode 151
 */
public class ReverseWordString {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        boolean wordStart = true;
        for(int i=s.length()-1;i>=0;i--){
            if(wordStart){
                if(s.charAt(i) !=' '){
                    temp.append(s.charAt(i));
                }
                else{
                    wordStart=false;
                    sb.append(temp.reverse().toString()).append(" ");
                    temp = new StringBuilder();
                }
            }
            else{
                if(s.charAt(i) != ' '){
                    temp.append(s.charAt(i));
                    wordStart=true;
                }
            }
        }
        if(temp.toString().length() > 0){
            sb.append(temp.reverse().toString());
        }
        return sb.toString();
    }

    @Test
    public void testing(){
        String in = "the sky is blue";
        System.out.println(reverseWords(in));
    }
}
