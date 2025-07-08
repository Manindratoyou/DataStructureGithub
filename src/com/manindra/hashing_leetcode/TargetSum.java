package com.manindra.hashing_leetcode;

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
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            // Temporary map to store new map states for the current iteration
            Map<Integer, Integer> nextDp = new HashMap<>();

            // For every possible sum in map, add and subtract the current number
            for (int sum : map.keySet()) {
                int count = map.get(sum);

                // Add current number to sum
                nextDp.put(sum + num, nextDp.getOrDefault(sum + num, 0) + count);

                // Subtract current number from sum
                nextDp.put(sum - num, nextDp.getOrDefault(sum - num, 0) + count);
            }
            // Move to the next iteration by updating map with the new states
            map = nextDp;
        }

        return map.getOrDefault(target, 0);
    }
}
