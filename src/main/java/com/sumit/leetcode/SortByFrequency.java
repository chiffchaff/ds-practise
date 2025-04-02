package com.sumit.leetcode;

import org.junit.Test;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortByFrequency {

    public String frequencySort(String s) {
        PriorityQueue<Node> maxHeap = new PriorityQueue<Node>((n1,n2)->(n2.count.compareTo(n1.count)));
        Map<Character, Node> map = new HashMap();
        for(Character ch:s.toCharArray()){
            if(!map.containsKey(ch)){
                Node n = new Node(ch,1);
                map.put(ch,n);
                maxHeap.add(n);
            }
            else{
                Node n = map.get(ch);
                maxHeap.remove(n);
                n.count++;
                maxHeap.add(n);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()){
            Node n = maxHeap.poll();
            for(int i=1;i<=n.count;i++)
                sb.append(n.ch);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    @Test
    public void testing(){
        Assert.assertEquals("eetr",frequencySort("tree"));
        Assert.assertEquals("ter",frequencySort("tre"));
        Assert.assertEquals("cccaaa",frequencySort("cccaaa"));
        Assert.assertEquals("aaacccbbbdd",frequencySort("abcdabcdabc"));
    }

    public static String frequencySort1(String s) {
        Map<Character, Long> charMap = s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        // System.out.println(charMap);
        charMap.entrySet().stream().sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                .forEach(System.out::println);
        return null;
    }
}
class Node {
    public Character ch;
    public Integer count;

    public  Node(Character ch,int count){
        this.ch=ch;
        this.count=count;
    }
}