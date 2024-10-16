package com.sumit.ds.leetcode.may2023;

import org.junit.Test;

//https://leetcode.com/problems/add-binary/
public class LeetCode67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() -1;
        int j = b.length() -1;
        int carry = 0;
        int sum = 0;
        while(i >=0 || j>=0){
            sum = carry;
            if(i >=0){
                sum += a.charAt(i--) - '0';
            }
            if(j >= 0){
                sum += b.charAt(j--) - '0';
            }
            if(carry >0){
                sum += carry;
            }
            sb.insert(0,sum%2);
            carry = sum/2;
        }
        if(carry >0){
            sb.insert(0,carry);
        }
        return sb.toString();
    }

    @Test
    public void testing(){
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a,b));
    }
}
