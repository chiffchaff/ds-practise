package com.sumit.techdose.assignments.mathalgo;

import org.junit.Test;

public class isPrime {

    @Test
    public void testing(){
        int n = 13;
        System.out.println("isPrime :"+n +":"+checkPrime(n));
    }

    private boolean checkPrime(int n) {
        boolean flag = true;
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
