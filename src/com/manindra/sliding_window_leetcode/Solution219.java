package com.manindra.sliding_window_leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution219 {// ContainsDuplicatesII

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(containsNearByDuplicates(nums, k));
        System.out.println(containsNearbyDuplicate2(nums, k));
    }

    static boolean containsNearByDuplicates(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k)
                return true;

            map.put(nums[i], i);
        }
        return false;
    }

    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }
}
