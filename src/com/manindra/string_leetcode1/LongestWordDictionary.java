package com.manindra.string_leetcode1;

import java.util.*;

public class LongestWordDictionary { //solution 524

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> dictionary = Arrays.asList("ale","apple","monkey","plea");

        System.out.println(findLongestWord(s, dictionary)); // Output: "apple"
    }

    public static String findLongestWord(String s, List<String> dictionary) {
        // Sort dictionary: longer first, if tie lexicographically smaller first
        dictionary.sort((a, b) -> {
            if (b.length() != a.length())
                return b.length() - a.length();
            return a.compareTo(b);
        });

        for (String word : dictionary) {
            if (isSubsequence(word, s)) {
                return word;
            }
        }
        return "";
    }

    private static boolean isSubsequence(String word, String s) {
        int i = 0, j = 0;
        while (i < word.length() && j < s.length()) {
            if (word.charAt(i) == s.charAt(j)) i++;
            j++;
        }
        return i == word.length();
    }

}

