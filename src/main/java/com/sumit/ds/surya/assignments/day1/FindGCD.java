package com.sumit.ds.surya.assignments.day1;

/**
 * Elucidean Algorithm: LCM and GCD
 * Time Complexity O(log min(a,b))
 */
public class FindGCD {
    public static void main(String[] args) {
//        System.out.println(printGCDRecursive(12,10));
//        System.out.println(printGCD(12,10));
//        System.out.println(printGCDRecursive(36,12));
        System.out.println("GCD:"+printGCD(12,36));
        //System.out.println(printLCM(12,36));
        System.out.println("LCM:"+printLCM(36,12));

    }

    private static int printGCDRecursive(int a, int b) {
        System.out.println("(a:b)::("+a+","+b+")");
        if(a == 0)
            return b;
        return printGCDRecursive(b%a,a);
    }

    private static int printGCD(int a,int b){
        while(a != 0){
            System.out.println("(a:b)::("+a+","+b+")");
            int temp = a;
            a = b%a;
            b = temp;
        }
        return b;
    }

    private static int printLCMRecursive(int a, int b) {
        System.out.println("(a:b)::("+a+","+b+")");
        if(a == 0)
            return b;
        return printLCMRecursive(b/a,a);
    }

    private static int printLCM(int a,int b){
        //Note: We need to swap the numbers based on which is the greatest of the two numbers
        if(a>b){
            System.out.println("Swapping the numbers since a>b");
            System.out.println("Before swap: (a:b)::("+a+","+b+")");
            //Swap the number
            int temp = a;
            a=b;
            b=temp;
            System.out.println("After swap: (a:b)::("+a+","+b+")");
        }

        while(a != 0){
            System.out.println("(a:b)::("+a+","+b+")");
            int temp = a;
            a = b/a;
            b = temp;
            System.out.println("(a:b)::("+a+","+b+")");
        }
        return b;
    }
}
