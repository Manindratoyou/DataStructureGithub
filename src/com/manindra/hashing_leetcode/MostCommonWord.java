package com.manindra.hashing_leetcode;

import java.util.*;

public class MostCommonWord { //solution 819

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(mostCommonWord(paragraph, banned)); // Output: "ball"
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String b : banned) bannedSet.add(b.toLowerCase());

        // Normalize: replace punctuation with space
        paragraph = paragraph.toLowerCase().replaceAll("[!?.',;]", " ");

        String[] words = paragraph.split("\\s+");

        Map<String, Integer> freq = new HashMap<>();
        String result = "";
        int maxCount = 0;

        for (String w : words) {
            if (w.isEmpty() || bannedSet.contains(w)) continue;

            freq.put(w, freq.getOrDefault(w, 0) + 1);

            if (freq.get(w) > maxCount) {
                maxCount = freq.get(w);
                result = w;
            }
        }

        return result;
    }

}

