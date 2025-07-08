package com.manindra.sliding_window_leetcode;

import java.util.stream.IntStream;

public class SubstringsOfSizeThree { //Solution 1876

    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("xyzzaz"));       // Output: 1
        System.out.println(countGoodSubstringsSlidingWindow("aababcabc"));    // Output: 4
        System.out.println(countGoodSubstringsStream("abc"));          // Output: 1
        System.out.println(countGoodSubstrings("aaa"));          // Output: 0
    }

    // Brute-force: Check every substring of size 3
    static int countGoodSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            char c = s.charAt(i + 2);
            if (a != b && b != c && a != c) {
                count++;
            }
        }
        return count;
    }

    static int countGoodSubstringsStream(String s) {
        if (s.length() < 3) return 0;
        return (int) IntStream.range(0, s.length() - 2)
                .filter(i -> {
                    char a = s.charAt(i), b = s.charAt(i + 1), c = s.charAt(i + 2);
                    return a != b && b != c && a != c;
                })
                .count();
    }

    static int countGoodSubstringsSlidingWindow(String s) {
        int n = s.length();
        if (n < 3) return 0;

        int count = 0;

        for (int i = 0; i <= n - 3; i++) {
            // Slide the window of size 3
            if (isDistinct(s.charAt(i), s.charAt(i + 1), s.charAt(i + 2))) {
                count++;
            }
        }

        return count;
    }

    static boolean isDistinct(char a, char b, char c) {
        return a != b && b != c && a != c;
    }
}

