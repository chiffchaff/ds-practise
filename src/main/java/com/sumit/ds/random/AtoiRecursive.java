package com.sumit.ds.random;

import org.junit.Assert;
import org.junit.Test;

public class AtoiRecursive {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // Trim leading and trailing spaces
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }

        int idx = 0;
        int sign = 1;
        int num = 0;

        // Check for optional '+' or '-' sign
        if (s.charAt(idx) == '-' || s.charAt(idx) == '+') {
            sign = (s.charAt(idx) == '-') ? -1 : 1;
            idx++;
        }

        // Remove leading zeros
        while (idx < s.length() && s.charAt(idx) == '0') {
            idx++;
        }

        return getNumber(s, num, idx, sign);
    }

    private int getNumber(String s, int num, int idx, int sign) {
        if (idx == s.length() || !isDigit(s.charAt(idx))) {
            return num * sign;
        }

        int chInt = s.charAt(idx) - '0';

        // Check for integer overflow and underflow
        if (num > (Integer.MAX_VALUE - chInt) / 10) {
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        num = num * 10 + chInt;
        return getNumber(s, num, idx + 1, sign);
    }

//    public int getNumber(String s, int num, int idx){
//        if(idx == s.length() || !isDigit(s.charAt(idx))){
//            return num;
//        }
//
//        num = getNumber(s,num,idx+1);
//        int chInt = s.charAt(idx) - '0';
//        num = num +  chInt * (int)Math.pow(10,s.length() - 1 - idx);
//        return num;
//    }

    private boolean isDigit(char c) {
        return ((c - '0') >=0 && (c - '0') <=9 );
    }
    @Test
    public void testing(){
        Assert.assertEquals(42,myAtoi("42")); // 42
        Assert.assertEquals(-42,myAtoi("   -42")); // -42
        Assert.assertEquals(42,myAtoi("4193 with words")); // 4193
        System.out.println(myAtoi("words and 987")); // 0
        System.out.println(myAtoi("-91283472332")); // Integer.MIN_VALUE (-2147483648)
        System.out.println(myAtoi("0032")); // 32
    }
}