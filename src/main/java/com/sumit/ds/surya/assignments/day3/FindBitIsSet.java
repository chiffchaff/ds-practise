package com.sumit.ds.surya.assignments.day3;

import org.junit.Assert;
import org.junit.Test;

/**
 * Given a number find if the bit is set in binary form
 */
public class FindBitIsSet {
    @Test
    public void testing(){
        /**
         * Input n = 9 (1001 in binary)
         * k = 3, check if bit is set at index 3, as we can see its set
         * 1<<k times, i.e 1<<3 = 1000
         * finally, 1001 & 1000 = 1000 which is not equal to 1
         */
        Assert.assertTrue(isBitSet(9, 3));
        Assert.assertFalse(isBitSet(9, 2));
        Assert.assertTrue(isBitSet(9, 0));
    }

    private static boolean isBitSet(int n, int k) {
        return ((n & (1<<k)) !=0);
    }
}
