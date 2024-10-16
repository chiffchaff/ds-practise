package com.sumit.ds.surya.assignments.day1;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all the prime numbers from 1 to 10
 */
public class FindAllPrimes {

    public static void main(String[] args) {
        int n =50;
        FindAllPrimes.getPrimes(n);
        FindAllPrimes.getPrimesBySieveMethod(n);
    }

    private static void getPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean flag = false;
        for(int i=2;i<=n;i++){
            flag = false;
            for(int j=2;j<=Math.sqrt(i);j++) {
                if (i % j == 0) {
                    flag = true;
                    //System.out.println("i="+i +" is not prime");
                }
            }
            if(!flag) {
                //System.out.println("i="+i +" is prime");
                primes.add(i);
            }
        }
        System.out.println(primes);
    }

    private static void getPrimesBySieveMethod(int n) {
        boolean[] values = new boolean[n+1];
        for(int i=2;i<=Math.sqrt(n);i++){
            if(!values[i]){
                int j = 2;
                while(i*j <=n){
                    System.out.println("Setting :"+i*j+" as not prime");
                    values[i*j]=true;
                    j+=1;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(!values[i])
                primes.add(i);
        }
        System.out.println("Sieve method:"+primes);
    }
}
