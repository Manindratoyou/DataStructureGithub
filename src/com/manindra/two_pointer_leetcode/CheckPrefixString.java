package com.manindra.two_pointer_leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CheckPrefixString { //solution 1961

    public static void main(String[] args) {
        System.out.println(isPrefixString("iloveleetcode", new String[]{"i","love","leetcode","apples"})); // true
        System.out.println(isPrefixString("iloveleetcode", new String[]{"apples","i","love"})); // false
    }

    public static boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            sb.append(word);
            if (sb.toString().equals(s))
                return true;
            if (sb.length() > s.length())
                return false;
        }

        return false;
    }

    public static boolean isPrefixString2(String s, String[] words) {
        String concatenated = Arrays.stream(words)
                .collect(Collectors.joining());
        return concatenated.startsWith(s) && s.length() <= concatenated.length();
    }

    public static boolean isPrefixString3(String s, String[] words) {
        int pos = 0;

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (pos >= s.length() || s.charAt(pos) != c) {
                    return false;
                }
                pos++;
            }
            if (pos == s.length()) return true; // fully matched
        }

        return pos == s.length();
    }

}

