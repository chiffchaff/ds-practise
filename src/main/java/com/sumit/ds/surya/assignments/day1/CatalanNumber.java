package com.sumit.ds.surya.assignments.day1;

/**
 * 96. Unique Binary Search Trees
 * Time Complexity - O(n square)
 * Space Complexity - O(n)
 */
public class CatalanNumber {
    public static void main(String[] args) {
        System.out.println(getCatalanNumber(3));
        System.out.println(getCatalanNumber(4));
        //1,1,2,5,14
        //0 1 2 3 4
    }

    private static int getCatalanNumber(int n) {
        int arr[] = new int[n+1];
        arr[0]=arr[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                arr[i] += arr[j]*arr[i-j-1];
            }
        }
        return arr[n];
    }
}
