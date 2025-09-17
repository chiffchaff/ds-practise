package com.sumit.ds.leetcode.sep2025.d9;

import com.sumit.ds.leetcode.sep2025.d3.ConvertInteger;
import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode.com/problems/count-pairs-of-nodes/
 */
public class CountPairOfNodes {
    //TODO::
    public int[] countPairs(int n, int[][] edges, int[] queries) {

        return null;
    }

    @Test
    public void testing(){
        int n =4;
        int [][] edges= {{1,2},{2,4},{1,3},{2,3},{2,1}};
        int[] queries = {2,3};
        int [] output={6,5};
        CountPairOfNodes cp = new CountPairOfNodes();
        Assert.assertArrayEquals(output,cp.countPairs(n,edges,queries));
    }
}
