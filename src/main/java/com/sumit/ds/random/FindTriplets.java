package com.sumit.ds.random;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/count-triplets-1/problem
 * https://www.youtube.com/watch?v=tBFZMaWP0W8&t=2s
 */
public class FindTriplets {
    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        Map<Long,Long> lfMap = new HashMap<Long,Long>();
        Map<Long,Long> rfMap = new HashMap<Long,Long>();
        for(int i=0;i<arr.size();i++){
            rfMap.put(arr.get(i),rfMap.getOrDefault(arr.get(i), 0L)+1);
        }

        lfMap.put(arr.get(0), 1L);
        long count=0;
        for(int i=1;i<arr.size();i++){
            long mid = arr.get(i);
            long lc = 0;
            if(lfMap.containsKey(mid/r) && mid%r==0){
                lc = lfMap.get(mid/r);
            }
            long rc = 0;
            if(rfMap.containsKey(mid*r)){
                rc=rfMap.get(mid*r);
            }
            count+=lc*rc;
            lfMap.put(mid, lfMap.getOrDefault(mid, 0L)+1L);
            rfMap.put(mid, rfMap.get(mid)-1L);
        }
        return count;
    }

    @Test
    public void testing(){
        long[] input = {1,2 ,2 ,4};
        long r = 2;

        long count = countTriplets(Arrays.stream(input).boxed().collect(Collectors.toList()),r);
        System.out.println(count);
    }

    @Test
    public void testing1(){
        long[] input = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        long r = 1;

        long count = countTriplets(Arrays.stream(input).boxed().collect(Collectors.toList()),r);
        System.out.println(count);
        //Expected output: 161700
    }

    @Test
    public void testing2(){
        long[] input = {1, 1, 1};
        long r = 1;

        long count = countTriplets(Arrays.stream(input).boxed().collect(Collectors.toList()),r);
        System.out.println(count);
        //Expected output: 161700
    }

    @Test
    public void testing3(){
        long[] input = {1, 1, 1};
        long r = 1;

        long count = countTriplets(Arrays.stream(input).boxed().collect(Collectors.toList()),r);
        System.out.println(count);
        //Expected output: 161700
    }

    @Test
    public void testing4(){
        long[] input = {1237};//repeated 100000 times
        long r = 1;

        long count = countTriplets(Arrays.stream(input).boxed().collect(Collectors.toList()),r);
        System.out.println(count);
        //Expected output: 166661666700000
    }

    @Test
    public void testing5(){
        long[] input = {1237};//repeated 100000 times
        long r = 1;

        long count = countTriplets(Arrays.stream(input).boxed().collect(Collectors.toList()),r);
        System.out.println(count);
        //Expected output: 166661666700000
    }

}
