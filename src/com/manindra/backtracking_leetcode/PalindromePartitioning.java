package com.manindra.backtracking_leetcode;

import java.util.*;

public class PalindromePartitioning { //solution 131

    public static void main(String[] args) {
        PalindromePartitioning obj = new PalindromePartitioning();
        String s = "aab";
        System.out.println(obj.partition(s)); // Output: [["a","a","b"],["aa","b"]]
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> currentList, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                currentList.add(s.substring(start, end + 1));
                backtrack(s, end + 1, currentList, result);
                currentList.remove(currentList.size() - 1); // backtrack
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }


    //sol2

    public List<List<String>> partition2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        List<List<String>> result = new ArrayList<>();

        // Precompute palindrome substrings
        for (int end = 0; end < n; end++) {
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) &&
                        (end - start <= 2 || dp[start + 1][end - 1])) {
                    dp[start][end] = true;
                }
            }
        }

        backtrack(0, s, dp, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, String s, boolean[][] dp, List<String> currentList, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                currentList.add(s.substring(start, end + 1));
                backtrack(end + 1, s, dp, currentList, result);
                currentList.remove(currentList.size() - 1); // backtrack
            }
        }
    }

}

