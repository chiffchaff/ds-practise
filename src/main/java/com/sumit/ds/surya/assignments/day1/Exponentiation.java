package com.sumit.ds.surya.assignments.day1;

import java.math.BigInteger;

/**
 * Calculate X^Y in log(Y) time
 */
public class Exponentiation {
    public static void main(String[] args) {
        //Two to the power of 5
//        BigInteger res = printExponent(2,2);
//        System.out.println("Result:"+res.longValue());
        System.out.println(printExponent1(2,5));
    }

    private static long printExponent1(int a, int b) {
        long result =1;
        while(b > 0){
            if(b % 2 == 1){
                result *= a;
            }
            a = a * a;
            b = b/2;
        }
        return result;
    }

    private static BigInteger printExponent(int a, int b) {
        BigInteger res = BigInteger.ONE;
        BigInteger bigIntegerA = BigInteger.valueOf(a);
        BigInteger bigIntegerB = BigInteger.valueOf(b);
        while(bigIntegerB.longValue() > 0){
            if(bigIntegerB.longValue() % 2 == 1){
                res=res.multiply(bigIntegerA);
            }
            bigIntegerA = bigIntegerA.multiply(bigIntegerA);
            bigIntegerB = bigIntegerB.divide(bigIntegerB);
            System.out.println("a:b::"+bigIntegerA.longValue()+":"+bigIntegerB.longValue());
        }
        return res;
    }
}
