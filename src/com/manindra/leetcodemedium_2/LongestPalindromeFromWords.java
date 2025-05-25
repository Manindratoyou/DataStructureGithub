package com.manindra.leetcodemedium_2;

import java.util.*;
import java.util.stream.Collectors;

public class LongestPalindromeFromWords { //solution 2131

    public static void main(String[] args) {
        // Test Case 1
        String[] words1 = {"lc", "cl", "gg"};
        System.out.println("Test 1: Expected = 6, Got = " + longestPalindrome(words1));

        // Test Case 2
        String[] words2 = {"ab", "ty", "yt", "lc", "cl", "ab"};
        System.out.println("Test 2: Expected = 8, Got = " + longestPalindrome(words2));

        // Test Case 3
        String[] words3 = {"cc", "ll", "xx"};
        System.out.println("Test 3: Expected = 2, Got = " + longestPalindrome(words3));

        // Test Case 4
        String[] words4 = {"aa", "aa", "aa"};
        System.out.println("Test 4: Expected = 6, Got = " + longestPalindrome(words4));

        // Test Case 5
        String[] words5 = {"ab", "ba", "cd", "dc", "ee"};
        System.out.println("Test 5: Expected = 10, Got = " + longestPalindrome(words5));
    }

    public static int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int length = 0;

        for (String word : words) {
            String rev = new StringBuilder(word).reverse().toString();
            if (map.getOrDefault(rev, 0) > 0) {
                length += 4; // e.g., "ab" + "ba" => "abba"
                map.put(rev, map.get(rev) - 1);
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        // Check for any unpaired same-letter word like "aa", "bb" to put in the center
        for (String key : map.keySet()) {
            if (key.charAt(0) == key.charAt(1) && map.get(key) > 0) {
                length += 2;
                break;
            }
        }

        return length;
    }

    public int longestPalindrome2(String[] words) {
        Map<String, Long> countMap = Arrays.stream(words)
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        int length = 0;
        boolean centralUsed = false;

        for (String word : countMap.keySet()) {
            String rev = new StringBuilder(word).reverse().toString();

            if (!word.equals(rev)) {
                long pairCount = Math.min(countMap.get(word), countMap.getOrDefault(rev, 0L));
                length += pairCount * 4;
                countMap.put(word, countMap.get(word) - pairCount);
                countMap.put(rev, countMap.get(rev) - pairCount);
            }
        }

        for (Map.Entry<String, Long> entry : countMap.entrySet()) {
            if (entry.getKey().charAt(0) == entry.getKey().charAt(1) && entry.getValue() > 0) {
                length += 2;
                break;
            }
        }

        return length;
    }

}

