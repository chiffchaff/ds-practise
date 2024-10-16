package com.sumit.test;

import java.util.ArrayList;
import java.util.List;

public class GroupedSum {
    public static void main(String[] args) {
//        int[] input = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] input = {1,2,3,4};
        int[] output = groupedSum(input);

        // Print the result
        for (int sum : output) {
            System.out.print(sum + " ");
        }
    }

    public static int[] groupedSum(int[] input) {
        List<Integer> result = new ArrayList<>();
        int index = 0;
        int groupSize = 1;

        while (index < input.length) {
            int sum = 0;

            for (int i = 0; i < groupSize && index < input.length; i++) {
                sum += input[index];
                index++;
            }

            // Add the sum to the result list
            result.add(sum);

            groupSize++;
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
