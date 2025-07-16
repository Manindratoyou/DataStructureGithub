package com.manindra.sliding_window_leetcode;

public class SubarrayProductLessThanK { //solution 713

    public static void main(String[] args) {
        SubarrayProductLessThanK solution = new SubarrayProductLessThanK();

        // Test case 1
        int[] nums1 = {10, 5, 2, 6};
        int k1 = 100;
        System.out.println("Output: " + solution.numSubarrayProductLessThanK(nums1, k1)); // Expected: 8

        // Test case 2
        int[] nums2 = {1, 2, 3};
        int k2 = 0;
        System.out.println("Output: " + solution.numSubarrayProductLessThanK(nums2, k2)); // Expected: 0

        // Test case 3
        int[] nums3 = {1, 1, 1};
        int k3 = 2;
        System.out.println("Output: " + solution.numSubarrayProductLessThanK(nums3, k3)); // Expected: 6

        // Test case 4
        int[] nums4 = {100, 200};
        int k4 = 100;
        System.out.println("Output: " + solution.numSubarrayProductLessThanK(nums4, k4)); // Expected: 0
    }
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;

        int left = 0, count = 0;
        long product = 1;

        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            while (product >= k) {
                product /= nums[left];
                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }
}

