package com.sumit.ds.leetcode.sep2025.d17;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/to-lower-case/description/
 *
 */
public class ToLower {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch >='A' && ch <='Z'){
                ch = (char) ('a' + (ch - 'A'));
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    @Test
    public void testing(){
        ToLower t = new ToLower();
        Assert.assertEquals("sumit",t.toLowerCase("Sumit"));
    }
}
