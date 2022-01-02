package com.sumit.ds.leetcode.dec;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode496 {

    public static void main(String[] args) {
        LeetCode496 l = new LeetCode496();
//        int[] superset = {1,5,2,7,9};
//        int [] subset= {1,5,9};
        //int[] superset = {1,3,4,2};
        //int [] subset= {4,1,2};
        //int[] superset = {1,3,4,2};
        //int [] subset= {2,4};
        int[] superset = {6,5,4,3,2,1,7};
        int [] subset= {1,3,5,2,4};
        System.out.println(Arrays.toString(findNextGreatest(superset,subset)));
    }

    private static int[] findNextGreatest(int[] nums2, int[] nums1) {
        int [] output = new int[nums1.length];
        Map<Integer,Integer> indexMap = new HashMap<>();
        for(int i =0;i<nums2.length;i++){
            indexMap.put(nums2[i],i);
        }

        for(int j=0;j<nums1.length;j++){
            int result=-1;
            int inputIndex = indexMap.get(nums1[j]);
            while(++inputIndex < nums2.length){
                if(nums2[inputIndex] > nums1[j]) {
                    result = nums2[inputIndex];
                    break;
                }
            }
            output[j]=result;
        }
        return output;
    }

}
