package com.manindra.array_leetcode2;

import java.util.*;

public class DegreeOfArray { // solution 697

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1};
        System.out.println(findShortestSubArray(nums)); // Output: 2
    }

    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> firstIndex = new HashMap<>();
        Map<Integer, Integer> lastIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            freq.put(val, freq.getOrDefault(val, 0) + 1);
            if (!firstIndex.containsKey(val)) {
                firstIndex.put(val, i);
            }
            lastIndex.put(val, i); // always update last
        }

        int degree = Collections.max(freq.values());
        int minLen = nums.length;

        for (int num : freq.keySet()) {
            if (freq.get(num) == degree) {
                int len = lastIndex.get(num) - firstIndex.get(num) + 1;
                minLen = Math.min(minLen, len);
            }
        }

        return minLen;
    }
}

