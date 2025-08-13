package com.manindra.array_leetcode2;

import java.util.Comparator;
import java.util.stream.IntStream;

public class LargestNumberTwiceOthers { //solution 747

    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{3, 6, 1, 0})); // 1
        System.out.println(dominantIndex(new int[]{1, 2, 3, 4})); // -1
        System.out.println(dominantIndex(new int[]{1}));           // 0
    }

    public static int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        int maxIndex = 0;
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        // Find max and second max
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
                maxIndex = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }

        return max >= 2 * secondMax ? maxIndex : -1;
    }

    public static int dominantIndex2(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return 0;

        int maxIndex = IntStream.range(0, nums.length)
                .boxed()
                .max(Comparator.comparingInt(i -> nums[i]))
                .get();

        int maxVal = nums[maxIndex];
        int secondMax = IntStream.range(0, nums.length)
                .filter(i -> i != maxIndex)
                .map(i -> nums[i])
                .max()
                .getAsInt();

        return maxVal >= 2 * secondMax ? maxIndex : -1;
    }
}

