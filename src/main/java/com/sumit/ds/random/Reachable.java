package com.sumit.ds.random;

import org.junit.Test;

/**
 * LeetCode 780:
 */
public class Reachable {
    public boolean isReachable(int sx,int sy, int tx,int ty){
        if(sx == tx && sy == ty) return true;

        if(sx>tx || sy > ty) return false;

        return (isReachable(sx+sy,sy,tx,ty) || isReachable(sx,sx+sy,tx,ty));
    }

    @Test
    public void testing(){
        System.out.println(isReachable(1,1,3,5));
    }
}
