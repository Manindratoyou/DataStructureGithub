package com.manindra.leetcodeEasy;

import java.util.HashMap;
import java.util.Map;

public class RansomNoteChecker {  //solution 383

    // Main method with test cases
    public static void main(String[] args) {
        String[] ransomNotes = {"a", "aa", "aa", "abc", "aabbcc"};
        String[] magazines = {"b", "ab", "aab", "aabbcc", "abcabc"};

        System.out.println("Using Array:");
        for (int i = 0; i < ransomNotes.length; i++) {
            System.out.println("Test " + (i + 1) + ": " +
                    canConstructUsingArray(ransomNotes[i], magazines[i]));
        }

        System.out.println("\nUsing HashMap:");
        for (int i = 0; i < ransomNotes.length; i++) {
            System.out.println("Test " + (i + 1) + ": " +
                    canConstructUsingMap(ransomNotes[i], magazines[i]));
        }
    }

    // Method 1: Using character count array
    public static boolean canConstructUsingArray(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (count[c - 'a'] == 0)
                return false;
            count[c - 'a']--;
        }
        return true;
    }

    // Method 2: Using HashMap
    public static boolean canConstructUsingMap(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0)
                return false;
            map.put(c, map.get(c) - 1);
        }
        return true;
    }

    public static boolean canConstruct3(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (char c : ransomNote.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
            count[c - 'a']--;
        }
        for (int i : count) {
            if (i > 0)
                return false;
        }
        return true;
    }

}

