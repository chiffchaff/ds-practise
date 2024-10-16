package com.sumit.ds.leetcode.may2023;

import org.junit.Test;

public class LeetCode59 {
    public int[][] generateMatrix(int n) {
        int top =0;
        int bottom = n-1;
        int left=0;
        int right = n-1;
        int direction = 0; //0 = move right, 1 = move down,2 = move left, 3=move up
        int res[][]=new int[n][n];
        int counter=1;
        while(top <=bottom && left <= right){
            if(direction == 0){
                for(int i=left;i<=right;i++){
                    res[top][i]=counter++;
                }
                top+=1;
            }
            else if(direction == 1){
                for(int i=top;i<=bottom;i++){
                    res[i][right]=counter++;
                }
                right-=1;
            }
            else if(direction == 2){
                for(int i=right;i>=left;i--){
                    res[bottom][i]=counter++;
                }
                bottom-=1;
            }
            else if(direction ==3){
                for(int i=bottom;i>=top;i--){
                    res[i][left] = counter++;
                }
                left+=1;
            }
            direction = (direction +1)%4;
        }
        return res;
    }

    @Test public void testing(){
        int n =3;
        int res[][] = generateMatrix(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
}
