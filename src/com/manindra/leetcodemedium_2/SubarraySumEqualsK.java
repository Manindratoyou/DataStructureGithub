package com.manindra.leetcodemedium_2;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK { //solution 560

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Count: " + subarraySum(nums1, k1)); // Output: 2

        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println("Count: " + subarraySum(nums2, k2)); // Output: 2

        int[] nums3 = {1, -1, 0};
        int k3 = 0;
        System.out.println("Count: " + subarraySum(nums3, k3)); // Output: 3

        int[] nums4 = {1, 0, 1, 2, 1, 0, 4, 1, 3};
        int k4 = 4;
        System.out.println("Count: " + subarraySum2(nums4, k4));
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // sum 0 occurs once initially

        int count = 0, sum = 0;

        for (int num : nums) {
            sum += num;

            if (prefixSumCount.containsKey(sum - k)) {
                count += prefixSumCount.get(sum - k);
            }

            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static int subarraySum2(int[] nums, int k) {

        int res = 0;
        int curr = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            curr += num;
            res += map.getOrDefault(curr - k, 0);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        return res;
    }


}
