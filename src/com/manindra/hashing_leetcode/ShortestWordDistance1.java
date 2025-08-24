package com.manindra.hashing_leetcode;

import java.util.*;

public class ShortestWordDistance1 { //solution 243

    public static void main(String[] args) {
        ShortestWordDistance1 solver = new ShortestWordDistance1();

        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "practice";

        System.out.println("🔹 Solution 1 (One-pass): " +
                solver.shortestDistanceOnePass(words, word1, word2)); // Output: 3

        System.out.println("🔹 Solution 2 (Brute-force): " +
                solver.shortestDistanceBruteForce(words, word1, word2)); // Output: 3

        System.out.println("🔹 Solution 3 (With Preprocessing): " +
                solver.shortestDistanceWithPreprocessing(words, word1, word2)); // Output: 3

        // Additional test
        String word3 = "makes";
        String word4 = "coding";

        System.out.println("🔹 Additional test (One-pass): " +
                solver.shortestDistanceOnePass(words, word3, word4)); // Output: 1
    }

    // ✅ Solution 1: One-Pass, O(n)
    public int shortestDistanceOnePass(String[] words, String word1, String word2) {
        int idx1 = -1, idx2 = -1, minDist = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1))
                idx1 = i;
            else if (words[i].equals(word2))
                idx2 = i;

            if (idx1 != -1 && idx2 != -1) {
                minDist = Math.min(minDist, Math.abs(idx1 - idx2));
            }
        }
        return minDist;
    }

    // ❌ Solution 2: Brute-force, O(n^2)
    public int shortestDistanceBruteForce(String[] words, String word1, String word2) {
        int minDist = words.length;
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(word1)) continue;
            for (int j = 0; j < words.length; j++) {
                if (!words[j].equals(word2)) continue;
                if (i != j) {
                    minDist = Math.min(minDist, Math.abs(i - j));
                }
            }
        }
        return minDist;
    }

    // ✅ Solution 3: Preprocess with HashMap for repeated queries
    public int shortestDistanceWithPreprocessing(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        // Build index map
        for (int i = 0; i < words.length; i++) {
            map.computeIfAbsent(words[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);

        // Two pointer approach to find min distance
        int i = 0, j = 0, minDist = words.length;
        while (i < list1.size() && j < list2.size()) {
            minDist = Math.min(minDist, Math.abs(list1.get(i) - list2.get(j)));
            if (list1.get(i) < list2.get(j))
                i++;
            else
                j++;
        }
        return minDist;
    }


}

