package com.sumit.ds.leetcode.jan.one;

import java.util.Arrays;

public class LeetCode73 {
    public static void main(String[] args) {
        //int [][] matrix = {{0,1,0},{1,0,0},{1,1,1}};
        int [][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        computeZeros(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    private static void computeZeros(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int dummyRows[] = new int[rows];
        int dummyCols[] = new int[cols];
        Arrays.fill(dummyRows,-1);
        Arrays.fill(dummyCols,-1);
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j] == 0){
                    dummyRows[i]=0;
                    dummyCols[j]=0;
                }
            }
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(dummyRows[i]==0 || dummyCols[j]==0){
                    matrix[i][j]=0;
                }
            }
        }
    }
}
