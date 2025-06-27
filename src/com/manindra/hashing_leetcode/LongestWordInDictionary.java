package com.manindra.hashing_leetcode;

import java.util.*;

public class LongestWordInDictionary {  //solution 720

    public static void main(String[] args) {
        String[] words1 = {"w", "wo", "wor", "worl", "world"};
        System.out.println(longestWord(words1)); // Output: world

        String[] words2 = {"a","banana","app","appl","ap","apply","apple"};
        System.out.println(longestWord(words2)); // Output: apple
    }

    public static String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> built = new HashSet<>();
        String result = "";

        for (String word : words) {
            if (word.length() == 1 || built.contains(word.substring(0, word.length() - 1))) {
                built.add(word);
                if (word.length() > result.length()) {
                    result = word;
                }
            }
        }

        return result;
    }

    public static String longestWord2(String[] words) {
        Arrays.sort(words);
        Set<String> built = new HashSet<>();
        return Arrays.stream(words)
                .filter(w -> w.length() == 1 || built.contains(w.substring(0, w.length() - 1)))
                .peek(built::add)
                .reduce("", (a, b) -> b.length() > a.length() ? b : a);
    }
}

