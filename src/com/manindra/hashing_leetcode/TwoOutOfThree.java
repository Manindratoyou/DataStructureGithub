package com.manindra.hashing_leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoOutOfThree { //solution 2032

    public static void main(String[] args) {
        TwoOutOfThree solution = new TwoOutOfThree();

        // Test Case 1
        int[] nums1 = {1, 1, 3, 2};
        int[] nums2 = {2, 3};
        int[] nums3 = {3};
        System.out.println("Test Case 1: " + solution.twoOutOfThree(nums1, nums2, nums3)); // [2, 3]

        // Test Case 2
        int[] nums4 = {3, 1};
        int[] nums5 = {2, 3};
        int[] nums6 = {1, 2};
        System.out.println("Test Case 2: " + solution.twoOutOfThree(nums4, nums5, nums6)); // [1, 2, 3]

        // Test Case 3
        int[] nums7 = {1, 2, 2};
        int[] nums8 = {4, 3, 3};
        int[] nums9 = {5};
        System.out.println("Test Case 3: " + solution.twoOutOfThree(nums7, nums8, nums9)); // []

        // Test Case 4
        int[] nums10 = {5, 5, 5};
        int[] nums11 = {5};
        int[] nums12 = {5};
        System.out.println("Test Case 4: " + solution.twoOutOfThree(nums10, nums11, nums12)); // [5]
    }

    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        fillMap(map, nums1, 1);
        fillMap(map, nums2, 2);
        fillMap(map, nums3, 3);

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() >= 2) {
                result.add(entry.getKey());
            }
        }

        Collections.sort(result);
        return result;
    }

    private void fillMap(Map<Integer, Set<Integer>> map, int[] nums, int source) {
        for (int num : Arrays.stream(nums).distinct().toArray()) {
            map.computeIfAbsent(num, k -> new HashSet<>()).add(source);
        }
    }

    public List<Integer> twoOutOfThree2(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        IntStream.of(nums1).distinct().forEach(n -> map.computeIfAbsent(n, k -> new HashSet<>()).add(1));
        IntStream.of(nums2).distinct().forEach(n -> map.computeIfAbsent(n, k -> new HashSet<>()).add(2));
        IntStream.of(nums3).distinct().forEach(n -> map.computeIfAbsent(n, k -> new HashSet<>()).add(3));

        return map.entrySet().stream()
                .filter(e -> e.getValue().size() >= 2)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());
    }
}

