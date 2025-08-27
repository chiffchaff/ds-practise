package com.sumit.ds.leetcode.aug2025;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/maximum-number-of-balloons/description/
public class MaxBalloons {
    public int maxNumberOfBalloons(String text) {
        Map<Character,Integer> textMap = new HashMap();
        for(char ch:text.toCharArray()){
            textMap.put(ch,textMap.getOrDefault(ch,0)+1);
        }

        Map<Character,Integer> balloonMap = new HashMap();
        String balloon= "balloon";
        for(char ch:balloon.toCharArray()){
            balloonMap.put(ch,balloonMap.getOrDefault(ch,0)+1);
        }
        int i =0;
        boolean charMatch=true;
        for(i=text.length()/balloon.length();i>=1;i--){
            for(char ch:balloonMap.keySet()){
                if(textMap.containsKey(ch)){
                    charMatch = charMatch && (balloonMap.get(ch)*i <= textMap.get(ch));
                }
                else{
                    charMatch=false;
                }
            }
            if(charMatch) break;
            if(i!=1) charMatch=true;
        }
        return (charMatch)?i:0;
    }
    @Test
    public void testing(){
        MaxBalloons mb = new MaxBalloons();
//        Assert.assertEquals(0,mb.maxNumberOfBalloons("nllbblooon"));
        Assert.assertEquals(1,mb.maxNumberOfBalloons("balllllllllllloooooooooon"));


    }
}
