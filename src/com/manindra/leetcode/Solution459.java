package com.manindra.leetcode;

public class Solution459 { //repeatedSubstringPattern

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab")); // true
        System.out.println(repeatedSubstringPattern("aba"));  // false
        System.out.println(repeatedSubstringPattern("abcabcabc")); // true
        System.out.println(repeatedSubstringPattern("ab")); // false
        System.out.println(repeatedSubstringPattern("a")); // false
        System.out.println(repeatedSubstringPattern("")); // false
    }

    public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int l = n / 2; l >= 1; l--) {
            if (n % l == 0) {
                int times = n / l;
                String pattern = s.substring(0, l);
                StringBuilder newStr = new StringBuilder();
                while (times-- > 0) {
                    newStr.append(pattern);
                }
                if (newStr.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean repeatedSubstringPatternSolTwo(String s) {
        int n = s.length();

        for (int len = 1; len <= n / 2; len++) {
            if (n % len == 0) {
                String substring = s.substring(0, len);
                StringBuilder repeated = new StringBuilder();
                for (int i = 0; i < n / len; i++) {
                    repeated.append(substring);
                }
                if (repeated.toString().equals(s)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean repeatedSubstringPatternSolThree(String s) {
        int n = s.length();
        int[] lps = computeLPSArray(s);
        int len = lps[n - 1];
        return len > 0 && n % (n - len) == 0;
    }

    private static int[] computeLPSArray(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int len = 0;
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}
