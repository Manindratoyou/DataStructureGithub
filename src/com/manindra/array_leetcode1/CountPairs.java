package com.manindra.array_leetcode1;

import java.util.Arrays;
import java.util.HashMap;
/*
Input: nums = [-1,1,2,3,1], target = 2
Output: 3
Explanation: There are 3 pairs of indices that satisfy the conditions in the statement:
- (0, 1) since 0 < 1 and nums[0] + nums[1] = 0 < target
- (0, 2) since 0 < 2 and nums[0] + nums[2] = 1 < target
- (0, 4) since 0 < 4 and nums[0] + nums[4] = 0 < target
Note that (0, 3) is not counted since nums[0] + nums[3] is not strictly less than the target.
 */
public class CountPairs { //solution 2824

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 5};
        int target = 6;
        System.out.println(countPairsTwoPointers(nums, target)); // Output: 3
        System.out.println(countPairsBruteForce(nums, target)); // Output: 3
    }

    public static int countPairsBruteForce(int[] nums, int target) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] < target) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int countPairsTwoPointers(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        int left = 0, right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] < target) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }

        return count;
    }

    public static int countPairsUsingHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            for (int key : map.keySet()) {
                if (key + num < target) {
                    count += map.get(key); // Count all occurrences of `key`
                }
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}

