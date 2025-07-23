package com.manindra.array_leetcode2;

public class CheckSortedAndRotated { //solution 1752

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 1, 2};
        int[] nums2 = {2, 1, 3, 4};
        int[] nums3 = {1, 2, 3};

        System.out.println(check(nums1)); // true
        System.out.println(check(nums2)); // false
        System.out.println(check(nums3)); // true
    }

    public static boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }

        return count <= 1;
    }
}

