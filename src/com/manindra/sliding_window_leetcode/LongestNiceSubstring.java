package com.manindra.sliding_window_leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestNiceSubstring { //solution 1763

    public static void main(String[] args) {
        LongestNiceSubstring obj = new LongestNiceSubstring();
        System.out.println(obj.longestNiceSubstring("YazaAay")); // Output: "aAa"
        System.out.println(obj.longestNiceSubstring("Bb"));      // Output: "Bb"
        System.out.println(obj.longestNiceSubstring("c"));       // Output: ""
    }

    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";

        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) set.add(c);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(Character.toUpperCase(ch)) && set.contains(Character.toLowerCase(ch)))
                continue;

            // Not nice — divide and conquer
            String left = longestNiceSubstring(s.substring(0, i));
            String right = longestNiceSubstring(s.substring(i + 1));
            return left.length() >= right.length() ? left : right;
        }

        // Entire string is nice
        return s;
    }

    public String longestNiceSubstring2(String s) {
        int maxLen = 0;
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                set.add(s.charAt(j));

                if (isNice(set)) {
                    int len = j - i + 1;
                    if (len > maxLen) {
                        maxLen = len;
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }

        return result;
    }

    private boolean isNice(Set<Character> set) {
        for (char c : set) {
            if (Character.isLowerCase(c) && !set.contains(Character.toUpperCase(c)))
                return false;
            if (Character.isUpperCase(c) && !set.contains(Character.toLowerCase(c)))
                return false;
        }
        return true;
    }
}

