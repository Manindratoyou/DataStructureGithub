package com.manindra.hashing_leetcode;

import java.util.*;

public class KDiffPairs { //solution 532

    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{3, 1, 4, 1, 5}, 2)); // 2
        System.out.println(findPairs(new int[]{1, 2, 3, 4, 5}, 1)); // 4
        System.out.println(findPairs(new int[]{1, 3, 1, 5, 4}, 0)); // 1
    }

    public static int findPairs(int[] nums, int k) {
        if (k < 0) return 0; // no negative diff possible

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int count = 0;

        for (int key : map.keySet()) {
            if (k == 0) {
                if (map.get(key) >= 2) count++;
            } else {
                if (map.containsKey(key + k)) count++;
            }
        }

        return count;
    }

}

