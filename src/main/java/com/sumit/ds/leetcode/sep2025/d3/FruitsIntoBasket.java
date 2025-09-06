package com.sumit.ds.leetcode.sep2025.d3;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/fruit-into-baskets/description/
 */
public class FruitsIntoBasket {
    /**
     * TC = O(n)
     * SC = O(1)
     * @param fruits
     * @return
     */
    public int totalFruit(int[] fruits) {
        int left=0,maxPicked=0;
        Map<Integer,Integer> basket = new HashMap<>();
        for(int right=0;right<fruits.length;right++){
            basket.put(fruits[right],basket.getOrDefault(fruits[right],0)+1);
            while(basket.size() > 2){
                basket.put(fruits[left],basket.get(fruits[left])-1);
                if(basket.get(fruits[left]) == 0){
                    basket.remove(fruits[left]);
                }
                left++;
            }
            maxPicked = Math.max(maxPicked,right - left +1);
        }
        return maxPicked;
    }



    @Test
    public void testing(){
        FruitsIntoBasket fb = new FruitsIntoBasket();
        Assert.assertEquals(3,fb.totalFruit(new int[]{1,2,1}));
        Assert.assertEquals(3,fb.totalFruit(new int[]{0,1,2,2}));

        Assert.assertEquals(4,fb.totalFruit(new int[]{1,2,3,2,2}));
        Assert.assertEquals(5,fb.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
}

