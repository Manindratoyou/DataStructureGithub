package com.manindra.leetcodemedium_2;

import java.util.Arrays;

public class TwoSumII { //solution 167

    public static void main(String[] args) {
        // Test Cases
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9))); // [1,2]
        System.out.println(Arrays.toString(twoSum(new int[]{1, 3, 4, 5, 7, 10, 11}, 9))); // [3,4]
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 4, 9, 56, 90}, 8))); // [4,5]
        System.out.println(Arrays.toString(twoSum(new int[]{-3, 1, 2, 3, 8}, 5))); // [2,4]
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1}; // Return 1-based index
            } else if (sum < target) {
                left++;  // Increase sum
            } else {
                right--; // Decrease sum
            }
        }
        return new int[]{-1, -1}; // Should never be reached due to constraints
    }

    public static int[] twoSumBinarySearch(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            int index = binarySearch(numbers, i + 1, numbers.length - 1, complement);

            if (index != -1) {
                return new int[]{i + 1, index + 1}; // Return 1-based index
            }
        }
        return new int[]{-1, -1}; // Should never be reached
    }

    private static int binarySearch(int[] numbers, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (numbers[mid] == target) {
                return mid;
            } else if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
