package com.sumit.ds.leetcode.sep2025.d11;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

/**
 * https://leetcode.com/problems/happy-number/description/
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        List<Integer> visited = new ArrayList();
        int squareSum = n;
        do{
            visited.add(squareSum);
            squareSum = getSquareSum(squareSum);
        }while(squareSum !=1 && !visited.contains(squareSum));

        return (squareSum == 1)?true:false;
    }

    private int getSquareSum(int n) {
        int sum =0;
//        System.out.println("Compute square sum for :"+n);
        while(n != 0){
            int digit = n %10;
            sum += digit * digit;
            n /=10;
        }
//        System.out.println("SquareSum :"+sum);
        return sum;
    }

    @Test
    public void testing(){
        HappyNumber hn = new HappyNumber();
        Assert.assertEquals(true,hn.isHappy(19));
        Assert.assertEquals(false,hn.isHappy(2));
    }
}
