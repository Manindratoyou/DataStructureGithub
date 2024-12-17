package com.manindra.hackerrank;

import java.util.*;

public class MigratoryBirds {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 1, 2, 2, 3);
        List<Integer> arr1 = Arrays.asList(1, 4, 4, 4, 5, 3);
        List<Integer> arr2 = Arrays.asList(10, 20, 20, 10, 30, 10, 30, 30, 20);
        System.out.println(migratoryBirds(arr)); // Output: 1
        System.out.println(migratoryBirds(arr1)); // Output: 4
    }

    public static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Integer> birdCount = new HashMap<>();

        // Count the frequency of each bird type
        for (int bird : arr) {
            birdCount.put(bird, birdCount.getOrDefault(bird, 0) + 1);
        }

        // Find the bird type with the highest frequency and smallest ID
        int maxCount = 0;
        int result = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : birdCount.entrySet()) {
            int bird = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount || (count == maxCount && bird < result)) {
                maxCount = count;
                result = bird;
            }
        }

        return result;
    }
}

