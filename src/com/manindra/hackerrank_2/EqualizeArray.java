package com.manindra.hackerrank_2;

import java.util.*;
import java.util.stream.Collectors;

public class EqualizeArray {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(3, 3, 2, 1, 3);
        System.out.println(equalizeArray(arr)); // Output: 2
    }

    public static int equalizeArray(List<Integer> arr) {
        // Step 1: Count frequency of each element
        Map<Integer, Long> frequencyMap = arr.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        // Step 2: Find the max frequency
        long maxFrequency = Collections.max(frequencyMap.values());

        // Step 3: Compute deletions
        return arr.size() - (int) maxFrequency;
    }

    public static int equalizeArray2(List<Integer> arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Count occurrences of each number
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Find max frequency
        int maxFrequency = 0;
        for (int freq : frequencyMap.values()) {
            maxFrequency = Math.max(maxFrequency, freq);
        }

        // Minimum deletions required
        return arr.size() - maxFrequency;
    }

    public static int equalizeArray3(List<Integer> arr) {
        // 3 3 2 1 3

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            hm.put(arr.get(i), hm.getOrDefault(arr.get(i), 0) + 1);
        }

        // find the highest frequency
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> e : hm.entrySet()) {
            int value = e.getValue();
            if (value > max) {
                max = value;
            }
        }

        // arr size - max
        return arr.size() - max;
    }
}

