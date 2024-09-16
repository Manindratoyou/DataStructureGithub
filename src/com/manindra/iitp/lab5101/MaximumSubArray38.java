package com.manindra.iitp.lab5101;

import java.util.HashMap;

public class MaximumSubArray38 {

    public static void main(String[] args) {
        // Test case 1: Positive and negative numbers
        int[] arr1 = {1, -2, 3, 4, -1, 2, 1, -5, 4};
        System.out.println("Test case 1: Maximum subarray sum:");
        System.out.println(findMaxSubArraySum(arr1)); // Expected output: 7

        // Test case 2: All negative numbers
        int[] arr2 = {-3, -2, -5, -1, -4};
        System.out.println("Test case 2: Maximum subarray sum:");
        System.out.println(findMaxSubArraySum(arr2)); // Expected output: -1

        // Test case 3: Single element array
        int[] arr3 = {5};
        System.out.println("Test case 3: Maximum subarray sum:");
        System.out.println(findMaxSubArraySum(arr3)); // Expected output: 5

        // Test case 4: Entire array is the max subarray
        int[] arr4 = {2, 3, 4, 5, 6};
        System.out.println("Test case 4: Maximum subarray sum:");
        System.out.println(findMaxSubArraySum(arr4)); // Expected output: 20
    }

    public static int findMaxSubArraySum(int[] arr) {
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main1(String[] args) {
        // Test case 1: Positive and negative numbers with a zero-sum subarray
        int[] arr1 = {1, -1, 3, 2, -2, 4, -4, 5};
        System.out.println("Test case 1: Length of largest zero-sum subarray:");
        System.out.println(findMaxZeroSumSubArrayLength(arr1)); // Expected output: 6

        // Test case 2: No zero-sum subarray
        int[] arr2 = {1, 2, 3, 4};
        System.out.println("Test case 2: Length of largest zero-sum subarray:");
        System.out.println(findMaxZeroSumSubArrayLength(arr2)); // Expected output: 0

        // Test case 3: Entire array is zero-sum
        int[] arr3 = {0, 0, 0, 0};
        System.out.println("Test case 3: Length of largest zero-sum subarray:");
        System.out.println(findMaxZeroSumSubArrayLength(arr3)); // Expected output: 4

        // Test case 4: All negative numbers
        int[] arr4 = {-1, -2, -3, -4};
        System.out.println("Test case 4: Length of largest zero-sum subarray:");
        System.out.println(findMaxZeroSumSubArrayLength(arr4)); // Expected output: 0
    }

    public static int findMaxZeroSumSubArrayLength(int[] arr) {
        // HashMap to store (cumulative sum, index)
        HashMap<Integer, Integer> map = new HashMap<>();

        int maxLength = 0;
        int cumulativeSum = 0;

        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];

            // If cumulative sum is 0, we found a subarray from index 0 to i
            if (cumulativeSum == 0) {
                maxLength = i + 1;
            }

            // If the cumulative sum is seen before, there's a subarray with sum 0
            if (map.containsKey(cumulativeSum)) {
                int prevIndex = map.get(cumulativeSum);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                // Store the first occurrence of this cumulative sum
                map.put(cumulativeSum, i);
            }
        }

        return maxLength;
    }
}
