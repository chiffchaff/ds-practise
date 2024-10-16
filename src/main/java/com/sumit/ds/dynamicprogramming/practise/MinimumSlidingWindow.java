package com.sumit.ds.dynamicprogramming.practise;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 * Problem: 76
 */
public class MinimumSlidingWindow {

    /**
    @Test
    public String minSlidingWindow(String input,String pattern){
        String result = "";

        Map<String,Integer> patternMap = new HashMap<>();
        Stream.of(pattern.toCharArray()).forEach(x->patternMap.put(new String(x),new Integer(-1)));

        int start =0;
        int end = 0;
        int counter = pattern.length();
        while(end < input.length()){
            if(patternMap.get(input.charAt(end)) < 0 ){
                counter--;
            }
            patternMap.put(input.charAt(end)+"",(int)patternMap.get(input.charAt(end))+1);
            end++;
        }

        int min = findMin(start,end);

        while(counter == 0){
            if(patternMap.get(input.charAt(start)) < 0){
                counter++;
            }
            patternMap.put(patternMap.get(pattern.charAt(start))+"",(int)patternMap.get(input.charAt(end)-1));
                    start++;
        }
        return result;

    }
    **/

    private int findMin(int start, int end) {
        return -1;
    }


}
