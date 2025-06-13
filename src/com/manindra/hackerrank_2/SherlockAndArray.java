package com.manindra.hackerrank_2;

import java.util.*;

public class SherlockAndArray {

    public static String balancedSums(List<Integer> arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            int current = arr.get(i);
            int rightSum = totalSum - leftSum - current;
            if (leftSum == rightSum) {
                return "YES";
            }
            leftSum += current;
        }

        return "NO";
    }

    public static void main(String[] args) {
        List<List<Integer>> testCases = Arrays.asList(
                Arrays.asList(1, 2, 3),          // NO
                Arrays.asList(1, 2, 3, 3),       // YES
                Arrays.asList(1, 1, 4, 1, 1),    // YES
                Arrays.asList(2, 0, 0, 0),       // YES
                Arrays.asList(0, 0, 2, 0),       // YES
                Arrays.asList(10, 5, 3, 2),      // NO
                Arrays.asList(0),                // YES (single element)
                Arrays.asList(1, 0, 1),          // YES
                Arrays.asList(1, 1, 1, 1, 4),    // NO
                Arrays.asList(2, 2, 2, 2, 8)     // YES
        );

        for (List<Integer> testCase : testCases) {
            String result = balancedSums(testCase);
            System.out.println("Input: " + testCase + " => Output: " + result);
        }
    }
}

