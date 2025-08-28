package com.sumit.ds.leetcode.aug2025;

import org.junit.Assert;
import org.junit.Test;

public class SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int res[] = new int[2];
        res[0] = releaseTimes[0];
        res[1] = keysPressed.charAt(0);
        for(int i=1;i<releaseTimes.length;i++){
            int currDiff = releaseTimes[i]-releaseTimes[i-1];
            if(currDiff > res[0]){
                res[0] = currDiff;
                res[1] = keysPressed.charAt(i);
            }
            else if(currDiff == res[0] && keysPressed.charAt(i)>res[1]){
                res[1]=keysPressed.charAt(i);
            }
        }
        return (char) res[1];
    }

    @Test
    public void testing(){
        SlowestKey sk = new SlowestKey();
        Assert.assertEquals('c',sk.slowestKey(new int[]{9,29,49,50},"cbcd"));
        Assert.assertEquals('a',sk.slowestKey(new int[]{12,23,36,46,62},"spuda"));
    }
}
