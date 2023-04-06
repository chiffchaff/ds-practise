package com.sumit.ds.recursion.practise;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    Map<Integer,Integer> cache = new HashMap();
    public int fibonacci(int n) {
        if(n < 2 ){
            return n;
        }
        if(cache.containsKey(n)){
            return cache.get(n);
        }
        else{
            cache.put(n,fibonacci(n-1)+fibonacci(n-2));
        }
        return cache.get(n);
    }

    @DisplayName("Should print fibonacci numbers")
    @ParameterizedTest
    @CsvSource({"0",
            "1",
            "2",
            "3"
    })
    public void testFibonacci(int n){
        System.out.println(fibonacci(n));
    }
}
