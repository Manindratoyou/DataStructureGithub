package com.manindra.leetcodeEasy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FindXorOfDuplicates { //solution 3158

    public static void main(String[] args) {
        System.out.println(duplicateNumbersXOR(new int[]{1, 2, 1, 3}));      // Output: 1
        System.out.println(duplicateNumbersXOR(new int[]{1, 2, 1, 3, 3, 4})); // Output: 2
        System.out.println(duplicateNumbersXOR(new int[]{4, 5, 6}));          // Output: 0
    }

    public static int duplicateNumbersXOR(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int xor = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 2) {
                xor ^= entry.getKey();
            }
        }

        return xor;
    }

    public static int duplicateNumbersXORStream(int[] nums) {
        Map<Integer, Long> freqMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        return freqMap.entrySet().stream()
                .filter(e -> e.getValue() == 2)
                .mapToInt(Map.Entry::getKey)
                .reduce(0, (a, b) -> a ^ b);
    }
}

