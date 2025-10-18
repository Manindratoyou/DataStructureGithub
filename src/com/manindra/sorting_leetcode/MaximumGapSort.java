package com.manindra.sorting_leetcode;

import java.util.Arrays;

public class MaximumGapSort { //solution 164

    public static void main(String[] args) {
        int[] nums = {3, 6, 9, 1};
        System.out.println(maximumGap(nums)); // 3
    }

    //Approach 1: Sorting (Simple, but O(n log n))
    public static int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;

        Arrays.sort(nums);
        int maxGap = 0;

        for (int i = 1; i < nums.length; i++) {
            maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
        }

        return maxGap;
    }

    //Approach 2: Bucket Sort (Optimal O(n))
    public static int maximumGap2(int[] nums) {
        if (nums.length < 2) return 0;

        int n = nums.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        // Find min and max
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (min == max) return 0;

        // Bucket size and count
        int bucketSize = Math.max(1, (max - min) / (n - 1));
        int bucketCount = ((max - min) / bucketSize) + 1;

        int[] bucketMin = new int[bucketCount];
        int[] bucketMax = new int[bucketCount];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // Distribute numbers into buckets
        for (int num : nums) {
            int index = (num - min) / bucketSize;
            bucketMin[index] = Math.min(bucketMin[index], num);
            bucketMax[index] = Math.max(bucketMax[index], num);
        }

        // Compute max gap
        int prevMax = min, maxGap = 0;

        for (int i = 0; i < bucketCount; i++) {
            if (bucketMin[i] == Integer.MAX_VALUE) continue; // empty bucket

            maxGap = Math.max(maxGap, bucketMin[i] - prevMax);
            prevMax = bucketMax[i];
        }

        return maxGap;
    }

}

