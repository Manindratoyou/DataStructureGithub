package com.manindra.leetcodeEasy;

import java.util.Arrays;

public class SortColors { //solution 75

    public static void main(String[] args) {
        // Test cases
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        int[] nums2 = {2, 0, 1};
        int[] nums3 = {0, 1, 2};
        int[] nums4 = {2, 1, 0};

        // Sorting the arrays
        sortColour(nums1);
        sortColour(nums2);
        sortColour(nums3);
        sortColour(nums4);

        // Printing the results
        System.out.println(Arrays.toString(nums1)); // Output: [0, 0, 1, 1, 2, 2]
        System.out.println(Arrays.toString(nums2)); // Output: [0, 1, 2]
        System.out.println(Arrays.toString(nums3)); // Output: [0, 1, 2]
        System.out.println(Arrays.toString(nums4)); // Output: [0, 1, 2]
    }

    static void sortColour(int[] nums) {
        int start = 0;
        int mid = 0;
        int end = nums.length - 1;
        while (mid <= end) {
            switch (nums[mid]) {
                case 0:
                    // Swap with start index
                    swap(nums, start, mid);
                    mid++;
                    start++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    // Swap with end index
                    swap(nums, mid, end);
                    end--;
                    break;
            }
        }
    }

    static void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
}

