package com.manindra.leetcodemedium_2;

import java.util.*;

public class MaxSumDistinctSubarraysLengthK { //solution 2461

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
        int k = 3;
        System.out.println(maximumSubarraySum(nums, k));  // Output: 6
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> windowSet = new HashSet<>();
        long maxSum = 0, windowSum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            // Duplicate found, shrink window from left until nums[right] is unique
            while (windowSet.contains(nums[right])) {
                windowSet.remove(nums[left]);
                windowSum -= nums[left];
                left++;
            }

            // Add new number to the window
            windowSet.add(nums[right]);
            windowSum += nums[right];

            // Check if window size is exactly k
            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, windowSum);

                // Shrink window to prepare for next iteration
                windowSet.remove(nums[left]);
                windowSum -= nums[left];
                left++;
            }
        }

        return maxSum;
    }
}

