package com.manindra.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution268 { //missing number

    public static void main(String[] args) {
        // Example Input:
        int[] nums = {3, 0, 1};

        // Calculate and print the missing number
        //int result = missingNumber(nums);
        int result = missingNumberSolutionTwo(nums);
        System.out.println("Missing number: " + result);
    }

    public static int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int i = 0; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return -1; // Default return if no missing number is found (not expected in a valid input)
    }

    public static int missingNumberSolutionTwo(int[] nums) {
        int expectedSum = nums.length * (nums.length + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }
}
