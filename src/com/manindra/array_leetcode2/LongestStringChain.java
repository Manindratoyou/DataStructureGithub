package com.manindra.array_leetcode2;

import java.util.*;

public class LongestStringChain { //solution 1048

    public static void main(String[] args) {
        LongestStringChain lsc = new LongestStringChain();
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        System.out.println("Longest Chain Length: " + lsc.longestStrChain(words)); // Output: 4
    }

    public int longestStrChain(String[] words) {
        // Sort words by length
        Arrays.sort(words, Comparator.comparingInt(String::length));

        // Map to store the longest chain ending at each word
        Map<String, Integer> dp = new HashMap<>();
        int maxLen = 1;

        for (String word : words) {
            int best = 0;

            // Try removing each character to check for a predecessor
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best, dp.getOrDefault(prev, 0));
            }

            dp.put(word, best + 1);
            maxLen = Math.max(maxLen, dp.get(word));
        }

        return maxLen;
    }
}

