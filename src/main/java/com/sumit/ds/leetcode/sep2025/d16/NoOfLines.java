package com.sumit.ds.leetcode.sep2025.d16;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/number-of-lines-to-write-string/
 *
 */
public class NoOfLines {
    public int[] numberOfLines(int[] widths, String s) {
        int lines=1, sum=0;
        for(char ch:s.toCharArray()){
            int width = widths[ch-'a'];
            sum +=width;
            if(sum>100){
                sum = width;
                lines++;
            }
        }
        return new int[]{lines,sum};
    }

    @Test
    public void testing(){
        NoOfLines no = new NoOfLines();
        Assert.assertArrayEquals(new int[]{3,60},no.numberOfLines(
                new int[]{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                "abcdefghijklmnopqrstuvwxyz"
        ));

        Assert.assertArrayEquals(new int[]{2,4},no.numberOfLines(
                new int[]{4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10},
                "bbbcccdddaaa"
        ));
    }
}
