package com.sumit.ds.fremont.meetup;

import java.util.Arrays;

/**
 * Created by root on 10/10/16.
 * Find the max product value of 3 number from the given array.
 * For example , if array has [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16] find the max product from three numbers.
 * max_product(x*y*z)
 Twist is array can contain negative number as well
 */
public class MaxProduct {


    public long maxProduct(int input[],int m) {
        long product = 0;
        int maxNo[] = new int[m];
        if(input !=  null){
            if(input.length <3)
                product = 0;
            else if (input.length == 3){
                product = input[0]*input[1]*input[2];
            }
            else{
                    maxNo[0] = findMax(input, -99999);
                    maxNo[1]= findMax(input, maxNo[0]);
                maxNo[2]= findMax(input, maxNo[1]);
            }
        }
        return product;
    }

    private int findMax(int[] input, int max) {
        int resultmax = max;
        for (int i=0;i<input.length;i++){
            if(input[i] > resultmax)
                resultmax = input[i];
        }
        return resultmax;
    }

    public static void main(String args[]){
        int num[] = {4 , -2, 3, 6, 10};
        //Arrays.sort(num, (a, b) -> Integer.signum(a) - Integer.signum(b));

        // returns 1 as int value is greater than 1
        System.out.println(Integer.signum(50));

        // returns -1 as int value is less than 1
        System.out.println(Integer.signum(-50));

        // returns 0 as int value is equal to 0
        System.out.println(Integer.signum(0));
    }

}
