package com.sumit.ds.leetcode.aug2025;


import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Intuit : Phone Screening round
 * Implement RateLimiter for clients, c1,c2,c3
 * rate limit to 5 clients per sec.
 * WIP :::
 */
class ClientTime{
    String client;
    long timemillis;

    public ClientTime(String client,long timemillis){
        this.client = client;
        this.timemillis = timemillis;
    }
}


public class RateLimiter {
    Queue<ClientTime> queue = new LinkedList<ClientTime>();
    long currentMillis = System.currentTimeMillis();
    int counter = 5;

    public void enqueue(String client){
        queue.offer(new ClientTime(client,System.currentTimeMillis()));
    }

    public boolean dequeue(){
        boolean result = false;
        if(!queue.isEmpty()){
            ClientTime ct = queue.peek();
            long delta = ct.timemillis - currentMillis;
            if(delta<=1000 && counter >=1){
                queue.poll();
                System.out.println("client : "+ct.client);
                result = true;
                counter--;
                if(counter<1){
                    counter=5;
                }
            }
            else{
                currentMillis = ct.timemillis;
            }
        }
        return result;
    }
    @Test
    public void testing(){
        RateLimiter rt = new RateLimiter();
        rt.enqueue("c1");
        rt.enqueue("c2");
        rt.enqueue("c3");
        rt.enqueue("c4");
        rt.enqueue("c5");
        rt.enqueue("c6");
        System.out.println(rt.dequeue());
        System.out.println(rt.dequeue());
        System.out.println(rt.dequeue());
        System.out.println(rt.dequeue());
        System.out.println(rt.dequeue());
        System.out.println(rt.dequeue());


    }
}

