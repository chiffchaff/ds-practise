package com.sumit.ds.surya.assignments.day1;

/**
 * Calculate NCR value for given N and R
 * Binomial Coefficient
 */
public class CalculateNCR {
    public static void main(String[] args) {
        int n=4;
        int r=2;
        printNCR(n,r);
    }

    private static void printNCR(int n, int r) {
        int[][] pascalsTriangle = generatePascalsTriangle(n);
        System.out.println("No of ways to combine n into r ways is :"+pascalsTriangle[n][r]);

    }

    private static int[][] generatePascalsTriangle(int n) {
        n+=1; //to accomodate 0 based index
        int[][] pascalsTriangle = new int[n][n];
        for(int row=0;row<n;row++){
            for(int col=0;col<=row;col++){
                if(col == 0){
                    pascalsTriangle[row][col] = 1;
                }
                else {
                    pascalsTriangle[row][col] = pascalsTriangle[row-1][col-1]+pascalsTriangle[row-1][col];
                }
            }
        }
        return pascalsTriangle;
    }
}
