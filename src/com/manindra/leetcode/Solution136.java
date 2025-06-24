package com.manindra.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution136 { //Single Number

    public static void main(String[] args) {

        int[] arr = {2, 2, 1};
        int[] arr1 = {4, 1, 2, 1, 4};
        int[] arr2 = {3, 4, 9, 3, 7, 4, 8, 9, 8};
        System.out.println(singleNumber(arr));
        System.out.println(singleNumber(arr1));
        System.out.println(singleNumberSolutionTwo(arr));
        System.out.println(singleNumberSolutionThree(arr2));
    }

    static int singleNumber(int[] arr) {
        int result = 0;
        for (int num : arr)
            result ^= num;
        return result;
    }

    static int singleNumberSolutionTwo(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num))
                set.remove(num);
            else
                set.add(num);
        }
        return set.iterator().next();
    }

    static int singleNumberSolutionThree(int[] nums) {
        int sing = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sing = sing ^ nums[i];
        }
        return sing;

    }

}
