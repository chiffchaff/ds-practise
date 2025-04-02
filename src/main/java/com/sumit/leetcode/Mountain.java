package com.sumit.leetcode;

import org.junit.Test;
import org.testng.Assert;

import java.util.Arrays;

public class Mountain {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3) return false;
        int i=1;
        int peakFound = -1;
        while(i<arr.length && arr[i-1] < arr[i]){
            i++;
            peakFound=0;
        }
        i--;
        while(peakFound %2 == 0 && i<arr.length-1 && arr[i] > arr[i+1]){
            i++;peakFound=2;
        }
        return (peakFound == 2 && i == arr.length-1);
    }
    @Test
    public void testing(){
        Assert.assertTrue(validMountainArray(new int[]{0, 3, 2, 1})); // One Peak
        Assert.assertTrue(validMountainArray(new int[]{1,3,2})); // One Peak with only 3 elements
        Assert.assertFalse(validMountainArray(new int[]{3,3,5})); // Strictly increasing
        Assert.assertTrue(validMountainArray(new int[]{0,3,2,1})); // One Peak
        Assert.assertFalse(validMountainArray(new int[]{1,2,3,4})); // Strictly increasing
        Assert.assertFalse(validMountainArray(new int[]{4,3,2,1})); //Strictly decreasing
        Assert.assertFalse(validMountainArray(new int[]{1,3,2,1,5})); //two peaks
    }
}
