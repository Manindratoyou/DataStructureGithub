package com.manindra.interview_2;

import java.util.*;

public class LongestUniformSubstring {

    public static void main(String[] args) {

        System.out.println(findLongestNonRepeatingCharSolutionOne("abbbccda"));
        System.out.println(findLongestNonRepeatingCharSolutionTwo("abbbccda"));
        System.out.println("=============================");
        System.out.println(findLongestRepeatingCharSolutionOne("abbbccdab"));
    }

    static String findLongestNonRepeatingCharSolutionOne(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int maxLength = 0;
        int left = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        String longestString = "";

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            if (charIndexMap.containsKey(currentChar)) {
                left = Math.max(left, charIndexMap.get(currentChar) + 1);
            }
            charIndexMap.put(currentChar, right);
            int currentLength = right - left + 1;
            if (currentLength > maxLength) {
                longestString = s.substring(left, right + 1);
                maxLength = currentLength;
            }
        }

        return longestString;
    }

    static String findLongestNonRepeatingCharSolutionTwo(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int maxLength = 0;
        int left = 0;
        int right = 0;
        Set<Character> charSet = new HashSet<>();
        String longestString = "";

        while (right < s.length()) {
            char currentChar = s.charAt(right);
            if (!charSet.contains(currentChar)) {
                charSet.add(currentChar);
                right++;
                int currentLength = right - left;
                if (currentLength > maxLength) {
                    longestString = s.substring(left, right);
                    maxLength = currentLength;
                }
            } else {
                charSet.remove(s.charAt(left));
                left++;
            }
        }

        return longestString;
    }

    static String findLongestRepeatingCharSolutionOne(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int maxLength = 0;
        int start = 0;
        int end = 0;
        int currentLength = 0;
        int maxStart = 0; // To track the start of the longest uniform substring
        Map<Character, Integer> charCountMap = new HashMap<>();

        while (end < s.length()) {
            char currentChar = s.charAt(end);
            charCountMap.put(currentChar, charCountMap.getOrDefault(currentChar, 0) + 1);

            while (charCountMap.size() > 1) {
                char leftChar = s.charAt(start);
                charCountMap.put(leftChar, charCountMap.get(leftChar) - 1);
                if (charCountMap.get(leftChar) == 0) {
                    charCountMap.remove(leftChar);
                }
                start++;
            }

            currentLength = end - start + 1;

            if (currentLength > maxLength) {
                maxLength = currentLength;
                maxStart = start;
            }

            end++;
        }

        return s.substring(maxStart, maxStart + maxLength);
    }


}
