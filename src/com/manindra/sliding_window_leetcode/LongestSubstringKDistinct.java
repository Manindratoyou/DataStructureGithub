package com.manindra.sliding_window_leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct { //solution 340

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringKDistinct("eceba", 2)); // 3
        System.out.println(lengthOfLongestSubstringKDistinct("aa", 1));    // 2
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, right); // store last index of character

            // If more than k distinct characters, shrink the window
            if (map.size() > k) {
                int delIndex = Integer.MAX_VALUE;
                for (int index : map.values()) {
                    delIndex = Math.min(delIndex, index);
                }
                char charToRemove = s.charAt(delIndex);
                map.remove(charToRemove);
                left = delIndex + 1;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}

