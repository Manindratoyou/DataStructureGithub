package com.manindra.hashing_leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ArithmeticTriplets {

    public static void main(String[] args) {
        int[] nums = {0, 1, 4, 6, 7, 10};
        int diff = 3;
        System.out.println("Brute Force Count: " + countTripletsBruteForce(nums, diff)); // Output: 2
        System.out.println(" Count: " + countTripletsOptimized(nums, diff)); // Output: 2
    }

    public static int countTripletsBruteForce(int[] nums, int diff) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                if (nums[j] - nums[i] == diff) {
                    for (int k = j + 1; k < n; k++) {
                        if (nums[k] - nums[j] == diff) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
    public static int countTripletsOptimized(int[] nums, int diff) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int count = 0;
        for (int num : nums) {
            if (set.contains(num - diff) && set.contains(num + diff)) {
                count++;
            }
        }

        return count;
    }

    public static int countTripletsJava8(int[] nums, int diff) {
        Set<Integer> numSet = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());

        return (int) Arrays.stream(nums)
                .filter(num -> numSet.contains(num - diff) && numSet.contains(num + diff))
                .count();
    }
}

