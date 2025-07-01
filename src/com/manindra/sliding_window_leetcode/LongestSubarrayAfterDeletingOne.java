package com.manindra.sliding_window_leetcode;

public class LongestSubarrayAfterDeletingOne { //solution 1493


    public static void main(String[] args) {
        int[] nums1 = {1, 1, 0, 1};
        int[] nums2 = {0, 1, 1, 1, 0, 1, 1, 0, 1};
        int[] nums3 = {1, 1, 1};
        int[] nums4 = {1, 0, 0, 1, 1, 1, 0, 1};

        System.out.println(longestSubarray(nums1)); // 3
        System.out.println(longestSubarray(nums2)); // 5
        System.out.println(longestSubarray(nums3)); // 2 (must delete one)
        System.out.println(longestSubarray(nums4)); // 4
    }

    public static int longestSubarray(int[] nums) {
        int left = 0, right = 0;
        int zeroCount = 0;
        int maxLength = 0;

        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0)
                zeroCount++;

            while (zeroCount > 1) {
                if (nums[left] == 0)
                    zeroCount--;
                left++;
            }

            // Since we must delete one element, max length is right - left
            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }

}

