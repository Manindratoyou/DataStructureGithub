package com.manindra.hashing_leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountNiceSubarrays { //solution 1248

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2, 1, 1};
        int k1 = 3;
        System.out.println("Nice subarrays: " + numberOfSubarrays(nums1, k1)); // Output: 2

        int[] nums2 = {2, 4, 6};
        int k2 = 1;
        System.out.println("Nice subarrays: " + numberOfSubarrays(nums2, k2)); // Output: 0

        int[] nums3 = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        int k3 = 2;
        System.out.println("Nice subarrays: " + numberOfSubarrays(nums3, k3)); // Output: 16
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, 1); // base case

        int oddCount = 0, result = 0;

        for (int num : nums) {
            if (num % 2 != 0) oddCount++;

            result += countMap.getOrDefault(oddCount - k, 0);

            countMap.put(oddCount, countMap.getOrDefault(oddCount, 0) + 1);
        }

        return result;
    }
}

