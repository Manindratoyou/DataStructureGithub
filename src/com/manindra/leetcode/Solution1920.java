package com.manindra.leetcode;

import java.util.Arrays;

/*
Input: nums = [0,2,1,5,3,4]
Output: [0,1,2,4,5,3]
Explanation: The array ans is built as follows:
ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
    = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
    = [0,1,2,4,5,3]
 */
public class Solution1920 { //Build Array from Permutation

    public static void main(String[] args) {
        int [] arr={0,2,1,5,3,4};
        //System.out.println(Arrays.toString(buildArraySolutionOne(arr)));
        System.out.println(Arrays.toString(buildArraySolutionTwo(arr)));
    }

    static int[] buildArraySolutionOne(int[] nums) {
        int [] result=new int[nums.length];

        for (int i=0;i< nums.length;i++){
            result[i]=nums[nums[i]];
        }

        return result;

    }

    static int[] buildArraySolutionTwo(int[] nums) {
        int CONST = 1001;

        for(int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int b = nums[a]%CONST;
            nums[i] = a + b*CONST;
        }

        for(int i = 0; i < nums.length; i++) {
            nums[i] /= CONST;
        }

        return nums;

    }

    public static int[] buildArray(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[i] += (nums[nums[i]] % n) * n;
        }

        for (int i = 0; i < n; i++) {
            nums[i] /= n;
        }

        return nums;
    }

}
