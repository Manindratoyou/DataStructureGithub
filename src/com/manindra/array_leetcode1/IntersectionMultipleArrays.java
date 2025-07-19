package com.manindra.array_leetcode1;

import java.util.*;

import java.util.stream.Collectors;

public class IntersectionMultipleArrays { //solution 2248

    public static void main(String[] args) {
        int[][] nums1 = {{3, 1, 2, 4, 5}, {1, 2, 3, 5}, {1, 2, 3}};
        System.out.println("Intersection: " + intersection(nums1)); // [1, 2, 3]

        int[][] nums2 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println("Intersection: " + intersection(nums2)); // []

        int[][] nums3 = {{7, 7, 7}, {7, 7}, {7}};
        System.out.println("Intersection: " + intersection(nums3)); // [7]
    }

    static List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] arr : nums) {
            // Use a set to avoid double counting duplicates in the same sub-array
            Set<Integer> unique = new HashSet<>();
            for (int i : arr) {
                unique.add(i);
            }
            for (int i : unique) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        return map.keySet().stream()
                .filter(x -> map.get(x) == nums.length)
                .sorted()
                .collect(Collectors.toList());
    }

    static List<Integer> intersection2(int[][] nums) {
        int[] freq = new int[1001]; // As per constraint: 1 <= num <= 1000

        for (int[] arr : nums) {
            for (int num : arr) {
                freq[num]++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            if (freq[i] == nums.length) {
                result.add(i);
            }
        }

        return result;
    }

    static List<Integer> intersection3(int[][] nums) {

        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] arr : nums) {
            for (int i : arr) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        return map.keySet().stream().filter(s -> map.get(s) == n).sorted().collect(Collectors.toList());
    }

}


