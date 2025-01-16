package com.manindra.hackerrank;

import java.util.Arrays;
import java.util.List;

public class TheMaximumSubarray { //similar leet code 53

    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4);
        System.out.println(maxSubarray(arr));
        //6: Maximum subarray sum ([4, -1, 2, 1]).
        //12: Maximum subsequence sum 1 + 4 + 2 + 1 + 4 = 12

    }

    public static List<Integer> maxSubarray(List<Integer> arr) {
        // Calculate maximum subarray sum using Kadane's algorithm
        int maxSubarraySum = arr.get(0);
        int maxEnding = arr.get(0);

        // Calculate maximum subsequence sum
        int maxSubsequenceSum = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            int current = arr.get(i);

            // Update Kadane's algorithm
            maxEnding = Math.max(maxEnding + current, current);
            maxSubarraySum = Math.max(maxSubarraySum, maxEnding);

            // Update subsequence sum
            maxSubsequenceSum = Math.max(maxSubsequenceSum,
                    Math.max(current, maxSubsequenceSum + (current > 0 ? current : 0)));
        }

        // Return both results as a list
        return Arrays.asList(maxSubarraySum, maxSubsequenceSum);
    }

}
