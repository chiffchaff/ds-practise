package com.sumit.ds.recursion.practise;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * https://codingbat.com/prob/p194781
 */
public class Triangle {
    public int triangle(int rows) {
        if(rows== 0)
            return rows;
        else
            return rows+triangle(rows-1);
    }

    @ParameterizedTest
    @CsvSource({"0","1","2","3"})
    public void testTriangle(int n){
        System.out.println(triangle(n));
    }
}