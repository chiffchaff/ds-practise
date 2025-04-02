package com.sumit.techdose.assignments.heap;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

class Node{
    int value;
    int index;
    Node(int value,int index){
        this.value = value;
        this.index=index;
    }
}

//LeetCode : 239
public class SlidingWindowMax {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || (nums != null && nums.length < k))
            return null;
        //Step 1: Build Max Heap of size k
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> (b.value - a.value));
        for (int i = 0; i < k; i++) {
            pq.add(new Node(nums[i], i));
        }
        //Loop for 1 to n-k + 1
        int outputSize = nums.length - k + 1;
        int[] output = new int[outputSize];
        for (int i = 1; i <=outputSize; i++) {
            System.out.println("i="+i);
            Node maxSoFar = pq.peek();
            output[i - 1] = maxSoFar.value; // Add max of window to output
            System.out.println("maxSoFar:"+maxSoFar.value+":"+maxSoFar.index);
            int indexToAdd = i + k -1;
            pq.add(new Node(nums[indexToAdd], indexToAdd));
            if (maxSoFar.index < i) { //if out of bound, remove the maxSoFar
                System.out.println("removing maxSoFar:"+maxSoFar.value+":"+maxSoFar.index);
            }
        }
//        System.out.println("adding "+pq.peek().value + ":"+pq.peek().index);
//        output[outputSize-1] = pq.peek().value;
        return output;
    }



    @Test
    public void testing(){
//        int nums[] = {1,3,-1,-3,5,3,6,7};
//        int k = 3;

        int nums[] = {9,10,9,-7,-4,-8,2,-6};

        int k = 5;

        System.out.println(Arrays.toString(maxSlidingWindow(nums,k)));
    }

}
