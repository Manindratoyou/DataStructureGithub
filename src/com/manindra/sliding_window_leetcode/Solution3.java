package com.manindra.sliding_window_leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3 { //Longest Substring Without Repeating Characters

    public static void main(String[] args) {

        Solution3 solution = new Solution3();
        System.out.println(solution.lengthOfLongestSubString("abcabcab"));
        System.out.println(solution.lengthOfLongestSubString("bbbbb"));
        System.out.println(solution.lengthOfLongestSubString("pwwkewxpw"));

        System.out.println("==============");

        System.out.println(solution.lengthOfLongestSubstring("abcabcab"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkewxpw"));
    }

    public int lengthOfLongestSubString(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int maxLength = 0;
        int left = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (charIndexMap.containsKey(currentChar)) {
                left = Math.max(left, charIndexMap.get(currentChar) + 1);
            }
            charIndexMap.put(currentChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring(String s) { //use this
        int left = 0, maxLen = 0;
        Set<Character> window = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // Remove characters until the current character is unique in window
            while (window.contains(ch)) {
                window.remove(s.charAt(left));
                left++;
            }

            window.add(ch);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }


    public static int lengthOfLongestSubstring3(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, maxLen = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            if (!set.contains(c)) {
                set.add(c);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLen;
    }
}
