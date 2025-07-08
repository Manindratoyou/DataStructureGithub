package com.manindra.array_leetcode1;

import java.util.Arrays;

public class SortArrayByParityII { //solution 922

    public static void main(String[] args) {
        int[] nums1 = {4, 2, 5, 7};
        int[] nums2 = {3, 1, 2, 4};

        System.out.println("Sorted Array 1 by parity: " + Arrays.toString(sortArrayByParityII(nums1)));
        System.out.println("Sorted Array 2 by parity: " + Arrays.toString(sortArrayByParityII(nums2)));
    }

    static int[] sortArrayByParityII(int[] nums) {

        int[] temp = new int[nums.length];
        int j = 0, k = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                temp[j] = nums[i];
                j += 2;
            } else {
                temp[k] = nums[i];
                k += 2;
            }
        }
        return temp;
    }
}
