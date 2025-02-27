package com.manindra.interview_2;

import java.util.HashSet;
import java.util.Set;

public class UniqueSubstrings {

    public static void main(String[] args) {
        try {
            // Example Usage
            String input = "abracadabra";
            int k = 3;

            Set<String> uniqueSubstrings = findUniqueSubstrings(input, k);

            System.out.println("Unique Substrings of size " + k + ": " + uniqueSubstrings);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static Set<String> findUniqueSubstrings(String input, int k) {
        if (input == null || input.isEmpty() || k <= 0 || k > input.length()) {
            throw new IllegalArgumentException("Invalid input or substring size.");
        }

        Set<String> uniqueSubstrings = new HashSet<>();

        for (int i = 0; i <= input.length() - k; i++) {
            String substring = input.substring(i, i + k);
            if (!uniqueSubstrings.contains(substring)) {
                uniqueSubstrings.add(substring);
            }
        }

        return uniqueSubstrings;
    }

}

