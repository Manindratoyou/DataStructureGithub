package com.manindra.hackerrank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoCharacters {

    public static final int NUM_LETTERS = 26;

    public static void main(String[] args) {

        String str = "abaacdabd";
        int length = str.length();

        /* Edge case */
        if (length <= 1) {
            System.out.println(0);
            return;
        }

        /* Create arrays representing the 26^2 subproblems */
        int[][] pair = new int[NUM_LETTERS][NUM_LETTERS];
        int[][] count = new int[NUM_LETTERS][NUM_LETTERS];

        for (int i = 0; i < length; i++) {
            char letter = str.charAt(i);
            int letterNum = letter - 'a';

            /* Update row */
            for (int col = 0; col < NUM_LETTERS; col++) {
                if (pair[letterNum][col] == letter) {
                    count[letterNum][col] = -1;
                }
                if (count[letterNum][col] != -1) {
                    pair[letterNum][col] = letter;
                    count[letterNum][col]++;
                }
            }

            /* Update column */
            for (int row = 0; row < NUM_LETTERS; row++) {
                if (pair[row][letterNum] == letter) {
                    count[row][letterNum] = -1;
                }
                if (count[row][letterNum] != -1) {
                    pair[row][letterNum] = letter;
                    count[row][letterNum]++;
                }
            }
        }

        /* Find max in "count" array */
        int max = 0;
        for (int row = 0; row < NUM_LETTERS; row++) {
            for (int col = 0; col < NUM_LETTERS; col++) {
                max = Math.max(max, count[row][col]);
            }
        }
        System.out.println(max);
    }

    public static int findMaxLength(String s) {
        // Extract unique characters
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }

        // Convert to a list to generate pairs
        List<Character> charList = new ArrayList<>(uniqueChars);
        int maxLength = 0;

        // Iterate over all pairs of unique characters
        for (int i = 0; i < charList.size(); i++) {
            for (int j = i + 1; j < charList.size(); j++) {
                char first = charList.get(i);
                char second = charList.get(j);

                // Check if the filtered string with these two characters is valid
                String filteredString = filterString(s, first, second);
                if (isValidAlternate(filteredString)) {
                    maxLength = Math.max(maxLength, filteredString.length());
                }
            }
        }

        return maxLength;
    }

    // Filter the string to include only two characters
    private static String filterString(String s, char first, char second) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == first || c == second) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // Check if a string alternates between two characters
    private static boolean isValidAlternate(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                return false; // Consecutive characters are the same
            }
        }
        return true;
    }

}
