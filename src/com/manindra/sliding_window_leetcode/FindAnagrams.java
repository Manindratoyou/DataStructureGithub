package com.manindra.sliding_window_leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams { //solution 438

    public static void main(String[] args) {
        FindAnagrams obj = new FindAnagrams();
        System.out.println(obj.findAnagrams("cbaebabacd", "abc")); // Output: [0, 6]
        System.out.println(obj.findAnagrams("abab", "ab"));         // Output: [0, 1, 2]
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length())
            return result;

        int[] pCount = new int[26];
        int[] window = new int[26];

        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            window[s.charAt(i) - 'a']++;

            // Shrink window when it exceeds size p.length()
            if (i >= p.length()) {
                window[s.charAt(i - p.length()) - 'a']--;
            }

            // Compare window with pCount
            if (Arrays.equals(window, pCount)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}

