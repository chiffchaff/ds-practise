package com.sumit.ds.leetcode.mar2024;


public class FactorialGraph {
     static int Id=0;
    public static void main(String[] args) {
        int i = 5;
        System.out.println("digraph {\n");
        fibonacci(i);
        System.out.println("}\n");
    }

    private static int fibonacci(int n) {
        int callId=Id++;
        System.out.println("fib"+callId+" [label=\"fib("+n+")\"]\n");
        if(n <= 1) return 1;
        System.out.println("fib"+callId+" ->fib"+Id+"\n");
        int fibNMinus2 = fibonacci(n-2);
        System.out.println("fib"+callId+" ->fib"+Id+"\n");
        int fibNMinus1 = fibonacci(n-1);
        return fibNMinus2 + fibNMinus1;

    }
}
