package com.manindra.array_leetcode1;

import java.util.HashSet;
import java.util.Set;

public class ArraySumProblem { //IMPORTANT

    public static void main(String[] args) {

        // Test case 1: Two Sum
        int[] nums1 = {2, 7, 11, 15};
        int[] result = twoSumProblem(nums1, 9);
        if (result != null)
            System.out.println("Two sum pair: " + result[0] + ", " + result[1]);
        else
            System.out.println("No pair found for two sum.");

        // Test case 2: Subarray with Zero Sum
        int[] nums2 = {4, 2, -3, 1, 6};
        System.out.println("Subarray with zero sum exists: " + subArrayWithZeroSum(nums2));

        // Test case 3: Subarray with Given Sum
        int[] nums3 = {10, 2, -2, -20, 10};
        int target = -10;
        System.out.println("Subarray with sum " + target + " exists: " + subArrayWithGivenSum(nums3, target));
    }

    static int[] twoSumProblem(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            int complement = target - num;
            if (set.contains(complement)) {
                return new int[]{complement, num};
            }
            set.add(num);
        }
        return null; // No pair found
    }

    static boolean subArrayWithZeroSum(int[] arr) { // O(n)
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int value : arr) {
            sum += value;
            if (sum == 0 || set.contains(sum)) {
                return true;
            }
            set.add(sum);
        }
        return false;
    }

    static boolean subArrayWithGivenSum(int[] arr, int targetSum) { // O(n)
        Set<Integer> set = new HashSet<>();
        int currentSum = 0;
        for (int value : arr) {
            currentSum += value;
            if (currentSum == targetSum || set.contains(currentSum - targetSum)) {
                return true;
            }
            set.add(currentSum);
        }
        return false;
    }
}
