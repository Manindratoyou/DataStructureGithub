package com.manindra.array_leetcode2;

public class BinarySearch { //solution 704

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        System.out.println(search(nums, target)); // Output: 4
    }

    public static int search(int[] nums, int target) { //Binary Search – Iterative Approach
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // target not found
    }

    public static int searchRecursive(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private static int binarySearch(int[] nums, int left, int right, int target) {
        if (left > right) return -1;

        int mid = left + (right - left) / 2;

        if (nums[mid] == target)
            return mid;
        else if
        (nums[mid] < target)
            return binarySearch(nums, mid + 1, right, target);
        else
            return binarySearch(nums, left, mid - 1, target);
    }
}
