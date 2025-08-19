package com.manindra.hashing_leetcode;

import java.util.*;
import java.util.stream.IntStream;

public class ContinuousSubarraySum { //solution 523

    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6)); // true
        System.out.println(checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 13)); // false
        System.out.println(checkSubarraySum(new int[]{0, 0}, 0)); // true
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1); // to handle case where subarray starts at index 0

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = k == 0 ? sum : sum % k;

            if (remainderMap.containsKey(remainder)) {
                if (i - remainderMap.get(remainder) > 1) {
                    return true;
                }
            } else {
                remainderMap.put(remainder, i);
            }
        }
        return false;
    }

    public static boolean checkSubarraySum2(int[] nums, int k) {
        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1);

        int[] sum = {0};
        return IntStream.range(0, nums.length).anyMatch(i -> {
            sum[0] += nums[i];
            int remainder = k == 0 ? sum[0] : sum[0] % k;

            if (remainderMap.containsKey(remainder)) {
                if (i - remainderMap.get(remainder) > 1) return true;
            } else {
                remainderMap.put(remainder, i);
            }
            return false;
        });
    }
}

