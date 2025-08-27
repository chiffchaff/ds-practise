package com.sumit.ds.leetcode.aug2025;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
//Leetcode #1537
public class GetMaximumScore {
    public int maxSum2(int[] nums1, int[] nums2) {
        int mod = 1_000_000_007;
        int i = 0, j = 0;
        long sum1 = 0, sum2 = 0;

        int n1 = nums1.length;
        int n2 = nums2.length;

        while (i < n1 && j < n2) {
            if (nums1[i] < nums2[j]) {
                sum1 += nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                sum2 += nums2[j++];
            } else {
                // Common element: junction point
                long maxSum = Math.max(sum1, sum2) + nums1[i];
                sum1 = sum2 = maxSum;
                i++;
                j++;
            }
        }
        // Add remaining values after last junction
        while (i < n1) sum1 += nums1[i++];
        while (j < n2) sum2 += nums2[j++];

        return (int) (Math.max(sum1, sum2) % mod);
    }

    public int maxSum(int[] nums1, int[] nums2) {
        int i=0,j=0;
        long sum1=0,sum2=0;

        int mod =1_000_000_007;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i] < nums2[j]){
                sum1 += nums1[i++];
            }
            else if(nums1[i] > nums2[j]){
                sum2 += nums2[j++];
            }
            else{
                long maxSum = Math.max(sum1,sum2)+nums1[i];
                sum1=sum2=maxSum;
                i++;j++;
            }
        }
        while(i<nums1.length) sum1+=nums1[i++];
        while(j<nums2.length) sum2+=nums2[j++];
        return ((int)Math.max(sum1,sum2)%mod);

    }

    @Test
    public void testMaxSum() {

        //✅ Test Case 1: Common elements with switching
        assertEquals(30, new GetMaximumScore().maxSum(new int[]{2, 4, 5, 8, 10}, new int[]{4, 6, 8, 9}));

        //✅ Test Case 2: No common elements
        assertEquals(12, new GetMaximumScore().maxSum(new int[]{1, 3, 5}, new int[]{2, 4, 6}));

        //✅ Test Case 3: All elements are common
        assertEquals(6, new GetMaximumScore().maxSum(new int[]{1, 2, 3}, new int[]{1, 2, 3}));

        //✅ Test Case 4: One array is a strict subset of the other
        assertEquals(25, new GetMaximumScore().maxSum(new int[]{1, 3, 5, 7, 9}, new int[]{3, 5, 7}));

        //✅ Test Case 5: One array is empty
        assertEquals(6, new GetMaximumScore().maxSum(new int[]{}, new int[]{1, 2, 3}));

        //✅ Test Case 6: Duplicate values (though problem says strictly increasing)

        //✅ Test Case 7: Large numbers to test modulo
        assertEquals(1_000_000_000, new GetMaximumScore().maxSum(new int[]{1_000_000_000}, new int[]{1_000_000_000}));

        //✅ Test Case 8: Switch early gives better total
        assertEquals(17, new GetMaximumScore().maxSum(new int[]{1, 2, 3, 7}, new int[]{3, 5, 6}));
    }

}
