package com.manindra.hackerrank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EqualizeArray {

    public static void main(String[] args) {
        List<Integer> arr = List.of(3, 3, 2, 1, 3);
        System.out.println("Minimum deletions: " + equalizeArray(arr));
        System.out.println("Minimum deletions: " + equalizeArray2(arr));
    }

    public static int equalizeArray(List<Integer> arr) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxFrequency = 0;
        for (int freq : frequencyMap.values()) {
            maxFrequency = Math.max(maxFrequency, freq);
        }

        return arr.size() - maxFrequency;
    }

    public static int equalizeArray2(List<Integer> arr) {
        Map<Integer, Long> frequencyMap = arr.stream()
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        long maxFrequency = frequencyMap.values().stream()
                .mapToLong(freq -> freq)
                .max()
                .orElse(0);

        return arr.size() - (int) maxFrequency;
    }

}
