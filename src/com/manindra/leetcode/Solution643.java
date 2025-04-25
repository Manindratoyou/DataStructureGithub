package com.manindra.leetcode;

public class Solution643 { //Maximum Average Sub array I (sliding Window Technique)

    public static void main(String[] args) {

        int[] arr = {1, 12, -5, -6, 50, 3};
        System.out.println(findMaxAverage(arr, 4));
        System.out.println(findMaxAverage2(arr, 4));
    }

    static double findMaxAverage(int[] nums, int k) {
        // Get sum for starting window
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += nums[i];

        int maxSum = sum;

        // Start sliding window
        int startIndex = 0;
        int endIndex = k;
        while (endIndex < nums.length) {

            sum -= nums[startIndex]; // Remove previous element
            startIndex++;

            sum += nums[endIndex]; // Add next element
            endIndex++;

            maxSum = Math.max(maxSum, sum); // Update max sum
        }

        // Return the average
        return (double) maxSum / k;
    }

    static double findMaxAverage2(int[] nums, int k) {

        double ans = 0;
        double window = 0;
        for (int i = 0; i < k; i++) {
            window += nums[i];
        }
        ans = window / k;
        for (int right = k; right < nums.length; right++) {
            window += nums[right] - nums[right - k];
            ans = Math.max(ans, window / k);
        }
        return ans;
    }
}
