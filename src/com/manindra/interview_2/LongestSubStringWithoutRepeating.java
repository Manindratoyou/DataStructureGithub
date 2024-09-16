package com.manindra.interview_2;

import java.util.*;

public class LongestSubStringWithoutRepeating { // see solution 3 also

    //"10000111" => [ 1, 4 ]
    //"aabbbbbCdAA" => [ 2, 5 ]

    public static void main(String[] args) {
        System.out.println(Arrays.toString(longestUniformSubstring("10000111"))); // Output: [1, 4]
        System.out.println(Arrays.toString(longestUniformSubstring("aabbbbbCdAA"))); // Output: [2, 5]
        System.out.println("==");
        System.out.println(longestUniformSubstring1("aabbbbbCdAA"));
    }

    static public int[] longestUniformSubstring(String s) {

        if (s.isEmpty()) {
            return new int[]{-1, 0};  // Handle empty string case
        }

        int n = s.length();
        int currLen = 1, maxLength = 1, startIndex = 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currLen++;
            } else {
                if (currLen > maxLength) {
                    maxLength = currLen;
                    startIndex = i - currLen;
                }
                currLen = 1;
            }
        }

        // Check for the last substring
        if (currLen > maxLength) {
            maxLength = currLen;
            startIndex = n - currLen;
        }

        return new int[]{startIndex, maxLength};
    }

    static public String longestUniformSubstring1(String s) {

        if (s.isEmpty()) {
            return "";  // Handle empty string case
        }

        int n = s.length();
        int currLen = 1, maxLength = 1, startIndex = 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currLen++;
            } else {
                if (currLen > maxLength) {
                    maxLength = currLen;
                    startIndex = i - currLen;
                }
                currLen = 1;
            }
        }

        // Check for the last substring
        if (currLen > maxLength) {
            maxLength = currLen;
            startIndex = n - currLen;
        }

        return s.substring(startIndex, startIndex + maxLength);
    }

}
