package com.sumit.ds.leetcode.sep2025.d3;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
 */
public class MaxPoints {
    public int maxScore(int[] cardPoints, int k) {
        int left = 0, right = cardPoints.length-1,sum=0;
        while(left <= right && k >0){
            if(cardPoints[left] > cardPoints[right]){
                sum += cardPoints[left];
                System.out.println("Card :" + cardPoints[left] + ", sum:" + sum + ", k:" + k);
                left++;
            }
            else{
                sum += cardPoints[right];
                System.out.println("Card :" + cardPoints[right] + ", sum:" + sum + ", k:" + k);
                right--;
            }
            k--;
        }
        return sum;
    }
    @Test
    public void testing(){
        MaxPoints mp = new MaxPoints();
//        Assert.assertEquals(12,mp.maxScore(new int[]{1,2,3,4,5,6,1},3));
//        Assert.assertEquals(4,mp.maxScore(new int[]{2,2,2},2));
//        Assert.assertEquals(55,mp.maxScore(new int[]{9,7,7,9,7,7,9},7));
        Assert.assertEquals(232,mp.maxScore(new int[]{11,49,100,20,86,29,72},4));
        System.out.println(72+11+49+100);
    }
}
