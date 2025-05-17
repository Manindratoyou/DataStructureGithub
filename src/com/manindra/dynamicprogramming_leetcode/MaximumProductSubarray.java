package com.manindra.dynamicprogramming_leetcode;

public class MaximumProductSubarray { //solution 152

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {2, 3, -2, 4};
        System.out.println("Maximum product of subarray: " + maxProduct(nums1)); // Expected output: 6

        int[] nums2 = {-2, 0, -1};
        System.out.println("Maximum product of subarray: " + maxProduct(nums2)); // Expected output: 0

        int[] nums3 = {-2, 3, -4};
        System.out.println("Maximum product of subarray: " + maxProduct(nums3)); // Expected output: 24
    }

    static int maxProduct(int[] nums) {
        int n = nums.length;
        int leftProduct = 1;
        int rightProduct = 1;
        int answer = nums[0];

        for (int i = 0; i < n; i++) {
            // If any left product or right product becomes 0, update it to 1
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            // Prefix product
            leftProduct *= nums[i];

            // Suffix product
            rightProduct *= nums[n - 1 - i];

            answer = Math.max(answer, Math.max(leftProduct, rightProduct));
        }
        return answer;
    }
}
