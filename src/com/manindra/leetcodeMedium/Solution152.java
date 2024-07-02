package com.manindra.leetcodeMedium;

public class Solution152 {

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 4, 5};
        System.out.println(maxProduct(nums1)); // Expected output: 120
        System.out.println(maxProduct2(nums1)); // Expected output: 120
        int[] nums2 = {2, -3, 4, -2, 5};
        System.out.println(maxProduct(nums2)); // Expected output: 240
        int[] nums3 = {-2, -3, -4, -5};
        System.out.println(maxProduct(nums3)); // Expected output: 120
        System.out.println(maxProduct2(nums3)); // Expected output: 120
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
    static int maxProduct2(int[] nums) {

        int n = nums.length;
        long leftProduct = 1;
        long rightProduct = 1;
        long ans = nums[0];

        for (int i = 0; i < n; i++) {

            //if any of leftProduct or rightProduct become 0 then update it to 1
            leftProduct = (leftProduct == 0 || leftProduct < Integer.MIN_VALUE) ? 1 : leftProduct;
            rightProduct = (rightProduct == 0 || rightProduct < Integer.MIN_VALUE) ? 1 : rightProduct;

            //prefix product
            leftProduct *= nums[i];

            //suffix product
            rightProduct *= nums[n - 1 - i];

            ans = Math.max(ans, Math.max(leftProduct, rightProduct));
        }

        return (int) ans;
    }

}
