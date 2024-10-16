package com.sumit.ds.leetcode.apr2024;

import org.junit.Test;

public class FindGCDString {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1))
            return "";

        int len1 = str1.length();
        int len2 = str2.length();
        System.out.println("len1:"+len1 +" len2:"+len2 );

        while(len1 != 0 && len2 != 0){
            int temp = len2;
            len2 = len1 % len2;
            len1 = temp;
            System.out.println("len1:"+len1 +" len2:"+len2 );

        }
        System.out.println("len1:"+len1 +" len2:"+len2 );
        return str2.substring(0,len1+len2);
    }

    @Test
    public void testing(){
        String in1 = "LEET";
        String in2 = "CODE";
        System.out.println(gcdOfStrings(in1,in2));
    }
}
