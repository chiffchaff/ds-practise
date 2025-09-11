package com.sumit.ds.leetcode.sep2025.d10;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/shuffle-string/
 */
public class ShuffleString {
    public String restoreString(String s, int[] indices) {
        char [] res = new char[s.length()];
        for(int i=0;i<s.length();i++){
            res[indices[i]]=s.charAt(i);
        }
        return new String(res);
    }

    @Test
    public void testing(){
        ShuffleString ss = new ShuffleString();
        Assert.assertEquals("leetcode",ss.restoreString("codeleet",new int[]{4,5,6,7,0,2,1,3}));
    }
}
