package com.manindra.iitp.lab5101;

import java.util.*;

public class CircularArrayRotation {

    public static void main(String[] args) {
        // Test case 1: Basic test
        List<Integer> a1 = Arrays.asList(38, 27, 43, 3, 9);
        int k1 = 2;
        List<Integer> queries1 = Arrays.asList(0, 1, 2);
        System.out.println("Test case 1 result: " + circularArrayRotation(a1, k1, queries1));

        // Test case 2: No rotation
        List<Integer> a2 = Arrays.asList(1, 2, 3, 4, 5);
        int k2 = 0;
        List<Integer> queries2 = Arrays.asList(1, 3, 4);
        System.out.println("Test case 2 result: " + circularArrayRotation(a2, k2, queries2));

        // Test case 3: Full rotation
        List<Integer> a3 = Arrays.asList(10, 20, 30, 40, 50);
        int k3 = 5;  // Full rotation
        List<Integer> queries3 = Arrays.asList(0, 2, 4);
        System.out.println("Test case 3 result: " + circularArrayRotation(a3, k3, queries3));

        // Test case 4: Rotation greater than array size
        List<Integer> a4 = Arrays.asList(7, 14, 21, 28, 35);
        int k4 = 7;  // Greater than array size
        List<Integer> queries4 = Arrays.asList(0, 1, 4);
        System.out.println("Test case 4 result: " + circularArrayRotation(a4, k4, queries4));

        // Test case 5: Single element array
        List<Integer> a5 = Arrays.asList(100);
        int k5 = 10;  // Multiple rotations on a single-element array
        List<Integer> queries5 = Arrays.asList(0);
        System.out.println("Test case 5 result: " + circularArrayRotation(a5, k5, queries5));
    }

    // Function to perform circular array rotation
    public static List<Integer> circularArrayRotation(List<Integer> a, int k, List<Integer> queries) {
        int n = a.size();
        List<Integer> result = new ArrayList<>();

        // Normalize k to avoid unnecessary full rotations
        k = k % n;

        for (int query : queries) {
            // Calculate the original index in the unrotated array
            int originalIndex = (query - k + n) % n;
            result.add(a.get(originalIndex));
        }

        return result;
    }
}
