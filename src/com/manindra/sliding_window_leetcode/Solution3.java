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

        System.out.println(solution.lengthOfLongestSubStringSolTwo("abcabcab"));
        System.out.println(solution.lengthOfLongestSubStringSolTwo("bbbbb"));
        System.out.println(solution.lengthOfLongestSubStringSolTwo("pwwkewxpw"));
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

    public int lengthOfLongestSubStringSolTwo(String s) {
        Set<Character> set = new HashSet<>();

        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
