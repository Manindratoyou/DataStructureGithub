package com.manindra.array_leetcode2;

import java.util.*;

public class MinimumAbsoluteDifference { //solution 1200

    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 3};
        int[] arr1 = {1, 3, 6, 10, 15};
        int[] arr2 = {3, 8, -10, 23, 19, -4, -14, 27};
        //List<List<Integer>> output = minimumAbsDifference(arr);
        List<List<Integer>> output = minimumAbsDifference(arr2);

        System.out.println("Minimum Absolute Difference Pairs:");
        for (List<Integer> pair : output) {
            System.out.println(pair);
        }
    }

    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);  // Step 1: Sort the array
        List<List<Integer>> result = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        // Step 2: Find the minimum absolute difference
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            if (diff < minDiff) {
                minDiff = diff;
                result.clear();  // Clear previous pairs
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if (diff == minDiff) {
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return result;
    }
}

