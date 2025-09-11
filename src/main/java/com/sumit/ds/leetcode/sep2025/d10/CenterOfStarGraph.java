package com.sumit.ds.leetcode.sep2025.d10;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-center-of-star-graph/description/
 * https://www.youtube.com/watch?v=PFzYVlPxT_I
 */
public class CenterOfStarGraph {
    /**
     * TC = O(n)
     * SC = O(n)
     * @param edges
     * @return
     */
    public int findCenter(int[][] edges) {
        Map<Integer,Integer> fmap = new HashMap<>(); // calculate frequency map and compute how many times certain vertex appears in edge list
        for(int[] edge:edges){
            fmap.put(edge[0],fmap.getOrDefault(edge[0],0)+1);
            fmap.put(edge[1],fmap.getOrDefault(edge[1],0)+1);
        }

        for(int key:fmap.keySet()){
            if(fmap.get(key) == edges.length){ // if certain vertex appears edge no of times, that's the center node
                return key;
            }
        }
        return -1;
    }

    /**
     * TC = O(1)
     * SC = O(1)
     * @param edges
     * @return
     */
    public int findCenter1(int[][] edges) {
        //Since we know, for being center node, each vertex should connect to this center node i.e each edge list should have this vertex
        //we just compare any two edge to find out the common vertex, that will be centre node
        if(edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]){
            return edges[0][0];
        }
        else{
            return edges[0][1];
        }
    }

    @Test
    public void testing(){
        CenterOfStarGraph c = new CenterOfStarGraph();
        int [][] input ={{1,2},{2,3},{4,2}};
        Assert.assertEquals(2,c.findCenter(input));
        Assert.assertEquals(2,c.findCenter1(input));


        int [][] input1 = {{1,2},{5,1},{1,3},{1,4}};
        Assert.assertEquals(1,c.findCenter(input1));
        Assert.assertEquals(1,c.findCenter1(input1));
    }
}
