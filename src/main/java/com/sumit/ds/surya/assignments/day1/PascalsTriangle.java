package com.sumit.ds.surya.assignments.day1;

/**
 * Build Pascal's Triangle in matrix
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        printPascalsTriangle(5);
    }

    private static void printPascalsTriangle(int i) {
        i+=1;//to accomodate 0 based index
        int [][] matrix = new int[i][i];
        for(int row=0;row<i;row++){
            for(int col=0;col<=row;col++){
                if(col==0){
                    matrix[row][col] = 1;
                }
                else{
                    matrix[row][col] = matrix[row-1][col-1]+matrix[row-1][col];
                }
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }
    }
}
