package com.manindra.array_leetcode2;

import java.util.stream.IntStream;

public class MonotonicArray { //solution 896

    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{1, 2, 2, 3})); // true
        System.out.println(isMonotonic(new int[]{6, 5, 4, 4})); // true
        System.out.println(isMonotonic(new int[]{1, 3, 2}));    // false
    }

    public static boolean isMonotonic(int[] nums) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                decreasing = false;
            }
            if (nums[i] < nums[i - 1]) {
                increasing = false;
            }
        }

        return increasing || decreasing;
    }

    public static boolean isMonotonic2(int[] nums) {
        boolean increasing = IntStream.range(1, nums.length)
                .allMatch(i -> nums[i] >= nums[i - 1]);

        boolean decreasing = IntStream.range(1, nums.length)
                .allMatch(i -> nums[i] <= nums[i - 1]);

        return increasing || decreasing;
    }

}

