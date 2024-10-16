package com.sumit.techdose.assignments.mathalgo;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/count-primes/description/
 * Given an integer n, return the number of prime numbers that are strictly less than n.
 * Sieve of Eratosthenes
 */
public class CountPrimes {
    public void countPrimes(int n) {
        int count = 0;
        boolean[] isPrime = sieveOfEratosthenes(n);
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.println(i+" ");
            }
        }
    }

    public boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0]=false;
        isPrime[1]=false;
        for(int i=2;i*i<=n;i++) //2*2=4, 3*3=9, 3,5,6,7,8
            if(isPrime[i]){
                for(int j=i*i;j<=n;j+=i){
                    isPrime[j] = false;
                }
            }
        return isPrime;
    }



    @Test
    public void testing(){
        countPrimes(10);
    }
}
