package com.manindra.dynamicprogramming_leetcode;

import java.util.HashMap;
import java.util.Map;

public class TargetSum { //solution 494

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;

        int result = findTargetSumWays(nums, target);
        System.out.println("Number of ways to reach target: " + result);
    }

    static int findTargetSumWays(int[] nums, int target) {

        // Base case: we start with the sum 0 and one way to achieve it.
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);

        for (int num : nums) {
            // Temporary map to store new dp states for the current iteration
            Map<Integer, Integer> nextDp = new HashMap<>();

            // For every possible sum in dp, add and subtract the current number
            for (int sum : dp.keySet()) {
                int count = dp.get(sum);

                // Add current number to sum
                nextDp.put(sum + num, nextDp.getOrDefault(sum + num, 0) + count);

                // Subtract current number from sum
                nextDp.put(sum - num, nextDp.getOrDefault(sum - num, 0) + count);
            }
            // Move to the next iteration by updating dp with the new states
            dp = nextDp;
        }

        return dp.getOrDefault(target, 0);
    }
}
