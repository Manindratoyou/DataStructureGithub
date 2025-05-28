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

    public static int maxProduct2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxProduct = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = currMax;

            currMax = Math.max(nums[i], Math.max(currMax * nums[i], currMin * nums[i]));
            currMin = Math.min(nums[i], Math.min(temp * nums[i], currMin * nums[i]));

            maxProduct = Math.max(maxProduct, currMax);
        }

        return maxProduct;
    }

    public int maxProduct3(int[] nums) {
        { //some test case are failing [-2,3,-4] op 3 expected 24
            int n = nums.length;
            int result = nums[0];
            int maxEnding = nums[0];
            for (int i = 1; i < n; i++) {
                maxEnding = Math.max(maxEnding * nums[i], nums[i]);
                result = Math.max(result, maxEnding);
            }
            return result;
        }
    }

    public static int maxProductBruteForce(int[] nums) { //{2, 3, -2, 4};
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }

        return maxProduct;
    }
}
