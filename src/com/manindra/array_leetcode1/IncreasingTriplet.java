package com.manindra.array_leetcode1;

public class IncreasingTriplet { //solution 334

    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{1, 2, 3, 4, 5})); // true
        System.out.println(increasingTriplet(new int[]{5, 4, 3, 2, 1})); // false
        System.out.println(increasingTriplet(new int[]{2, 1, 5, 0, 4, 6})); // true
    }

    public static boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;  // update smallest so far
            } else if (num <= second) {
                second = num; // update second smallest
            } else {
                // num > second means we found third element in triplet
                return true;
            }
        }

        return false;
    }
}

