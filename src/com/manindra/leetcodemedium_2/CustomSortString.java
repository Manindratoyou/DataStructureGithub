package com.manindra.leetcodemedium_2;

import java.util.*;

public class CustomSortString { // Solution 791

    public static void main(String[] args) {
        System.out.println(customSortString("cba", "abcd")); // Expected: "cbad"
        System.out.println(customSortString("kqep", "pekeq")); // Expected: "kqeep" or similar
        System.out.println(customSortString("huc", "chuchu")); // Expected: "hhuucc" or similar
    }

    public static String customSortString(String order, String s) {
        // Count frequency of characters in s
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Build result based on custom order
        StringBuilder result = new StringBuilder();

        for (char ch : order.toCharArray()) {
            if (freqMap.containsKey(ch)) {
                int count = freqMap.get(ch);
                while (count-- > 0) {
                    result.append(ch);
                }
                freqMap.remove(ch); // Already added
            }
        }

        // Add remaining characters (not in order)
        for (char ch : freqMap.keySet()) {
            int count = freqMap.get(ch);
            while (count-- > 0) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static String customSortStringOptimized(String order, String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder result = new StringBuilder();

        for (char ch : order.toCharArray()) {
            while (freq[ch - 'a']-- > 0) {
                result.append(ch);
            }
        }

        for (int i = 0; i < 26; i++) {
            while (freq[i]-- > 0) {
                result.append((char) (i + 'a'));
            }
        }

        return result.toString();
    }

}
