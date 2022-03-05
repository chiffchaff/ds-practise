package com.sumit.ds.leetcode.twentytwentyone.jan.six;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class LeetCode88 {
    @Test
    public void test(){
        int [] nums1={1,2,3,0,0,0};
        int [] nums2={2,5,6};
        int m=3;
        int n=3;
        System.out.println("Before merge : num1 :"+ Arrays.toString(nums1) + " num2: "+Arrays.toString(nums2));
        merge(nums1,m,nums2,n);
        System.out.println("After merge : num1 :"+ Arrays.toString(nums1) + " num2: "+Arrays.toString(nums2));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

    }
}
