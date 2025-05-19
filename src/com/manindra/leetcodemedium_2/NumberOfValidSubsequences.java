package com.manindra.leetcodemedium_2;

import java.util.Arrays;

public class NumberOfValidSubsequences { //solution 1498
    private static final int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        int left = 0, right = n - 1, result = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + pow2[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        NumberOfValidSubsequences solver = new NumberOfValidSubsequences();
        System.out.println(solver.numSubseq(new int[]{3,5,6,7}, 9)); // Output: 4
        System.out.println(solver.numSubseq(new int[]{3,3,6,8}, 10)); // Output: 6
        System.out.println(solver.numSubseq(new int[]{2,3,3,4,6,7}, 12)); // Output: 61
    }
}

