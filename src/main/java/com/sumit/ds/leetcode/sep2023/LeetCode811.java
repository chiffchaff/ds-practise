package com.sumit.ds.leetcode.sep2023;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/subdomain-visit-count/
 */
public class LeetCode811 {
        public List<String> subdomainVisits1(String[] cpdomains) {
            Map<String, Integer> map = new HashMap<>();

            Arrays.stream(cpdomains).forEach(dom -> {
            String[] parts = dom.split(" ");
            int count = Integer.valueOf(parts[0]);
            String domain = parts[1];
            String[] subdomains = domain.split("\\.");

            StringBuilder currentDomain = new StringBuilder();
            for (int i = subdomains.length - 1; i >= 0; i--) {
                currentDomain.insert(0, subdomains[i]);
                map.compute(currentDomain.toString(), (k, v) -> (v == null) ? count : v + count);
                if (i != 0) currentDomain.insert(0, ".");
            }
        });

        return map.entrySet()
                .stream()
                .map(entry -> entry.getValue() + " " + entry.getKey())
                .collect(Collectors.toList());
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map = new HashMap<>();
        for(String dom : cpdomains){
            String s[]= dom.split("[. ]");
            int val=Integer.valueOf(s[0]);
            String domain="";
            for(int i=s.length-1;i>0;i--){
                if(!domain.equals("")) domain="."+domain;
                domain=s[i]+domain;
                map.put(domain,map.getOrDefault(domain,0)+val);
            }
        }

        List<String> output = map.entrySet()
                .stream()
                .map(entry -> entry.getValue() + " " + entry.getKey())
                .collect(Collectors.toList());
        return output;
    }

    @Test
    public void testing(){
        String [] cpdomain ={"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(subdomainVisits1(cpdomain));
        System.out.println(subdomainVisits(cpdomain));

    }
}
