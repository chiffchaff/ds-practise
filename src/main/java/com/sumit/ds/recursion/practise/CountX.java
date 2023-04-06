package com.sumit.ds.recursion.practise;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


/**
 * https://codingbat.com/prob/p170371
 */
public class CountX {
    public int countX(String str) {
        if(str == null || str.length() == 0)
            return 0;
        return (str.charAt(str.length()-1)=='x'?1:0)+countX(str.substring(0,str.length()-1));
    }

   @ParameterizedTest
   @CsvSource({"xuxxt","xx","xhixhix"})
   public void testCountX(String s){
        System.out.println("s:"+s+ " count:"+countX(s));
    }

    @Test
    public void testCountX1(){
        String s = null;
        System.out.println("s:"+s+ " count:"+countX(s));
    }
}
