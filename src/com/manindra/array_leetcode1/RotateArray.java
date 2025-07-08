package com.manindra.array_leetcode1;

public class RotateArray { //solution 189

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;

        rotate(nums, k);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // In case k > n

        reverse(nums, 0, n - 1);         // Step 1
        reverse(nums, 0, k - 1);         // Step 2
        reverse(nums, k, n - 1);         // Step 3
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

    public static void rotate2(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];
        k = k % n;

        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }

        // Copy back to original array
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }


}

