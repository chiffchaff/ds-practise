package com.sumit.ds.leetcode.jan.six;

import org.junit.Test;

import java.util.Arrays;

/**
 * https://www.geeksforgeeks.org/merge-two-sorted-arrays-o1-extra-space/
 */
public class GeektoGeekMergeSorted {
    @Test
    public void test(){
        int [] nums1={1, 5, 9, 10, 15, 20};
        int [] nums2={2, 3, 8, 13};
        int m = nums1.length;
        int n = nums2.length;
        System.out.println("Before merging num1:"+Arrays.toString(nums1) +" nums2:"+Arrays.toString(nums2));
        merge(nums1,m,nums2,n);
        System.out.println("After merging num1:"+Arrays.toString(nums1) +" nums2:"+Arrays.toString(nums2));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0; int j=0; int k = m -1;
        while(i<=k && j < n){
            if(nums1[i] > nums2[j]){
                i++;
            }
            else{
                int temp = nums2[j];
                nums2[j++] = nums1[k];
                nums1[k--] = temp;
            }
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
    }
}
