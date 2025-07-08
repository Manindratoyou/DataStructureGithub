package com.manindra.array_leetcode1;

public class MedianOfSortedArrays { //Solution 4

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));  // Output: 2.0
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;

        while (i < nums1.length && j < nums2.length) {
            merged[k++] = (nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++];
        }
        while (i < nums1.length)
            merged[k++] = nums1[i++];
        while (j < nums2.length)
            merged[k++] = nums2[j++];

        int mid = merged.length / 2;
        if (merged.length % 2 == 0)
            return (merged[mid - 1] + merged[mid]) / 2.0;
        else
            return merged[mid];
    }

    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1); // Ensure nums1 is smaller
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            int i = (low + high) / 2;
            int j = (m + n + 1) / 2 - i;

            int left1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int right1 = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int left2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int right2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (left1 <= right2 && left2 <= right1) {
                if ((m + n) % 2 == 0) {
                    return ((double)Math.max(left1, left2) + Math.min(right1, right2)) / 2;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted");
    }



}

