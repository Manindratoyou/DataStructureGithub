package com.manindra.hashing_leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountPairsWithDifferenceK { //solution 2006

    // Main method to test both solutions
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int k1 = 1;

        int[] nums2 = {1, 3};
        int k2 = 3;

        int[] nums3 = {3, 2, 1, 5, 4};
        int k3 = 2;

        System.out.println("Brute Force Results:");
        System.out.println("Test 1: " + countKDifferenceBrute(nums1, k1)); // 4
        System.out.println("Test 2: " + countKDifferenceBrute(nums2, k2)); // 0
        System.out.println("Test 3: " + countKDifferenceBrute(nums3, k3)); // 3

        System.out.println("\nOptimized HashMap Results:");
        System.out.println("Test 1: " + countKDifferenceOptimized(nums1, k1)); // 4
        System.out.println("Test 2: " + countKDifferenceOptimized(nums2, k2)); // 0
        System.out.println("Test 3: " + countKDifferenceOptimized(nums3, k3)); // 3
    }

    // Brute Force Solution - O(n^2)
    public static int countKDifferenceBrute(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // Optimized HashMap Solution - O(n)
    public static int countKDifferenceOptimized(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            count += freq.getOrDefault(num - k, 0);
            count += freq.getOrDefault(num + k, 0);
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        return count;
    }

    public static int countKDifferenceOptimized2(int[] nums, int k) {
        int res = 0;
        int[] count = new int[101];
        for (int i : nums) {
            count[i]++;
        }
        for (int i = 0; i < 101 - k; i++) {
            res += count[i] * count[i + k];
        }

        return res;
    }

}

