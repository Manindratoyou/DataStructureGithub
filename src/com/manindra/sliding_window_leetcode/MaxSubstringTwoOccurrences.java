package com.manindra.sliding_window_leetcode;

import java.util.HashMap;

public class MaxSubstringTwoOccurrences { //solution 3090

    public static int maxLength(String s) {
        int left = 0, maxLen = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);

            while (freqMap.get(ch) > 2) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s1 = "bcbbbcba";
        String s2 = "aabbcc";
        String s3 = "abcabcabc";

        System.out.println(maxLength(s1)); // Output: 4
        System.out.println(maxLength(s2)); // Output: 6
        System.out.println(maxLength(s3)); // Output: 6
    }
}

