package com.manindra.string_leetcode1;

import java.util.HashSet;
import java.util.Set;

public class MinDeletions { //solution 1647

    public static void main(String[] args) {
        System.out.println(minDeletions("aab"));      // Output: 0 (freq: a=2, b=1)
        System.out.println(minDeletions("aaabbbcc")); // Output: 2 (could become: a=3, b=2, c=1)
        System.out.println(minDeletions("ceabaacb")); // Output: 2
    }


    public static int minDeletions(String s) {
        int[] freq = new int[26];

        // Count character frequencies
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        Set<Integer> usedFreqs = new HashSet<>();
        int deletions = 0;

        for (int f : freq) {
            while (f > 0 && !usedFreqs.add(f)) {
                f--;        // delete one character
                deletions++;
            }
        }

        return deletions;
    }

}
