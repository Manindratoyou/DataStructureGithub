package com.manindra.array_leetcode1;

public class FindMinimumInRotatedSortedArray { //solution 153

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 1, 2}; // Rotated at index 3, minimum is 1
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2}; // Rotated at index 4, minimum is 0
        int[] nums3 = {11, 13, 15, 17}; // Not rotated, minimum is 11

        System.out.println("Minimum in nums1: " + findMin(nums1)); // Output: 1
        System.out.println("Minimum in nums2: " + findMin(nums2)); // Output: 0
        System.out.println("Minimum in nums3: " + findMin(nums3)); // Output: 11
    }

    static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // Check if the middle element is greater
            // than the right element
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

}
