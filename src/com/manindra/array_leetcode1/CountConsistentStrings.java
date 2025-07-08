package com.manindra.array_leetcode1;

import java.util.HashSet;
import java.util.Set;

public class CountConsistentStrings { //solution 1684

    public static void main(String[] args) {
        String allowed1 = "ab";
        String[] words1 = {"ad", "bd", "aaab", "baa", "badab"};
        System.out.println(countConsistentStrings(allowed1, words1)); // Expected: 2

        String allowed2 = "abc";
        String[] words2 = {"a", "b", "c", "ab", "ac", "bc", "abc"};
        System.out.println(countConsistentStrings(allowed2, words2)); // Expected: 7

        String allowed3 = "cad";
        String[] words3 = {"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"};
        System.out.println(countConsistentStrings(allowed3, words3)); // Expected: 4
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        // Convert allowed string into a set of characters for quick lookup
        Set<Character> allowedSet = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            allowedSet.add(c);
        }

        int count = 0;
        for (String word : words) {
            boolean isConsistent = true;
            for (char c : word.toCharArray()) {
                if (!allowedSet.contains(c)) {
                    isConsistent = false;
                    break;
                }
            }
            if (isConsistent) {
                count++;
            }
        }

        return count;
    }
}
