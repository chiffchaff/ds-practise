package com.sumit.ds.leetcode.aug2025;

import org.junit.Assert;
import org.junit.Test;

public class ShiftingLetters {
    public static String shiftingLetters(String s, int[] shifts) {
        int x=0;
        StringBuffer sb = new StringBuffer();
        for(int i = shifts.length-1;i>=0;i--){
            x+=(shifts[i]%26);
            int shift =((s.charAt(i) - 'a') + x ) % 26;
            sb.insert(0,((char) ('a'+shift)));
        }
        return sb.toString();
    }

    @Test
    public void testing(){
        String s ="abc";
        int[] shifts = {3,5,9};
        Assert.assertEquals("rpl",ShiftingLetters.shiftingLetters(s,shifts));
    }

    @Test
    public void testingEdgeCase(){
        String s ="mkgfzkkuxownxvfvxasy";
        int[] shifts = {505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513};
        Assert.assertEquals("wqqwlcjnkphhsyvrkdod",ShiftingLetters.shiftingLetters(s,shifts));
    }
}
