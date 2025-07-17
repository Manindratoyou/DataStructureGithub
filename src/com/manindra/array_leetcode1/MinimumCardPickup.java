package com.manindra.array_leetcode1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumCardPickup { //solution 2260

    public static void main(String[] args) { //minimum sub array having duplicates element
        MinimumCardPickup solution = new MinimumCardPickup();

        //System.out.println("Test 1: " + solution.minimumCardPickup(new int[]{3, 4, 2, 3, 4, 7}));  // Output: 4
        System.out.println("Test 1: " + solution.minimumCardPickup2(new int[]{3, 4, 2, 3, 4, 7}));  // Output: 4
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

    public int minimumCardPickup2(int[] cards) { //Pure Sliding Window Solution with Set
        Set<Integer> set = new HashSet<>();
        int left = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < cards.length; right++) {
            // Shrink window until no duplicate
            while (set.contains(cards[right])) {
                // Update answer before removing duplicate
                minLen = Math.min(minLen, right - left + 1);
                set.remove(cards[left]);
                left++;
            }
            set.add(cards[right]);
        }

        return (minLen == Integer.MAX_VALUE) ? -1 : minLen;
    }

    public static int minimumCardPickup3(int[] cards) { //Using HashMap + Sliding Window Concept
        Map<Integer, Integer> map = new HashMap<>();
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < cards.length; right++) {
            int card = cards[right];
            if (map.containsKey(card)) {
                int left = map.get(card);
                minLen = Math.min(minLen, right - left + 1);
            }
            map.put(card, right); // update with the latest index
        }

        return (minLen == Integer.MAX_VALUE) ? -1 : minLen;
    }

}
