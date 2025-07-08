package com.manindra.array_leetcode1;

import java.util.Arrays;

public class MaximumProductThreeNumber { //solution 628

    public static void main(String[] args) {

        int[] nums = {2, 1, 3, 1, 5};
        System.out.println(maximumProductThreeNumber(nums));
    }

    static int maximumProductThreeNumber(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        //Three positive Integers
        int option1 = nums[n - 1] * nums[n - 2] * nums[n - 3];

        //Two smallest negative number and largest positive integer
        int option2 = nums[0] * nums[1] * nums[n - 1];

        //return the maximum of two options
        return Math.max(option1, option2);

    }
}
