package com.sumit.ds.surya.assignments.day3;

public class CountSetBits {
    public static void main(String[] args) {
        System.out.println("set Bits :"+countSetBits(15)); //1111
        System.out.println("set Bits :"+countSetBits(10)); //1010
    }

    private static int countSetBits(int n) {
        int count=0;
        while(n>0){
            n = n & (n -1);
            count++;
        }
        return count;
    }
}
