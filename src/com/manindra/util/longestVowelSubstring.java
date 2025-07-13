package com.manindra.util;

import java.util.Set;

public class longestVowelSubstring { //similar leet code solution3 or solution1456

    public static void main(String[] args) {
        System.out.println(longestVowelSubstring("earthproblem"));    // Output: 2 ("ea")
        System.out.println(longestVowelSubstring("letsgotothebeach")); // Output: 3 ("eao")
        System.out.println(longestVowelSubstring("rhythm"));          // Output: 0 (no vowels)
        System.out.println(longestVowelSubstring("abciiidef"));
        System.out.println(longestVowelSubstring("abdaeeiouf"));
    }


    public static int longestVowelSubstring(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (!vowels.contains(ch)) {
                // Reset the window if a consonant is found
                left = right + 1;
            } else {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }

}
