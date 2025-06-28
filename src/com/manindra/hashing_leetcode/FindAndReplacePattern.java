package com.manindra.hashing_leetcode;

import java.util.*;

public class FindAndReplacePattern { //solution 890

    public static void main(String[] args) {
        FindAndReplacePattern solution = new FindAndReplacePattern();
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        System.out.println(solution.findAndReplacePattern(words, pattern)); // Output: [mee, aqq]
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        String patternCode = encode(pattern);

        for (String word : words) {
            if (encode(word).equals(patternCode)) {
                result.add(word);
            }
        }

        return result;
    }
    // Helper to encode pattern like abb → 0 1 1
    private String encode(String word) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int index = 0;

        for (char c : word.toCharArray()) {
            map.putIfAbsent(c, index++);
            sb.append(map.get(c)).append(" ");
        }

        return sb.toString().trim();
    }
}

