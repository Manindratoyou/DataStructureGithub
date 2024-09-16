package com.manindra.iitp.lab5101;

public class Largestsubarraywith0 {

    public static void main(String[] args) {
        // Test case 1: Mixed positive and negative numbers with zero-sum subarray
        int[] arr1 = {15, -2, 2, -8, 1, 7, 10, 23};
        System.out.println("Test case 1: Largest subarray length with sum 0: " + largestSubarrayWithSumZero(arr1));

        // Test case 2: All elements are zero
        int[] arr2 = {0, 0, 0, 0};
        System.out.println("Test case 2: Largest subarray length with sum 0: " + largestSubarrayWithSumZero(arr2));

        // Test case 3: No zero-sum subarray
        int[] arr3 = {1, 2, 3};
        System.out.println("Test case 3: Largest subarray length with sum 0: " + largestSubarrayWithSumZero(arr3));

        // Test case 4: Subarray with sum 0 is the entire array
        int[] arr4 = {-1, 1};
        System.out.println("Test case 4: Largest subarray length with sum 0: " + largestSubarrayWithSumZero(arr4));

        // Test case 5: Empty array (edge case)
        int[] arr5 = {};
        System.out.println("Test case 5: Largest subarray length with sum 0: " + largestSubarrayWithSumZero(arr5));
    }

    public static int largestSubarrayWithSumZero(int[] arr) {
        int n = arr.length;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += arr[j];

                if (currentSum == 0) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }
}
