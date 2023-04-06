package com.sumit.ds.recursion.practise;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PowerN {
    public int powerN(int base, int n) {
        if(n==0)
            return 1;
        return base * powerN(base,n-1);
    }

    @ParameterizedTest
    @CsvSource({
            "2,3",
            "3,1",
            "3,2",
            "3,3",
            "10,2"
        })
    public void testPowerN(int base,int n){
        System.out.println("base:"+base+" pwr:"+ n +" res:"+powerN(base,n));
    }
}
