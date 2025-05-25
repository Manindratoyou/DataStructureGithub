package com.manindra.sliding_window_leetcode;

import java.util.Arrays;

public class FrequencyOfMostFrequent { //solution 1838

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        long total = 0;
        int maxFreq = 0;

        for (int right = 0; right < nums.length; right++) {
            total += nums[right];

            // If cost to make all elements in window equal to nums[right] > k, shrink window
            while ((long) (right - left + 1) * nums[right] - total > k) {
                total -= nums[left];
                left++;
            }

            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }

    public static void main(String[] args) {
        System.out.println(maxFrequency(new int[]{1, 2, 4}, 5));      // Output: 3
        System.out.println(maxFrequency(new int[]{1, 4, 8, 13}, 5));  // Output: 2
        System.out.println(maxFrequency(new int[]{3, 9, 6}, 2));      // Output: 1
    }
}
