package com.manindra.hashing_leetcode;

import java.util.*;

public class ArrayOfDoubledPairs { //solution 954

    public static void main(String[] args) {
        ArrayOfDoubledPairs solution = new ArrayOfDoubledPairs();
        int[] arr = {4, -2, 2, -4};
        System.out.println(solution.canReorderDoubled(arr)); // Output: true
    }

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> countMap = new TreeMap<>();

        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int x : countMap.keySet()) {
            if (countMap.get(x) == 0) continue;

            int want = (x < 0) ? x / 2 : 2 * x;

            // if x is negative, we must ensure it's even to have integer half
            if (x < 0 && x % 2 != 0) return false;

            if (countMap.getOrDefault(want, 0) < countMap.get(x)) return false;

            countMap.put(want, countMap.get(want) - countMap.get(x));
        }

        return true;
    }
}

