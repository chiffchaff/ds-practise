package com.sumit.ds.surya.assignments.day2;

public class ValidatePowerofTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(5));
        System.out.println(isPowerOfTwo(4));
        System.out.println(isPowerOfTwo(6));
        System.out.println(isPowerOfTwo(10));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(14));
        System.out.println(isPowerOfTwo(15));

        System.out.println(isPowerOfTwoBitWise(6));
    }

    /**
     * Time Complexity = O(Log n)
     * https://chat.openai.com/share/69161741-842f-4a8c-9fa0-c0b62a37d93e
     * @param n
     * @return
     */
    private static boolean isPowerOfTwoBitWise(int n) {
        if (n <= 0)
            return false;
        return (n & (n-1)) == 0;
    }

    /**
     * Time Complexity - O(Log n) base 2
     * @param n
     * @return
     */
    private static boolean isPowerOfTwo(int n) {
        int q=n;
        while(q>1){
            if(q%2 == 1)
                return false;
            q/=2;
        }
        return true;
    }
}
