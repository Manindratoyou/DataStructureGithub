package com.manindra.hashing_leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DistributeCandies { //solution 575

    public static void main(String[] args) {
        System.out.println(distributeCandies(new int[]{1, 1, 2, 2, 3, 3})); // Output: 3
        System.out.println(distributeCandies(new int[]{1, 1, 2, 3}));       // Output: 2
        System.out.println(distributeCandies(new int[]{6, 6, 6, 6}));       // Output: 1
        System.out.println(distributeCandies(new int[]{1, 2, 3, 4, 5, 6})); // Output: 3
    }

    static int distributeCandies(int[] candyType) {
        Set<Integer> uniqueCandies = new HashSet<>();

        for (int candy : candyType) {
            uniqueCandies.add(candy);
        }

        // Max number of candies you can eat
        int maxCanEat = candyType.length / 2;

        // Return the minimum of max you can eat or number of unique types
        return Math.min(uniqueCandies.size(), maxCanEat);
    }

    static int distributeCandies2(int[] candyType) {
        // Count distinct candy types using streams
        long uniqueTypes = Arrays.stream(candyType)
                .boxed()
                .collect(Collectors.toSet())
                .size();

        int maxCanEat = candyType.length / 2;

        return (int) Math.min(uniqueTypes, maxCanEat);
    }
}

