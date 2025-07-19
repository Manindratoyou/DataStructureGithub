package com.manindra.array_leetcode2;

import java.util.HashMap;
import java.util.Map;

public class SubarrayDivisibleByK { //solution 974

    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;

        System.out.println(subarraysDivByK(nums, k)); // Output: 7
    }

    public static int subarraysDivByK(int[] nums, int k) {
        int res = 0;
        int curr = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initialize remainder 0 count

        for (int num : nums) {
            curr += num;
            int mod = curr % k;

            // Handle negative mods (Java behavior)
            if (mod < 0) mod += k;

            res += map.getOrDefault(mod, 0);
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }

        return res;
    }

}
