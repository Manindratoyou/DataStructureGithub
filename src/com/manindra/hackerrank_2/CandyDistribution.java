package com.manindra.hackerrank_2;

import java.util.*;

public class CandyDistribution {

    public static long candies(int n, List<Integer> arr) {
        int[] candies = new int[n];
        Arrays.fill(candies, 1);  // Step 1: Give each child 1 candy

        // Left to right pass
        for (int i = 1; i < n; i++) {
            if (arr.get(i) > arr.get(i - 1)) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to left pass
        for (int i = n - 2; i >= 0; i--) {
            if (arr.get(i) > arr.get(i + 1)) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Sum all candies
        long totalCandies = 0;
        for (int c : candies) {
            totalCandies += c;
        }

        return totalCandies;
    }

    public static void main(String[] args) {
        List<Integer> ratings1 = Arrays.asList(1, 2, 2);
        System.out.println(candies(3, ratings1)); // Output: 4

        List<Integer> ratings2 = Arrays.asList(2, 4, 2, 6, 1, 7, 8, 9, 2, 1);
        System.out.println(candies(10, ratings2)); // Output: 19

        List<Integer> ratings3 = Arrays.asList(2, 4, 3, 5, 2, 6, 4, 5);
        System.out.println(candies(8, ratings3)); // Output: 12
    }
}

