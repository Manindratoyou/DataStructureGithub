package com.manindra.string_leetcode1;

import java.util.*;

public class LetterTilePossibilities { //solution 1079

    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAB")); // Output: 8
        System.out.println(numTilePossibilities("AA"));  // Output: 3
    }

    public static int numTilePossibilities(String tiles) {
        int[] freq = new int[26];

        for (char c : tiles.toCharArray()) {
            freq[c - 'A']++;
        }

        return dfs(freq);
    }

    private static int dfs(int[] freq) {
        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                count++;            // using this character forms a valid sequence
                freq[i]--;          // choose
                count += dfs(freq); // explore deeper
                freq[i]++;          // backtrack
            }
        }

        return count;
    }

}

