package com.manindra.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SequenceEquation {

    public static void main(String[] args) {
        // Example input
        List<Integer> p = Arrays.asList(4, 3, 5, 1, 2);

        // Call the function
        List<Integer> result = permutationEquation(p);

        // Print output
        for (int val : result) {
            System.out.println(val);
        }
    }

    public static List<Integer> permutationEquation(List<Integer> p) {
        int n = p.size();
        int[] indexOf = new int[n + 1];  // 1-based indexing

        // Step 1: Store index positions of values in the lookup array
        for (int i = 0; i < n; i++) {
            indexOf[p.get(i)] = i + 1;  // Because p() is 1-based
        }

        List<Integer> result = new ArrayList<>();

        // Step 2: Compute y for each x from 1 to n
        for (int x = 1; x <= n; x++) {
            result.add(indexOf[indexOf[x]]);
        }

        return result;
    }
    public static List<Integer> permutationEquation2(List<Integer> p) {
        // p = [4, 3, 5, 1, 2]
        //      1  2  3  4  5

        int n = p.size();
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            // Find the index of 'i' in the input list 'p'
            int indexOfI = p.indexOf(i) + 1; // +1 to convert to 1-based index

            // Find the index of 'indexOfI' in the input list 'p'
            int indexOfIndexOfI = p.indexOf(indexOfI) + 1;

            result.add(indexOfIndexOfI);
        }

        return result;
    }

    public static List<Integer> permutationEquation(int[] p) {
        // p = [4, 3, 5, 1, 2]
        //      1  2  3  4  5

        int n = p.length;
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            // Find the index of 'i' in the input array 'p'
            int indexOfI = findIndex(p, i) + 1; // +1 to convert to 1-based index

            // Find the index of 'indexOfI' in the input array 'p'
            int indexOfIndexOfI = findIndex(p, indexOfI) + 1;

            result.add(indexOfIndexOfI);
        }

        return result;
    }

    // Helper function to find the index of a value in an array
    private static int findIndex(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1; // Return -1 if the value is not found
    }
}

