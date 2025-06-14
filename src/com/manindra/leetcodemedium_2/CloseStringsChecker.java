package com.manindra.leetcodemedium_2;

import java.util.Arrays;

public class CloseStringsChecker { //solution 1657

    public static void main(String[] args) {

        CloseStringsChecker checker = new CloseStringsChecker();

        System.out.println(checker.closeStrings("abc", "bca"));       // true
        System.out.println(checker.closeStrings("a", "aa"));          // false
        System.out.println(checker.closeStrings("cabbba", "abbccc")); // true
        System.out.println(checker.closeStrings("cabbba", "aabbss")); // false
        System.out.println(checker.closeStrings("uau", "ssx"));       // false
    }

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            count1[word1.charAt(i) - 'a']++;
            count2[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            // Check if both words have the same set of characters
            if ((count1[i] == 0 && count2[i] != 0) || (count1[i] != 0 && count2[i] == 0)) {
                return false;
            }
        }

        Arrays.sort(count1);
        Arrays.sort(count2);

        return Arrays.equals(count1, count2);
    }
}

