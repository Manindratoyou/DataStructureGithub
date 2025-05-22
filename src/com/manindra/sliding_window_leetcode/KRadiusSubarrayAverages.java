package com.manindra.sliding_window_leetcode;

import java.util.Arrays;

public class KRadiusSubarrayAverages { //solution 2090

    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {7, 4, 3, 9, 1, 8, 5, 2, 6};
        int k1 = 3;
        System.out.println("Test 1: " + Arrays.toString(getAverages(nums1, k1)));
        // Expected: [-1, -1, -1, 5, 4, 4, -1, -1, -1]

        // Test case 2
        int[] nums2 = {100000};
        int k2 = 0;
        System.out.println("Test 2: " + Arrays.toString(getAverages(nums2, k2)));
        // Expected: [100000]

        // Test case 3
        int[] nums3 = {8};
        int k3 = 100000;
        System.out.println("Test 3: " + Arrays.toString(getAverages(nums3, k3)));
        // Expected: [-1]

        // Test case 4
        int[] nums4 = {1, 3, 2, 6, 4, 5, 8, 9};
        int k4 = 1;
        System.out.println("Test 4: " + Arrays.toString(getAverages(nums4, k4)));
        // Expected: [-1, 2, 3, 4, 5, 5, 7, -1]
    }

    public static int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);

        int windowSize = 2 * k + 1;
        if (windowSize > n) {
            return result;
        }

        long windowSum = 0;
        for (int i = 0; i < windowSize; i++) {
            windowSum += nums[i];
        }

        int centerIndex = k;
        result[centerIndex] = (int) (windowSum / windowSize);

        for (int i = windowSize; i < n; i++) {
            windowSum = windowSum - nums[i - windowSize] + nums[i];
            centerIndex++;
            result[centerIndex] = (int) (windowSum / windowSize);
        }

        return result;
    }

}

