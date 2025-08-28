package com.sumit.ds.leetcode.aug2025;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/binary-gap/
 */
public class BinaryGap {
    /**
     * Using bit operations to find set bit at each index
     * @param n
     * @return
     */
    public int binaryGap(int n) {
        int ans=0,last=-1;
        /**
         * Decimal: 10
         * Binary : 1010
         * assuming 32-bit int, it’s actually 00000000 00000000 00000000 00001010
         */
        for(int i=0;i<32;i++){
            //Right shift by i times then bitwise and op to get the least significant bit
            if(((n>>i) & 1) == 1){
                if(last != -1){
                    ans=Math.max(ans,i-last);
                }
                last=i;
            }
        }
        return ans;
    }

    /**
     * Using Integer.toBinaryString to avoid bit manipulation
     * @param n
     * @return
     */
    public int binaryGap1(int n){
        String bit = Integer.toBinaryString(n);
        int last=-1,ans=0;
        for(int i=0;i<bit.length();i++){
            if(bit.charAt(i) == '1'){
                if(last != -1){
                    ans = Math.max(ans,i-last);
                }
                last=i;
            }
        }
        return ans;
    }

    @Test
    public void testing(){
        BinaryGap bg = new BinaryGap();
        Assert.assertEquals(2,bg.binaryGap(5));
        Assert.assertEquals(2,bg.binaryGap(22));
        Assert.assertEquals(0,bg.binaryGap(8));

        Assert.assertEquals(2,bg.binaryGap1(5));
        Assert.assertEquals(2,bg.binaryGap1(22));
        Assert.assertEquals(0,bg.binaryGap1(8));
    }
}
