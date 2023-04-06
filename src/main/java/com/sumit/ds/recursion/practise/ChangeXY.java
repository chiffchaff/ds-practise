package com.sumit.ds.recursion.practise;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ChangeXY {
    public String changeXY(String str) {
        if(str == null || str.length() <1)
            return str;
        return (str.charAt(0)=='x'?"y":str.charAt(0))+changeXY(str.substring(1));
    }

    @ParameterizedTest
    @CsvSource({"xyz","yxz"})
    public void testChangeXY(String s){
        System.out.println("In:"+s +" out:"+changeXY(s));
    }
}
