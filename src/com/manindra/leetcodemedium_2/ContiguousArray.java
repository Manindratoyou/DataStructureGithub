package com.manindra.leetcodemedium_2;

import java.util.*;

public class ContiguousArray { //solution 525

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {0, 1};
        System.out.println("Max Length: " + findMaxLength(nums1)); // Output: 2

        // Test Case 2
        int[] nums2 = {0, 1, 0};
        System.out.println("Max Length: " + findMaxLength(nums2)); // Output: 2

        // Test Case 3
        int[] nums3 = {0, 0, 1, 0, 0, 0, 1, 1};
        System.out.println("Max Length: " + findMaxLength(nums3)); // Output: 6

        // Test Case 4
        int[] nums4 = {1, 1, 1, 0, 0, 0};
        System.out.println("Max Length: " + findMaxLength(nums4)); // Output: 6

        // Test Case 5
        int[] nums5 = {0, 1, 1, 0, 1, 1, 1, 0};
        System.out.println("Max Length: " + findMaxLength(nums5)); // Output: 4
    }

    static int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Convert 0s to -1s so we can use prefix sum logic
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == 0) nums[i] = -1;

        int sum = 0;
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Sentinel value to handle sum = 0 from start

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum)) {
                int last = map.get(sum);
                maxLength = Math.max(maxLength, i - last);
            } else {
                map.put(sum, i);
            }
        }

        return maxLength;
    }

}

