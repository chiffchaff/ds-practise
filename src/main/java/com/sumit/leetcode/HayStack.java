package com.sumit.leetcode;

import org.junit.Test;

public class HayStack {

    public int strStr(String haystack, String needle) {
        int res = -1;
        for(int i=0;i<=haystack.length()-needle.length();i++){
            if(haystack.substring(i,i+needle.length()).equals(needle)){
                res = i;
                break;
            }
        }
        return res;
    }


    @Test
    public void test(){
//        String haystack="abc";
//        String needle="c";

        String haystack="hello";
        String needle="ll";

        System.out.println(strStr(haystack,needle));

    }
}

