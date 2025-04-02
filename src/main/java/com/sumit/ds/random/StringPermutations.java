package com.sumit.ds.random;

import java.util.*;

public class StringPermutations {

    // Function to generate permutations of a string
    public static void generatePermutations(String str) {  // Line 1
        System.out.println("Permutations:");
        boolean[] visited = new boolean[str.length()];  // Line 2
        StringBuilder current = new StringBuilder();  // Line 3
        generatePermutationsHelper(str, visited, current);  // Line 4
    }

    // Helper function to generate permutations (using backtracking)
    private static void generatePermutationsHelper(String str, boolean[] visited, StringBuilder current) {  // Line 5
        if (current.length() == str.length()) {  // Line 6
            System.out.println(current.toString());  // Line 7
            return;  // Line 8
        }

        for (int i = 0; i < str.length(); i++) {  // Line 9
            if (visited[i]) continue;  // Line 10

            visited[i] = true;  // Line 11
            current.append(str.charAt(i));  // Line 12
            generatePermutationsHelper(str, visited, current);  // Line 13
            visited[i] = false;  // Line 14
            current.deleteCharAt(current.length() - 1);  // Line 15
        }
    }

    public static void main(String[] args) {
        String input = "AB";  // Line 16
        generatePermutations(input);  // Line 17
    }
}

