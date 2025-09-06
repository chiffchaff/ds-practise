package com.sumit.ds.leetcode.sep2025.d3;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/description/
 */
public class ConvertInteger {
    /**
     * TC = O(nlogn)
     * SC = O(1)
     * @param n
     * @return
     */
    public int[] getNoZeroIntegers1(int n) {
        for(int i=1;i<n;i++){
            boolean p1 = containsStringZero(i);
            boolean p2 = containsStringZero(n-i);
            if(!p1 && !p2){
                return new int[] {i,n-i};
            }
        }
        return new int[]{0};
    }

    // converting each integer to a string (which takes O(log n) time
    private boolean containsStringZero(int i) {
        return String.valueOf(i).contains("0");
    }

    /**
     * TC = O(nlogn)
     * SC = O(1)
     * @param n
     * @return
     */
    public int[] getNoZeroIntegers(int n) {
        for(int i=1;i<n;i++){
            boolean p1 = containsZero(i);
            boolean p2 = containsZero(n-i);
            if(!p1 && !p2){
                return new int[] {i,n-i};
            }
        }
        return new int[]{0};
    }

    /**
     * The containsZero method processes each digit of its input number m (where m eq n) using a loop that performs modulo and integer division operations until m becomes 0.
     * The number of digits in m is [log_{10} m] + 1, which is log n in the worst case
     * @param i
     * @return
     */
    private boolean containsZero(int i) {
        while(i > 0){
            if(i % 10 == 0){
                return true;
            }
            i = i /10;
        }
        return false;
    }

    @Test
    public void testing(){
        ConvertInteger ci = new ConvertInteger();
        Assert.assertArrayEquals(new int[]{1,1},ci.getNoZeroIntegers(2));
        Assert.assertArrayEquals(new int[]{2,9},ci.getNoZeroIntegers1(11));
    }
}
