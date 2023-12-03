package com.manindra.leetcodeMedium;

public class Solution152 {

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 4, 5};
        System.out.println(maxProduct(nums1)); // Expected output: 120
        int[] nums2 = {2, -3, 4, -2, 5};
        System.out.println(maxProduct(nums2)); // Expected output: 240
        int[] nums3 = {-2, -3, -4, -5};
        System.out.println(maxProduct(nums3)); // Expected output: 120
        int[] nums4 = {6};
        System.out.println(maxProduct(nums4)); // Expected output: 6

    }

    static int maxProduct(int[] nums) {
        int n = nums.length;
        int result = nums[0];
        int maxEnding = nums[0];
        int minEnding = nums[0]; // Add a variable to keep track of the minimum product

        for (int i = 1; i < n; i++) {
            if (nums[i] < 0) {
                // Swap maxEnding and minEnding when encountering a negative number
                int temp = maxEnding;
                maxEnding = minEnding;
                minEnding = temp;
            }

            maxEnding = Math.max(maxEnding * nums[i], nums[i]);
            minEnding = Math.min(minEnding * nums[i], nums[i]);

            result = Math.max(result, maxEnding);
        }
        return result;
    }
}
