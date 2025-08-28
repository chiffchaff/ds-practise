package com.sumit.ds.leetcode.aug2025;

import org.junit.Test;
import org.testng.collections.Lists;

import java.util.*;
import java.util.stream.Collectors;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,List<Set<String>>> accMap = new HashMap<>();
        Set<String> currEmails = new TreeSet<>();
        List<Set<String>> existingEmails = null;
        for(List<String> acc:accounts){
            currEmails.addAll(acc.stream().filter(x->!x.equals(acc.get(0))).collect(Collectors.toList()));
            if(accMap.containsKey(acc.get(0))){
                existingEmails = accMap.get(acc.get(0));
                accMap.put(acc.get(0),mergeEmails(currEmails,existingEmails));
            }
            else{
                accMap.put(acc.get(0),Arrays.asList(currEmails));
            }
            currEmails.clear();
        }

        List<List<String>> output = new ArrayList<>();
        for(String name: accMap.keySet()){
            List<Set<String>> emails = accMap.get(name);
            for(Set<String> emailSet: emails){
                output.add(Lists.merge(Arrays.asList(name),emailSet));
            }
        }
        return output;
    }

    private List<Set<String>> mergeEmails(Set<String> currEmails, List<Set<String>> existingEmails) {
        //TODO: merge all the lists
        /**
         * Ex:
         * Existing :: (a,b),(c,d)
         * New: (c,e)
         * output: (a,b),(c,d,e)
         *
         Existing :: (a,b),(c,d)
         New: (b,c)
         output: (a,b,c,d)
         */
        return null;
    }

    @Test
    public void testing(){

    }
}

