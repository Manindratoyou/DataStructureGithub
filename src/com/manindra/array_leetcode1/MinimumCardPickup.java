package com.manindra.array_leetcode1;

import java.util.HashMap;
import java.util.Map;

public class MinimumCardPickup { //solution 2260

    public static void main(String[] args) {
        MinimumCardPickup solution = new MinimumCardPickup();

        System.out.println("Test 1: " + solution.minimumCardPickup(new int[]{3, 4, 2, 3, 4, 7}));  // Output: 4
        System.out.println("Test 2: " + solution.minimumCardPickup(new int[]{1, 0, 5, 3}));      // Output: -1
        System.out.println("Test 3: " + solution.minimumCardPickup(new int[]{1, 2, 1, 2, 1, 2}));  // Output: 2
        System.out.println("Test 4: " + solution.minimumCardPickup(new int[]{1, 1}));          // Output: 2
    }

    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < cards.length; i++) {
            if (map.containsKey(cards[i])) {
                res = Math.min(res, i - map.get(cards[i]) + 1);
            }
            map.put(cards[i], i);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
