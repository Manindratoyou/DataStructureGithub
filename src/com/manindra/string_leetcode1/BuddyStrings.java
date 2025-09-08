package com.manindra.string_leetcode1;

import java.util.*;
import java.util.stream.IntStream;

public class BuddyStrings { //solution 859

    public static void main(String[] args) {
        BuddyStrings obj = new BuddyStrings();
        System.out.println(obj.buddyStrings("ab", "ba"));   // true
        System.out.println(obj.buddyStrings("ab", "ab"));   // false
        System.out.println(obj.buddyStrings("aa", "aa"));   // true
        System.out.println(obj.buddyStrings("aaaaaaabc", "aaaaaaacb")); // true
        System.out.println(obj.buddyStrings("", "aa"));     // false
    }

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;

        // Case 1: Strings are equal
        if (s.equals(goal)) {
            // Need at least one duplicate character
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
                if (freq[c - 'a'] > 1) return true;
            }
            return false;
        }

        // Case 2: Strings differ
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diff.add(i);
            }
        }

        if (diff.size() != 2) return false;

        // Check if swapping makes them equal
        return s.charAt(diff.get(0)) == goal.charAt(diff.get(1)) &&
                s.charAt(diff.get(1)) == goal.charAt(diff.get(0));
    }

    public boolean buddyStrings2(String s, String goal) {
        if (s.length() != goal.length()) return false;

        if (s.equals(goal)) {
            // Check duplicates
            return s.chars().distinct().count() < s.length();
        }

        // Collect differing indices
        int[] diff = IntStream.range(0, s.length())
                .filter(i -> s.charAt(i) != goal.charAt(i))
                .toArray();

        return diff.length == 2 &&
                s.charAt(diff[0]) == goal.charAt(diff[1]) &&
                s.charAt(diff[1]) == goal.charAt(diff[0]);
    }

}

