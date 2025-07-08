package com.manindra.array_leetcode1;

public class KthMissingPositiveNumber { //solution 1539

    public static void main(String[] args) {
        // Create a test case
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;

        // Create an instance of the class and call the method
        KthMissingPositiveNumber solution = new KthMissingPositiveNumber();
        int result = solution.findKthPositive(arr, k);

        // Print the result
        System.out.println("The " + k + "-th missing positive integer is: " + result);
    }

    // Implementation using binary search with proper comments
    static int findKthPositive(int[] arr, int k) {
        // Initialize the left and right pointers
        int left = 0;
        int right = arr.length;

        // Start a loop and keep moving till left is less than right
        while (left < right) {
            // Calculate the mid
            int mid = left + (right - left) / 2;

            // If the number of missing elements is less than k
            if (arr[mid] - mid - 1 < k) {
                // Move left to mid + 1
                left = mid + 1;
            } else {
                // Move right to mid
                right = mid;
            }
        }

        // Return the kth missing element
        return left + k;
    }

}
