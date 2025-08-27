package com.sumit.ds.leetcode.aug2025;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * https://leetcode.com/problems/uncommon-words-from-two-sentences/
 */
public class UncommonWords {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String,Integer> wf = new HashMap();
        getWordFrequency(s1,wf);
        getWordFrequency(s2,wf);
        List<String> result = new ArrayList();
        for(String word:wf.keySet()){
            if(wf.get(word) == 1){
                result.add(word);
            }
        }
        return result.toArray(new String[result.size()]);
    }

    public void getWordFrequency(String s,Map<String,Integer> wf){
        StringTokenizer st = new StringTokenizer(s);
        while(st.hasMoreTokens()){
            String word = st.nextToken();
            wf.put(word,wf.getOrDefault(word,0)+1);
        }
    }

    @Test
    public void testing(){
        UncommonWords uc = new UncommonWords();
        Assert.assertArrayEquals(new String[]{"banana"},uc.uncommonFromSentences("apple apple","banana"));
        Assert.assertArrayEquals(new String[]{"sweet","sour"},uc.uncommonFromSentences("this apple is sweet","this apple is sour"));
    }
}
