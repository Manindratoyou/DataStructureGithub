package com.manindra.hackerrank;

import java.util.Arrays;
import java.util.List;

public class Gemstones {

    public static void main(String[] args) {

        List<String> arr = Arrays.asList("abcdde", "baccd", "eeabg");
        System.out.println(gemstones(arr)); // Output: 2
    }

    public static int gemstones(List<String> arr) {
        if (arr == null || arr.isEmpty()) {
            return 0;
        }

        // Create an array to keep track of character frequency across all strings
        int[] charCount = new int[26];

        // For each string, track unique characters
        for (String str : arr) {
            boolean[] seen = new boolean[26];
            for (char c : str.toCharArray()) {
                if (!seen[c - 'a']) {
                    charCount[c - 'a']++;
                    seen[c - 'a'] = true;
                }
            }
        }

        // Count how many characters appear in all strings
        int gemstoneCount = 0;
        for (int count : charCount) {
            if (count == arr.size()) {
                gemstoneCount++;
            }
        }

        return gemstoneCount;
    }
}
