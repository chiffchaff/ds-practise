package com.sumit.ds.leetcode.sep2025.d9;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class IntersectionOfTwoArrays {

    /**
     * TC = O(n)
     * SC = O(1)
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        int [] count = new int[1001]; // max value of each elements of nums1/nums2. +1 to accomodate 0 based index
        //Calculate frequency of nums1
        for(int n:nums1){
            count[n]++;
        }

        //Compute the intersection from second array by using frequency lookup from the first array
        int [] res = new int[nums1.length];
        int i=0;
        for(int n:nums2){
            if(count[n]>0){
                res[i++] = n;
                count[n]--;
            }
        }
        //Return the result by copying only the filled portion of result array
        return Arrays.copyOfRange(res, 0,i);
    }

    /**
     * Using HashMap for frequency count
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        Map<Integer,Integer> fmap = new HashMap<>();
        //Calculate frequency of nums1
        for(int n:nums1){
            fmap.put(n,fmap.getOrDefault(n,0)+1);
        }

        //Compute the intersection from second array by using frequency lookup from the first array
        List<Integer> res = new ArrayList<>();
        for(int n:nums2){
            if(fmap.containsKey(n)){
                res.add(n);
                fmap.put(n,fmap.get(n)-1);
                if(fmap.get(n) == 0){
                    fmap.remove(n);
                }
            }
        }

        //Return the result as int []
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    @Test
    public void testing(){
        IntersectionOfTwoArrays it = new IntersectionOfTwoArrays();
        int [] nums1 = {1,2,2,1};
        int [] nums2 = {2,2};
        int [] expected = {2,2};

        Assert.assertArrayEquals(expected,it.intersect(nums1,nums2));
        Assert.assertArrayEquals(expected,it.intersect1(nums1,nums2));
    }

}
