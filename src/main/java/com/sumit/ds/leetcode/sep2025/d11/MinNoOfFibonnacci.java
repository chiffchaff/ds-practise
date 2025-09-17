package com.sumit.ds.leetcode.sep2025.d11;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MinNoOfFibonnacci {
    public int findMinFibonacciNumbers(int k) {
        int count = 0 , rem=k;
        List<Integer> fList = getAllFibonacci(k);

        for(int i=fList.size()-1;i>=0;i--){
            if(rem>=fList.get(i)){
                rem-=fList.get(i);
                count++;
            }
        }
        return count;
    }

    public List<Integer> getAllFibonacci(int k){
        List<Integer> ll = new ArrayList<>();
        int f1 = 1, f2 =1,f=0;
        ll.add(f1);
        while(f<=k){
            f=f1+f2;
            ll.add(f);
            f2=f1;
            f1=f;
        }
        return ll;
    }

    @Test
    public void testing(){
        MinNoOfFibonnacci m = new MinNoOfFibonnacci();
        Assert.assertEquals(2,m.findMinFibonacciNumbers(7));
        Assert.assertEquals(2,m.findMinFibonacciNumbers(10));
        Assert.assertEquals(3,m.findMinFibonacciNumbers(19));
    }
}
