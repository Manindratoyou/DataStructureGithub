package com.manindra.sliding_window_leetcode;

public class LongestVowelSubstring { //Solution 1839

    public static void main(String[] args) {
        System.out.println(longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu")); // Output: 13
        System.out.println(longestBeautifulSubstring("aeeeiiiioooauuuaeiou"));          // Output: 17
        System.out.println(longestBeautifulSubstring("aaiiou"));                        // Output: 0
    }

    static int longestBeautifulSubstring(String s) {
        int maxLen = 0;
        int n = s.length();
        int count = 1;          // number of unique vowels in order
        int length = 1;

        if (n < 5) return 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) >= s.charAt(i - 1)) {
                length++;
                if (s.charAt(i) > s.charAt(i - 1)) {
                    count++;
                }
                if (count == 5) {
                    maxLen = Math.max(maxLen, length);
                }
            } else {
                // order breaks: reset window
                count = s.charAt(i) == 'a' ? 1 : 0;
                length = 1;
            }
        }

        return maxLen;
    }
}

