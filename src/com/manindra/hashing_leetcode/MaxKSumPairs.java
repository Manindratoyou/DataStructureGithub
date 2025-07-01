package com.manindra.hashing_leetcode;

import java.util.*;

public class MaxKSumPairs { //solution 1679

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        int k1 = 5;

        int[] nums2 = {3, 1, 3, 4, 3};
        int k2 = 6;

        System.out.println("Using HashMap:");
        System.out.println("Test Case 1: " + maxOperationsUsingMap(nums1, k1)); // Output: 2
        System.out.println("Test Case 2: " + maxOperationsUsingMap(nums2, k2)); // Output: 1

        System.out.println("\nUsing Sorting + Two Pointers:");
        System.out.println("Test Case 1: " + maxOperationsUsingSorting(nums1.clone(), k1)); // Output: 2
        System.out.println("Test Case 2: " + maxOperationsUsingSorting(nums2.clone(), k2)); // Output: 1
    }

    public static int maxOperationsUsingMap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            int complement = k - num;
            if (map.getOrDefault(complement, 0) > 0) {
                count++;
                map.put(complement, map.get(complement) - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        return count;
    }

    public static int maxOperationsUsingSorting(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1, count = 0;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                count++;
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

}

