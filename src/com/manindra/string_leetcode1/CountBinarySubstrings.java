package com.manindra.string_leetcode1;

public class CountBinarySubstrings { //solution 696

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011")); // 6
        System.out.println(countBinarySubstrings("10101"));     // 4
    }

    public static int countBinarySubstrings(String s) {
        int n = s.length();
        int prev = 0, curr = 1; // prev group length, curr group length
        int result = 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++;
            } else {
                result += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
        }
        result += Math.min(prev, curr); // last pair

        return result;
    }
    // Approach 2: Group Counting
    public static int countBinarySubstrings2(String s) {
        int n = s.length();
        int[] groups = new int[n];
        int t = 0; // group index
        groups[0] = 1;

        // Step 1: Fill groups array
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                groups[t]++;
            } else {
                groups[++t] = 1;
            }
        }

        // Step 2: Count valid substrings
        int result = 0;
        for (int i = 1; i <= t; i++) {
            result += Math.min(groups[i - 1], groups[i]);
        }

        return result;
    }



}

