package com.manindra.string_leetcode1;

public class LargestSubstringBetweenEqualChars { //solution 1624

    public static void main(String[] args) {
        System.out.println(maxLengthBetweenEqualCharacters("aa"));     // 0
        System.out.println(maxLengthBetweenEqualCharacters("abca"));   // 2
        System.out.println(maxLengthBetweenEqualCharacters("cbzxy"));  // -1
        System.out.println(maxLengthBetweenEqualCharacters("cabbac")); // 4
    }

    public static int maxLengthBetweenEqualCharacters(String s) {
        int[] firstIndex = new int[26];
        for (int i = 0; i < 26; i++) {
            firstIndex[i] = -1; // initialize
        }

        int maxLen = -1;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (firstIndex[idx] == -1) {
                firstIndex[idx] = i; // first occurrence
            } else {
                maxLen = Math.max(maxLen, i - firstIndex[idx] - 1);
            }
        }
        return maxLen;
    }


}

