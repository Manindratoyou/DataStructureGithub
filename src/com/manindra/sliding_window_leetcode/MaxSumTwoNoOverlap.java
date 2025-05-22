package com.manindra.sliding_window_leetcode;

public class MaxSumTwoNoOverlap { //solution 1031

    public static void main(String[] args) {
        int[] nums1 = {0, 6, 5, 2, 2, 5, 1, 9, 4};
        int firstLen1 = 1, secondLen1 = 2;
        System.out.println("Max sum: " + maxSumTwoNoOverlap(nums1, firstLen1, secondLen1)); // 20

        int[] nums2 = {3, 8, 1, 3, 2, 1, 8, 9, 0};
        int firstLen2 = 3, secondLen2 = 2;
        System.out.println("Max sum: " + maxSumTwoNoOverlap(nums2, firstLen2, secondLen2)); // 29

        int[] nums3 = {2, 1, 5, 6, 0, 9, 5, 0, 3, 8};
        int firstLen3 = 4, secondLen3 = 3;
        System.out.println("Max sum: " + maxSumTwoNoOverlap(nums3, firstLen3, secondLen3)); // 31
    }

    public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(
                maxSum(nums, firstLen, secondLen),
                maxSum(nums, secondLen, firstLen)
        );
    }

    private static int maxSum(int[] nums, int L, int M) {
        int n = nums.length;

        // Prefix sum
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int maxL = 0;
        int res = 0;

        for (int i = L + M; i <= n; i++) {
            maxL = Math.max(maxL, prefix[i - M] - prefix[i - M - L]);  // Best L before M
            int sumM = prefix[i] - prefix[i - M];                      // Current M
            res = Math.max(res, maxL + sumM);
        }

        return res;
    }
}

