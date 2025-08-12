package com.manindra.two_pointer_leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindKDistanceIndices { //solution 2200

    public static void main(String[] args) {
        System.out.println(findKDistantIndices(new int[]{3,4,9,1,3,9,5}, 9, 1));
        // Output: [1, 2, 3, 4, 5, 6]
    }

    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[j] == key && Math.abs(i - j) <= k) {
                    result.add(i);
                    break; // No need to check further
                }
            }
        }

        return result;
    }

    public static List<Integer> findKDistantIndices2(int[] nums, int key, int k) {
        int n = nums.length;
        boolean[] marked = new boolean[n];

        for (int j = 0; j < n; j++) {
            if (nums[j] == key) {
                int start = Math.max(0, j - k);
                int end = Math.min(n - 1, j + k);
                for (int i = start; i <= end; i++) {
                    marked[i] = true;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (marked[i]) result.add(i);
        }

        return result;
    }

    public static List<Integer> findKDistantIndices3(int[] nums, int key, int k) {
        List<Integer> keyIndices = IntStream.range(0, nums.length)
                .filter(i -> nums[i] == key)
                .boxed()
                .collect(Collectors.toList());

        return IntStream.range(0, nums.length)
                .filter(i -> keyIndices.stream().anyMatch(j -> Math.abs(i - j) <= k))
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<Integer> findKDistantIndices4(int[] nums, int key, int k) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        int i = 0; // pointer for result building
        for (int j = 0; j < n; j++) {
            if (nums[j] == key) {
                int start = Math.max(0, j - k);
                int end = Math.min(n - 1, j + k);

                // Move i to at least start
                if (i < start) {
                    i = start;
                }

                // Add indices until end
                while (i <= end) {
                    result.add(i);
                    i++;
                }
            }
        }
        return result;
    }

}

