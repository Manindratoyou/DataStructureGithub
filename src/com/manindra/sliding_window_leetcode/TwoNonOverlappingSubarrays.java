package com.manindra.sliding_window_leetcode;

import java.util.Arrays;

public class TwoNonOverlappingSubarrays { //solution 1477
    public static void main(String[] args) {
        TwoNonOverlappingSubarrays solution = new TwoNonOverlappingSubarrays();
        System.out.println(solution.minSumOfLengths(new int[]{3, 2, 2, 4, 3}, 3)); // 2
        System.out.println(solution.minSumOfLengths(new int[]{7, 3, 4, 7}, 7));   // 2
        System.out.println(solution.minSumOfLengths(new int[]{4, 3, 2, 6, 2, 3, 4}, 6)); // -1
        System.out.println(solution.minSumOfLengths(new int[]{1,1,1,2,2,2,4,4}, 6)); // 6
    }

    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] minLens = new int[n];
        Arrays.fill(minLens, Integer.MAX_VALUE);

        int left = 0, sum = 0, minLen = Integer.MAX_VALUE;

        // First pass: find all left subarrays with sum == target
        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left++];
            }

            if (sum == target) {
                int currLen = right - left + 1;
                minLen = Math.min(minLen, currLen);
                minLens[right] = currLen;
            }

            // Update prefix min
            if (right > 0) {
                minLens[right] = Math.min(minLens[right], minLens[right - 1]);
            }
        }

        // Second pass: look for right subarray with sum == target and combine with min left subarray
        int res = Integer.MAX_VALUE;
        left = 0;
        sum = 0;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left++];
            }

            if (sum == target) {
                int currLen = right - left + 1;
                if (left > 0 && minLens[left - 1] != Integer.MAX_VALUE) {
                    res = Math.min(res, currLen + minLens[left - 1]);
                }
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}

