package com.manindra.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution389 { //Find the Difference

    public static void main(String[] args) {

        System.out.println(findTheDifference("abcd", "abcde")); // Output: e
        System.out.println(findTheDifferenceSolutionTwo("abcd", "abcde")); // Output: e
        System.out.println(findTheDifferenceSolutionFour("abcd", "abcde")); // Output: e
    }

    static char findTheDifference(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        Arrays.sort(sArray);
        Arrays.sort(tArray);

        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] != tArray[i])
                return tArray[i];
        }
        return tArray[tArray.length - 1];
    }

    static char findTheDifferenceSolutionTwo(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        for (char c : t.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            if (count == 0)
                return c;
            map.put(c, count - 1);
        }
        return 0; // This should not be reached if input is valid
    }

    static char findTheDifferenceSolutionThree(String s, String t) {
        char result = 0;
        for (char c : s.toCharArray()) {
            result ^= c;
        }
        for (char c : t.toCharArray()) {
            result ^= c;
        }
        return result;
    }

    static char findTheDifferenceSolutionFour(String s, String t) {
        int total = 0;
        for (int i = 0; i < t.length(); i++) {
            total = total + t.charAt(i);
        }
        for (int i = 0; i < s.length(); i++) {
            total = total - s.charAt(i);
        }
        return (char) total;
    }
}
