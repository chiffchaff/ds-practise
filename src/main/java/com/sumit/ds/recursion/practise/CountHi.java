package com.sumit.ds.recursion.practise;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CountHi {
    public int countHi(String str) {
        if(str == null || str.length() < 2)
            return 0;
        if(str.charAt(str.length()-1)=='i' && str.charAt(str.length()-2)=='h'){
            return 1+countHi(str.substring(0,str.length()-2));
        }
        else
            return countHi(str.substring(0,str.length()-1));
    }

    public int countHi1(String str) {
        if(str == null || str.length() < 2)
            return 0;
        int count = str.substring(0,2).equals("hi")?1:0;
        return count + countHi1(str.substring(1));

    }

    @ParameterizedTest
    @CsvSource({"hi","xxhixx","xhixhix"})
    public void testCountHi(String s){
        System.out.println("in:"+s+" Out:"+(countHi(s)));
        System.out.println("in:"+s+" Out:"+(countHi1(s)));
    }
}
