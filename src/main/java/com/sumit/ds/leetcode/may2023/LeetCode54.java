package com.sumit.ds.leetcode.may2023;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * https://leetcode.com/problems/spiral-matrix/
 */
public class LeetCode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int top=0;
        int down=row-1;
        int left=0;
        int right=col-1;
        int direction = 0; //0 = move right, 1 = move down, 2 = move left, 3 = move up
        while(top<=down && left<=right){
            if(direction == 0){
                for(int i=left;i<=right;i++){
                    res.add(matrix[top][i]);
                }
                top +=1;
            }
            else if(direction == 1){
                for(int i=top;i<=down;i++){
                    res.add(matrix[i][right]);
                }
                right -=1;
            }
            else if(direction == 2){
                for(int i=right;i>=left;i--){
                    res.add(matrix[down][i]);
                }
                down -= 1;
            }
            else if(direction == 3){
                for(int i=down;i>=top;i--){
                    res.add(matrix[i][left]);
                }
                left +=1;
            }
            direction = (direction + 1) % 4;
        }

        return res;
    }



    @Test public void testing(){
//        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        int matrix[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        System.out.println(spiralOrder(matrix));
    }
}
