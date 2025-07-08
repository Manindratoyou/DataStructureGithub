package com.manindra.array_leetcode1;

import java.util.HashMap;
import java.util.Map;

public class SingleNumberII { // Solution 137

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 3, 2})); // Output: 3
        System.out.println(singleNumber(new int[]{0,1,0,1,0,1,99})); // Output: 99
    }

    public static int singleNumber(int[] nums) {
        int result = 0;

        // Loop through 32 bits
        for (int i = 0; i < 32; i++) {
            int bitSum = 0;

            for (int num : nums) {
                // Check if the ith bit is set
                if (((num >> i) & 1) == 1) {
                    bitSum++;
                }
            }

            // If bitSum % 3 == 1, then the unique number has this bit set
            if (bitSum % 3 != 0) {
                result |= (1 << i);
            }
        }

        return result;
    }

    public static int singleNumberUsingMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }

        return -1;
    }
}

