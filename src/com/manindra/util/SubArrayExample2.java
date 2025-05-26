package com.manindra.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArrayExample2 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -2, 5};

        // Subarrays with given sum
        findSubarraysWithGivenSumPositive(new int[]{1, 2, 3, 7, 5}, 12);
        findSubarraysWithGivenSum(arr, 6);

        // Longest/Shortest
        System.out.println("Longest subarray with sum 6: " + longestSubarrayWithSum(arr, 6));
        System.out.println("Shortest subarray with sum >= 8: " + shortestSubarrayWithSumAtLeast(new int[]{2, 3, 1, 2, 4, 3}, 8));

    }


    //1A. Given Sum (Positive Integers Only) – Sliding Window
    public static void findSubarraysWithGivenSumPositive(int[] arr, int target) {
        int start = 0, sum = 0;

        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];

            while (sum > target && start < end) {
                sum -= arr[start++];
            }

            if (sum == target) {
                System.out.print("Subarray with sum " + target + ": ");
                for (int i = start; i <= end; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
        }
    }

    //1B. Given Sum (Can include Negative Numbers) – HashMap
    public static void findSubarraysWithGivenSum(int[] arr, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        map.put(0, new ArrayList<>(List.of(-1)));

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - target)) {
                for (int start : map.get(sum - target)) {
                    System.out.print("Subarray with sum " + target + ": ");
                    for (int j = start + 1; j <= i; j++) {
                        System.out.print(arr[j] + " ");
                    }
                    System.out.println();
                }
            }
            map.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
    }

    // 2A. Longest Subarray with Given Sum (Handles Negatives)
    public static int longestSubarrayWithSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;
        map.put(0, -1);

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - target)) {
                maxLen = Math.max(maxLen, i - map.get(sum - target));
            }
            map.putIfAbsent(sum, i); // store first occurrence
        }

        return maxLen;
    }

    //2B. Shortest Subarray with Sum ≥ Target (Positive Only)
    public static int shortestSubarrayWithSumAtLeast(int[] arr, int target) {
        int minLen = Integer.MAX_VALUE;
        int start = 0, sum = 0;

        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];

            while (sum >= target) {
                minLen = Math.min(minLen, end - start + 1);
                sum -= arr[start++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }


}
