package com.manindra.sliding_window_leetcode;

import java.util.List;

public class MinimumPositiveSumSubarray { //solution 3364
    public static void main(String[] args) {
        MinimumPositiveSumSubarray solution = new MinimumPositiveSumSubarray();
        int[] nums = {3, -2, 1, 4};
        int l = 2, r = 3;
        int result = solution.minimumSumSubarray(nums, l, r);
        System.out.println("Minimum Positive Sum Subarray: " + result);
    }

    public int minimumSumSubarray(int[] nums, int l, int r) {
        int n = nums.length;
        int minSum = Integer.MAX_VALUE;

        for (int windowSize = l; windowSize <= r; windowSize++) {
            int windowSum = 0;
            // Calculate sum of the first window
            for (int i = 0; i < windowSize && i < n; i++) {
                windowSum += nums[i];
            }
            if (windowSum > 0) {
                minSum = Math.min(minSum, windowSum);
            }
            // Slide the window
            for (int i = windowSize; i < n; i++) {
                windowSum = windowSum - nums[i - windowSize] + nums[i];
                if (windowSum > 0) {
                    minSum = Math.min(minSum, windowSum);
                }
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }

    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int minSum = Integer.MAX_VALUE;

        for (int windowSize = l; windowSize <= r; windowSize++) {
            if (windowSize > n)
                break;

            int windowSum = 0;

            // Calculate sum of first window
            for (int i = 0; i < windowSize; i++) {
                windowSum += nums.get(i);
            }
            if (windowSum > 0) {
                minSum = Math.min(minSum, windowSum);
            }

            // Slide the window
            for (int i = windowSize; i < n; i++) {
                windowSum = windowSum - nums.get(i - windowSize) + nums.get(i);
                if (windowSum > 0) {
                    minSum = Math.min(minSum, windowSum);
                }
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }

}

