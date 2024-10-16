package com.sumit.ds.surya.assignments.day4;

import org.junit.Test;

import java.util.Arrays;


public class MergeSort {
    @Test
    public void testing(){
        int arr[] = {5,1,3,4,8,7};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    private int[] mergeSort(int[] arr) {
        if(arr != null)
        {
            return _mergeSort(arr,0,arr.length-1);
        }
        return null;
    }

    private int[] _mergeSort(int[] arr, int low, int high) {
        if(low == high) {
            int []temp = new int[1];
            temp[0]=arr[low];
            return temp;
        }
        int mid = low + (high-low)/2;
        _mergeSort(arr,low,mid);
        _mergeSort(arr,mid+1,high);
        int sorted[] = mergeTwoSortedArrays(arr,low,mid,high);
        return sorted;
    }

    private int[] mergeTwoSortedArrays(int[] arr, int low, int mid, int high) {
        int leftPointer = low;
        int rightPointer= mid+1;
        int newArr[] = new int[high+1];
        int i = 0;
        while(leftPointer <= mid || rightPointer <high){
            if(arr[leftPointer] <= arr[rightPointer]){
                newArr[i++] = arr[leftPointer];
                leftPointer++;
            }
            else{
                newArr[i++] = arr[rightPointer];
                rightPointer++;
            }
        }
        if(leftPointer != mid){
            for(int j=leftPointer;j<=mid;j++){
                newArr[i++]=arr[j];
            }
        }
        if(rightPointer+1 != high){
            for(int j=rightPointer;j<high;j++){
                newArr[i++] = arr[j];
            }
        }
        return newArr;
    }

}
