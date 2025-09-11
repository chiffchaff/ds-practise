package com.sumit.ds.leetcode.sep2025.d10;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/sort-vowels-in-a-string/description/?envType=daily-question&envId=2025-09-11
 */
public class SortVowels {
    /**
     * TC = O(nlogn)
     * SC = O(n)
     * @param s
     * @return
     */
    public String sortVowels(String s) {
        List<Character> vowels = Arrays.asList('a','e','i','o','u','A','E','I','O','U');
        List<Integer> vIdx = new ArrayList();
        List<Character> vowelList = new ArrayList();
        for(int i=0;i<s.length();i++){
            if(vowels.contains(s.charAt(i))){
                vIdx.add(i);
                vowelList.add(s.charAt(i));
            }
        }
        vowelList.sort((a,b)->(a.compareTo(b))); // Capital letters comes first than small letters, so sort in asc order

        char[] chars = s.toCharArray();
        int idx = 0;
        for(int i:vIdx){
            chars[i]=vowelList.get(idx++);
        }
        return new String(chars);
    }
    @Test
    public void testing(){
        SortVowels sv = new SortVowels();
        Assert.assertEquals("lEOtcede",sv.sortVowels("lEetcOde"));
    }
}
