package com.manindra.hashing_leetcode;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysSum { //solution 930

    public static void main(String[] args) {

        int [] nums = {1,0,1,0,1} ;int  goal = 2;
        //System.out.println(numSubarraysWithSum(nums,goal));
        System.out.println(subarraySum2(nums,goal));
    }

    static int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0; // Initialize result (count of subarrays)
        int ps = 0;  // Initialize prefix sum

        // Map to store the frequency of prefix sums.
        // Key: prefix sum, Value: frequency of that prefix sum
        Map<Integer, Integer> map = new HashMap<>();

        // Initialize the map with a prefix sum of 0 occurring once.
        // This handles cases where a subarray starting from the beginning
        // itself sums up to the 'goal'.
        map.put(0, 1);

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            ps += nums[i]; // Update the current prefix sum

            // Check if (ps - goal) exists in the map.
            // If it does, it means there's a previous prefix sum 'x' such that
            // ps - x = goal, which implies a subarray exists from 'x' to 'ps'
            // with a sum equal to 'goal'.
            res += map.getOrDefault(ps - goal, 0);

            // Add the current prefix sum to the map or increment its frequency
            map.put(ps, map.getOrDefault(ps, 0) + 1);
        }

        return res; // Return the total count of subarrays with the given sum
    }
    public static int subarraySum2(int[] nums, int goal) { //copy paste from solution 560

        int res = 0;
        int curr = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            curr += num;
            res += map.getOrDefault(curr - goal, 0);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        return res;
    }
}
