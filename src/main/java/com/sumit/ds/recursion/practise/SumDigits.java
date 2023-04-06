package com.sumit.ds.recursion.practise;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

//https://codingbat.com/prob/p163932
public class SumDigits {
    public int sumDigits(int n) {
        if(n == 0)
            return 0;
        return (n%10)+sumDigits(n/10);
    }

    @ParameterizedTest
    @CsvSource({"126","49","12"})
    public void testSumDigits(int n){
        System.out.println(sumDigits(n));
    }

}
