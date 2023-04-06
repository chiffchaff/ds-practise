package com.sumit.ds.recursion.practise;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * https://codingbat.com/prob/p192383
 */
public class Count8 {
    public int count8(int n) {
        if(n==0)
            return 0;
        int first =(n%10==8?1:0);
        int second = (((n/10)%10==8)&& first==1?1:0);
        int recurse = count8(n/10);
        return first+second+recurse;
    }

    @ParameterizedTest
    @CsvSource({"8818","88888","123","2348"})
    public void testCount8(int n){
        System.out.println("n="+n+ " res:"+count8(n));
    }
}
