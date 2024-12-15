package com.manindra.hackerrank;

import java.util.HashMap;

/**
 * Problem: Sherlock and Anagrams
 *
 * Two strings are anagrams if they have the same characters but in a different order.
 * For example, "abba" and "baab" are anagrams, while "abba" and "abcd" are not.
 *
 * Given a string `s`, find the number of unordered pairs of substrings of `s`
 * that are anagrams of each other.
 *
 * Input Format:
 * - A single string `s` consisting of lowercase English letters.
 *
 * Output Format:
 * - Print a single integer denoting the number of anagrammatic pairs in the string.
 *
 * Constraints:
 * - 2 <= |s| <= 100
 *
 * Examples:
 * 1. Input: "abba"
 *    Output: 4
 *    Explanation:
 *    The 4 anagrammatic pairs are:
 *    - ["a", "a"]
 *    - ["ab", "ba"]
 *    - ["b", "b"]
 *    - ["abb", "bba"]
 *
 * 2. Input: "ifailuhkqq"
 *    Output: 3
 *
 * 3. Input: "kkkk"
 *    Output: 10
 *
 * Approach:
 * - Generate all substrings of the input string.
 * - Sort each substring to identify anagrams and use a HashMap to count their occurrences.
 * - For each substring that appears more than once, calculate the number of pairs using nC2 formula.
 */

public class SherlockAndAnagrams {

    public static void main(String[] args) {
        // Test cases
        System.out.println(sherlockAndAnagrams("abba"));          // Output: 4
        System.out.println(sherlockAndAnagrams("ifailuhkqq"));    // Output: 3
        System.out.println(sherlockAndAnagrams("kkkk"));          // Output: 10
        System.out.println(sherlockAndAnagrams("abcd"));          // Output: 0
    }

    public static int sherlockAndAnagrams(String s) {
        HashMap<String, Integer> substringMap = new HashMap<>();
        int count = 0;

        // Generate all substrings
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                // Sort the substring to identify anagrams
                String sortedSubstring = sortString(substring);

                // Count occurrences of sorted substrings
                substringMap.put(sortedSubstring, substringMap.getOrDefault(sortedSubstring, 0) + 1);
            }
        }

        // Calculate the number of anagrammatic pairs
        for (int frequency : substringMap.values()) {
            if (frequency > 1) {
                count += (frequency * (frequency - 1)) / 2; // nC2 formula
            }
        }

        return count;
    }

    private static String sortString(String s) {
        char[] chars = s.toCharArray();
        java.util.Arrays.sort(chars);
        return new String(chars);
    }
}

