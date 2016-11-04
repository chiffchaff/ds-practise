package com.sumit.ds.dynamicprogramming.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * given a string, find position of a largest block of repeated characters...

 eg.   "aaabbbbccdccc" should return 3
 * Created by root on 10/1/16.
 */
public class LargestBlock {
    public int getLargestBlock(String input){
        if(input == null || input.length() == 0 )
            return -1;
        if(input.length() == 1)
            return 1;
        int findex = 0;
        char tmp = input.charAt(0);
        int count = 1;
        Map<Character,Counter> charOccurances = new HashMap();
        for(int i=1;i<input.length();i++){
            if(input.charAt(i) != tmp){
                updateMap(tmp, charOccurances, findex,count);
                tmp = input.charAt(i);
                findex = i;
                count = 1;
            }
            else{
                count++;
            }
        }
        /**
         * Handles inputs like 'aaaaa', this will be first addition to map
         * Handles inputs like 'aaaab', Last occurance of character 'b' needs to be added to map
         */
        updateMap(tmp, charOccurances, findex,count);

        return getMaxCharOccurances(charOccurances);
    }

    private int getMaxCharOccurances(Map<Character, Counter> charOccurances) {
        char mostOccuringChar = ']';
        int countOfMostOccuringChar = 0;
        int mostOccuringCharPosition = -1;
        for(Character ch:charOccurances.keySet()){
            if(charOccurances.get(ch).count > countOfMostOccuringChar){
                countOfMostOccuringChar = charOccurances.get(ch).count;
                mostOccuringChar = ch;
                mostOccuringCharPosition = charOccurances.get(ch).firstPosition;
            }
        }
        return mostOccuringCharPosition;
    }

    public void updateMap(char tmp, Map<Character,Counter> map,int findex, int count){
        if(map.containsKey(tmp)){
            // Discard occurrences of 'tmp' character if the count is less than what we have already placed in the map
            if (map.get(tmp).count < count){
                map.put(tmp, new Counter(findex, count));
            }
        }
        else {
            map.put(tmp, new Counter(findex, count));
        }
    }

    static class Counter{
        @Override
        public String toString() {
            return "Counter{" +
                    "firstPosition=" + firstPosition +
                    ", count=" + count +
                    '}';
        }

        int firstPosition;
        int count;
        public Counter(int firstPosition,int count){
            this.firstPosition = firstPosition;
            this.count = count;
        }
    }

    public static void main(String args[]){
        LargestBlock lb = new LargestBlock();
        System.out.println(lb.getLargestBlock("aaabbbbccdccc"));
    }
}
