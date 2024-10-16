package com.sumit.ds.recursion.practise;


/**
 * https://codingbat.com/prob/p101409
 */
public class Count7 {
    public int count7(int n) {
        if(n ==0 )
            return 0;
        return (n%10==7?1:0)+count7(n/10);
    }

//    @ParameterizedTest
//    @CsvSource({"717","7","123"})
    public void testCount7(int n){
        System.out.println(count7(n));
    }
}
