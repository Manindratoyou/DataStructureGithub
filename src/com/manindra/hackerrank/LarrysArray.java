package com.manindra.hackerrank;

import java.util.List;

public class LarrysArray {

    public static void main(String[] args) {
        // Test cases
        System.out.println(larrysArray(List.of(1, 6, 5, 2, 4, 3))); // Output: NO
        System.out.println(larrysArray(List.of(3, 1, 2)));          // Output: YES
        System.out.println(larrysArray(List.of(1, 3, 4, 2)));       // Output: YES
    }

    public static String larrysArray(List<Integer> A) {
        int inversions = 0;

        // Count inversions in the List
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                if (A.get(i) > A.get(j)) {
                    inversions++;
                }
            }
        }

        // If inversions are even, return YES; otherwise, NO
        return inversions % 2 == 0 ? "YES" : "NO";
    }

}

