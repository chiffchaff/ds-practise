package com.sumit.ds.surya.assignments.day1;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {
    public static void main(String[] args) {
        int n = 10;
        allPrimeFactors(n);
        allPrimeFactors(36);
    }

    private static void allPrimeFactors(int n) {
        List<Integer> primeFactors = new ArrayList<>();
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                primeFactors.add(i);
                primeFactors.add(n/i);
            }
        }
        System.out.println(primeFactors);
    }
}
