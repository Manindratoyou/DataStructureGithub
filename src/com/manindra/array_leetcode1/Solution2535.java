package com.manindra.array_leetcode1;

import java.util.Arrays;

/*
Input: nums = [1,15,6,3]
Output: 9
Explanation:
The element sum of nums is 1 + 15 + 6 + 3 = 25.
The digit sum of nums is 1 + 1 + 5 + 6 + 3 = 16.
The absolute difference between the element sum and digit sum is |25 - 16| = 9.
 */
public class Solution2535 { //Difference Between Element Sum and Digit Sum of an Array

    public static void main(String[] args) {
        int[] arr = {1, 15, 6, 3};
        System.out.println(differenceOfSumSolutionOne(arr));
        System.out.println(differenceOfSumSolutionTwo(arr));
    }

    static int differenceOfSumSolutionOne(int[] nums) {
        int elementSum = Arrays.stream(nums).sum();
        int digitSum = 0;
        for (int a : nums) {
            while (a != 0) {
                int temp = a % 10;
                a = a / 10;
                digitSum = digitSum + temp;
            }
        }
        return Math.abs(elementSum - digitSum);
    }

    static int differenceOfSumSolutionTwo(int[] nums) {
        int sum = 0;
        int dsum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            dsum += digitSum(nums[i]);
        }
        return Math.abs(sum - dsum);
    }

    static int digitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum;
    }
}
