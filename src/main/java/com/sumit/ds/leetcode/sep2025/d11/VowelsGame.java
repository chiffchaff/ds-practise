package com.sumit.ds.leetcode.sep2025.d11;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class VowelsGame {
    public boolean doesAliceWin(String s) {
        int vowelCount = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;
            }
        }
        return vowelCount > 0;
    }

    public boolean doesAliceWin1(String s) {
        int ag=0,bg=0,found=0;
        char vf = ' ';
        List<Character> vowels = Arrays.asList('a','e','i','o','u');

        for(char ch:s.toCharArray()){
            if(vowels.contains(ch)){
                if(vf==ch) {
                    found++;
                    vf = ch;
                }
                else{
                    if(found %2 == 0){
                        ag++; bg--;
                    }
                    else{
                        ag--;bg++;
                    }
                    found=0;vf=' ';
                }
            }
            else{
                if(vf != ' '){
                    if(found %2 == 0){
                        ag++; bg--;
                    }
                    else{
                        ag--;bg++;
                    }
                    found=0;vf=' ';
                }
            }
        }
        return (ag %2 != 0);
    }

    @Test
    public void testing(){
        VowelsGame vg = new VowelsGame();
        Assert.assertEquals(true, vg.doesAliceWin("leetcoder"));
        Assert.assertEquals(false, vg.doesAliceWin("leetcooder"));
    }
}
