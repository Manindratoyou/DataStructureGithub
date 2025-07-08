package com.manindra.array_leetcode1;

public class Solution1991 { //question same as solution 724

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {1, 7, 3, 6, 5, 6}; // Middle index: 3
        int[] nums2 = {1, 2, 3};          // No middle index: -1
        int[] nums3 = {2, 1, -1};         // Middle index: 0
        int[] nums4 = {1, -1, 1, -1, 1};  // Middle index: 2
        int[] nums5 = {0, 0, 0, 0, 0};    // Any index can be the middle: 0

        System.out.println("Middle Index of nums1: " + findMiddleIndex(nums1)); // Output: 3
        System.out.println("Middle Index of nums1: " + findMiddleIndexSolutionTwo(nums1)); // Output: 3
        System.out.println("Middle Index of nums1: " + findMiddleIndexSolutionThree(nums1)); // Output: 3
        System.out.println("Middle Index of nums2: " + findMiddleIndex(nums2)); // Output: -1
        System.out.println("Middle Index of nums3: " + findMiddleIndex(nums3)); // Output: 0
        System.out.println("Middle Index of nums4: " + findMiddleIndex(nums4)); // Output: 2
        System.out.println("Middle Index of nums5: " + findMiddleIndex(nums5)); // Output: 0
    }

    public static int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        int[] suffixSum = new int[n];

        prefixSum[0] = nums[0];
        suffixSum[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            if (prefixSum[i] == suffixSum[i])
                return i;
        }

        return -1;
    }

    public static int findMiddleIndexSolutionTwo(int[] nums) {
        // Step 1: Calculate the total sum of the array
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num; // Add each element to totalSum
        }

        // Step 2: Initialize leftSum to track the sum of elements to the left of the current index
        int leftSum = 0;

        // Step 3: Iterate through the array to check for the middle index
        for (int i = 0; i < nums.length; i++) {
            // Check if the left sum equals the right sum
            // Right sum is derived as totalSum - leftSum - nums[i]
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i; // Found the middle index, return it
            }
            // Update leftSum by adding the current element
            leftSum += nums[i];
        }

        // Step 4: If no middle index is found, return -1
        return -1;
    }

    static int findMiddleIndexSolutionThree(int[] nums) {

        // Calculate the sum of the array
        int rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }

        int leftSum = 0;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {

            // Update the right sum
            rightSum -= nums[i];

            // Check if the left sum is equal to the right sum
            if (leftSum == rightSum) {
                return i;
            }

            // Update the left sum
            leftSum += nums[i];
        }

        // Return -1 if no pivot index is found
        return -1;
    }
}
