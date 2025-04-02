package com.sumit.leetcode;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.TestTemplate;

public class CowsAndBulls {
    public String getHint(String secret, String guess) {
        int nBulls = 0, nCows = 0;
        int[] freq = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if (s == g) {
                nBulls++;
            } else {
                if (freq[s] < 0) nCows++;
                if (freq[g] > 0) nCows++;
                freq[s]++;
                freq[g]--;
            }
        }
        return nBulls + "A" + nCows + "B";
    }

    @Test
    public void testing(){
        //Assert.assertEquals("1A1B",getHint("1123","0111"));
        Assert.assertEquals("2A2B",getHint("1110","0111"));
    }
}
