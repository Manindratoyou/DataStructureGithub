package com.manindra.hashing_leetcode;

import java.util.*;

public class MinimumWindowSubstring { //solution 76

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // BANC
        System.out.println(minWindow("a", "a")); // a
        System.out.println(minWindow("a", "aa")); // ""
        System.out.println(minWindow("ab", "b")); // b
        System.out.println(minWindow("bba", "ab")); // ba
    }

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        // Count characters in t
        Map<Character, Integer> requiredMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            requiredMap.put(ch, requiredMap.getOrDefault(ch, 0) + 1);
        }

        int left = 0, right = 0, start = 0;
        int minLen = Integer.MAX_VALUE;
        int required = requiredMap.size();
        int formed = 0;

        Map<Character, Integer> windowCounts = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            // Check if current character matches requirement
            if (requiredMap.containsKey(c) &&
                    windowCounts.get(c).intValue() == requiredMap.get(c).intValue()) {
                formed++;
            }

            // Try to shrink the window
            while (left <= right && formed == required) {
                // Update minimum window
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char removeChar = s.charAt(left);
                windowCounts.put(removeChar, windowCounts.get(removeChar) - 1);
                if (requiredMap.containsKey(removeChar) &&
                        windowCounts.get(removeChar).intValue() < requiredMap.get(removeChar).intValue()) {
                    formed--;
                }

                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}

