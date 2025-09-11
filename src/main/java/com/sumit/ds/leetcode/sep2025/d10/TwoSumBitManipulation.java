package com.sumit.ds.leetcode.sep2025.d10;

import org.junit.Assert;
import org.junit.Test;
/**
 * https://leetcode.com/problems/sum-of-two-integers/description/
 */
public class TwoSumBitManipulation {
    public int getSum(int a, int b) {
        while (b != 0) { // Continue until there is no carry
            int carry = (a & b) << 1; // Calculate carry
            a = a ^ b; // Calculate sum without carry
            b = carry; // Update b to the carry for the next iteration
        }
        return a; // Return the final sum
    }

    @Test
    public void testing(){
        TwoSumBitManipulation tb = new TwoSumBitManipulation();
//        Assert.assertEquals(5, tb.getSum(2,3));
        Assert.assertEquals(20, tb.getSum(9,11));
    }
}
