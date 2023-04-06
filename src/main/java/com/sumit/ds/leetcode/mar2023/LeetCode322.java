package com.sumit.ds.leetcode.mar2023;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class LeetCode322 {
    public static int coinChange(int[] coins, int amount) {
        int noOfCoins = 0;
        Arrays.sort(coins);
            for(int i=coins.length-1;i>=0;i--){
                int noOfThisCoin = amount/coins[i];
                noOfCoins += noOfThisCoin;
                if(noOfThisCoin > 0 )
                    amount = amount%coins[i];
        }
        if(amount > 0)
            noOfCoins = -1;
        return noOfCoins;
    }

    @Test
    public void testing(){
//        int [] coins = {2};
        int [] coins = {186,419,83,408};
        int amount = 6249;
//        ans = 20
        System.out.println(coinChange(coins,amount));
    }
}
