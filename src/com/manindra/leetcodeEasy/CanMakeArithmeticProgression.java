package com.manindra.leetcodeEasy;

import java.util.Arrays;

public class CanMakeArithmeticProgression { //solution 1502

    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {3, 5, 1};
        int[] arr2 = {1, 2, 4};
        int[] arr3 = {10, 12, 14, 16};

        System.out.println(canMakeArithmeticProgression(arr1)); // Expected: true
        System.out.println(canMakeArithmeticProgression(arr2)); // Expected: false
        System.out.println(canMakeArithmeticProgression(arr3)); // Expected: true
    }

    public static boolean canMakeArithmeticProgression(int[] arr) {
        // Sort the array
        Arrays.sort(arr);

        // Calculate the common difference
        int diff = arr[1] - arr[0];

        // Check if all consecutive elements have the same difference
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }

        return true;
    }
}

