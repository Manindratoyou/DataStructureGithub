package com.manindra.array_leetcode1;

import java.util.Arrays;

public class Solution561 { //Array Partition

    /*
    Input: nums = [1,4,3,2]
Output: 4
Explanation: All possible pairings (ignoring the ordering of elements) are:
1. (1, 4), (2, 3) -> min(1, 4) + min(2, 3) = 1 + 2 = 3
2. (1, 3), (2, 4) -> min(1, 3) + min(2, 4) = 1 + 2 = 3
3. (1, 2), (3, 4) -> min(1, 2) + min(3, 4) = 1 + 3 = 4
So the maximum possible sum is 4.
     */

    public static void main(String[] args) { //Array Partition

        int[] nums = {1, 4, 3, 2};
        System.out.println(arrayPairSum(nums)); // Output: 4


        // Example 1
        int[] nums1 = {1, 1, 2, 2, 3, 3};
        System.out.println(arrayPairSum(nums1));

        // Example 2
        int[] nums2 = {5, 5, 10, 10, 15, 15, 20, 20};
        System.out.println(arrayPairSum(nums2));

        // Example 3
        int[] nums3 = {3, 1, 4, 1, 5, 9, 2, 6};
        System.out.println(arrayPairSum(nums3));

        // Example 4
        int[] nums4 = {0, 0, 0, 0, 0, 0};
        System.out.println(arrayPairSum(nums4));

    }

    static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;

        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }

}
