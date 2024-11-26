package com.manindra.leetcodemedium_2;

import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique { //solution 945

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 1, 2, 1, 7};
        System.out.println(minIncrementForUnique(nums1)); // Output: 6

        int[] nums2 = {1, 2, 2};
        System.out.println(minIncrementForUnique(nums2)); // Output: 1

        int[] nums3 = {0};
        System.out.println(minIncrementForUnique(nums3)); // Output: 0

        int[] nums4 = {3, 3, 3};
        System.out.println(minIncrementForUnique(nums4)); // Output: 3
    }

    static int minIncrementForUnique(int[] nums) {

        Arrays.sort(nums);

        int moves = 0;

        // Iterate through the array
        for (int i = 1; i < nums.length; i++) {

            // If the current element is
            // less than or equal to the previous element
            if (nums[i] <= nums[i - 1]) {

                // Increment the moves by the difference
                moves += nums[i - 1] - nums[i] + 1;
                nums[i] = nums[i - 1] + 1;
            }
        }

        return moves;
    }
}
