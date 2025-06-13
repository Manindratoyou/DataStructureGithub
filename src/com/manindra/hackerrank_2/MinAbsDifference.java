package com.manindra.hackerrank_2;

import java.util.*;

public class MinAbsDifference {

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        // Sort the list
        Collections.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < arr.size(); i++) {
            int diff = Math.abs(arr.get(i) - arr.get(i - 1));
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }

    public static void main(String[] args) {
        // Sample Test Case 0
        List<Integer> arr1 = Arrays.asList(3, -7, 0);
        System.out.println("Output: " + minimumAbsoluteDifference(arr1)); // 3

        // Sample Test Case 1
        List<Integer> arr2 = Arrays.asList(-59, -36, -13, 1, -53, -92, -2, -96, -54, 75);
        System.out.println("Output: " + minimumAbsoluteDifference(arr2)); // 1

        // Sample Test Case 2
        List<Integer> arr3 = Arrays.asList(1, -3, 71, 68, 17);
        System.out.println("Output: " + minimumAbsoluteDifference(arr3)); // 3

        // Extra test case
        List<Integer> arr4 = Arrays.asList(5, 8, 12, 17);
        System.out.println("Output: " + minimumAbsoluteDifference(arr4)); // 3
    }
}

