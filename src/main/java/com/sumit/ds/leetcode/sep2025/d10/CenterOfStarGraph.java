package com.sumit.ds.leetcode.sep2025.d10;

import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/find-center-of-star-graph/description/
 */
public class CenterOfStarGraph {
    public int findCenter(int[][] edges) {

    }

    @Test
    public void testing(){
        CenterOfStarGraph c = new CenterOfStarGraph();
        int [][] input ={{1,2},{2,3},{4,2}};
        Assert.assertEquals(2,c.findCenter(input));


        int [][] input1 = {{1,2},{5,1},{1,3},{1,4}};
        Assert.assertEquals(1,c.findCenter(input1));
    }
}
