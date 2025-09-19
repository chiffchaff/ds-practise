package com.sumit.ds.leetcode.sep2025.d17;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/longest-turbulent-subarray/description/
 * https://www.youtube.com/watch?v=V_iHUhR8Dek
 */
public class LongestTurbulentSubArray {
    public int maxTurbulenceSize(int[] arr) {
        int l=0,r=1;
        int ans=1;
        String prev=" ";
        while(r<arr.length){
            if(arr[r-1]>arr[r] && !prev.equals(">")){
                ans=Math.max(ans, r - l+1 );
                r++;
                prev=">";
            }
            else if(arr[r-1]<arr[r] && !prev.equals("<")){
                ans=Math.max(ans, r - l+1 );
                r++;
                prev="<";
            }
            else{
                prev=""; // if arr[l-1] = arr[l] or arr[l-1] doesn't follow the turbulent rule.
                r = (arr[r] == arr[r-1])?r+1:r;
                l = r -1;

            }
        }
        return ans;
    }

    @Test
    public void testing(){
        LongestTurbulentSubArray l = new LongestTurbulentSubArray();
        Assert.assertEquals(5,l.maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}));
        Assert.assertEquals(2,l.maxTurbulenceSize(new int[]{4,8,12,16}));
        Assert.assertEquals(1,l.maxTurbulenceSize(new int[]{100}));
    }
}
