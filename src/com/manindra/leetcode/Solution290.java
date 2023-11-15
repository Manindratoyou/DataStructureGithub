package com.manindra.leetcode;

import java.util.HashMap;

public class Solution290 { //WordPattern

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if (pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];

            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false;
                }
            } else {
                charToWord.put(c, word);
            }

            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) {
                    return false;
                }
            } else {
                wordToChar.put(word, c);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution290 solution = new Solution290();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog")); // Output: true
        System.out.println(solution.wordPattern("abba", "dog cat cat fish")); // Output: false
        System.out.println(solution.wordPattern("aaaa", "dog cat cat dog")); // Output: false
        System.out.println(solution.wordPattern("abba", "dog dog dog dog")); // Output: false
    }
}
