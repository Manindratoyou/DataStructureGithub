package com.manindra.dynamicProgramming_ds;

import java.util.*;

public class VariationsOfLIS {

    public static void main(String[] args) {
        VariationsOfLIS lis = new VariationsOfLIS();

        int[] nums = {3, 2, 6, 4, 5, 1};
        System.out.println("Min deletions to sort: " + lis.minDeletionsToSort(nums));
        System.out.println("Max Sum Increasing Subsequence: " + lis.maxSumIncreasingSubsequence(nums));
        System.out.println("Longest Bitonic Subsequence: " + lis.longestBitonicSubsequence(nums));

        int[][] bridges = {{8, 1}, {1, 2}, {4, 3}, {3, 4}, {6, 5}, {2, 6}, {5, 7}, {7, 8}};
        System.out.println("Building Bridges: " + lis.buildingBridges(bridges));

        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};
        System.out.println("Longest Chain: " + lis.longestChain(pairs));
    }

    // 1. Minimum deletions to make an array sorted
    public int minDeletionsToSort(int[] nums) {
        return nums.length - lengthOfLIS(nums);
    }

    // 2. Maximum Sum Increasing Subsequence
    public int maxSumIncreasingSubsequence(int[] nums) {
        int[] dp = Arrays.copyOf(nums, nums.length);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                }
            }
        }
        return Arrays.stream(dp).max().orElse(0);
    }

    // 3. Maximum Length Bitonic Subsequence
    public int longestBitonicSubsequence(int[] nums) {
        int n = nums.length;
        int[] inc = new int[n];
        int[] dec = new int[n];
        Arrays.fill(inc, 1);
        Arrays.fill(dec, 1);

        // LIS from left
        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j])
                    inc[i] = Math.max(inc[i], inc[j] + 1);

        // LDS from right
        for (int i = n - 2; i >= 0; i--)
            for (int j = n - 1; j > i; j--)
                if (nums[i] > nums[j])
                    dec[i] = Math.max(dec[i], dec[j] + 1);

        int max = 0;
        for (int i = 0; i < n; i++)
            max = Math.max(max, inc[i] + dec[i] - 1);

        return max;
    }

    // 4. Building Bridges
    public int buildingBridges(int[][] coordinates) {
        Arrays.sort(coordinates, Comparator.comparingInt(a -> a[0]));
        int[] arr = Arrays.stream(coordinates).mapToInt(a -> a[1]).toArray();
        return lengthOfLIS(arr);
    }

    // 5. The Longest Chain of Pairs
    public int longestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
        int count = 1, currEnd = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > currEnd) {
                count++;
                currEnd = pairs[i][1];
            }
        }
        return count;
    }

    // Helper: Longest Increasing Subsequence (LIS)
    public int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<>();
        for (int num : nums) {
            int idx = Collections.binarySearch(dp, num);
            if (idx < 0) idx = -idx - 1;
            if (idx == dp.size()) dp.add(num);
            else dp.set(idx, num);
        }
        return dp.size();
    }

    static int lengthOfLIS2(int[] arr) {
        int n = arr.length;
        int lis[] = new int[n];
        lis[0] = 1;
        for (int i = 1; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                //if (arr[i] > arr[j])
                if (arr[j] < arr[i])
                    lis[i] = Math.max(lis[i], lis[j] + 1);
            }
        }
        int result = lis[0];
        for (int i = 0; i < n; i++) {
            result = Math.max(lis[i], result);
        }
        return result;
    }

}

