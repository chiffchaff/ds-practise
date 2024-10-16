package com.sumit.test;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    @Test
    public void checkPriorityQueue(){
        int []arr =  {10,1,5,2,7};
        {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i : arr) {
                pq.add(i);
            }
            System.out.println("Printing the ascending sorted array");
            while (!pq.isEmpty()) {
                System.out.println(pq.poll());
            }
        }
        {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for(int i:arr){
                pq.add(i);
            }
            System.out.println("Printing the descending sorted array ");
            while(!pq.isEmpty()){
                System.out.println(pq.poll());
            }

        }
        { // Print k th largest number
            int k =2;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i:arr){
                pq.add(i);
                if(pq.size()>k){
                    pq.poll();
                }
            }
            System.out.println("Kth largest element :"+pq.poll());
        }
    }
}
