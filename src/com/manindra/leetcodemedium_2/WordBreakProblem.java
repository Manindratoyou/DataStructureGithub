package com.manindra.leetcodemedium_2;

import java.util.*;

public class WordBreakProblem { //solution 139

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);

        int maxLen = 0;
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= Math.max(0, i - maxLen); j--) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        List<String> dict1 = Arrays.asList("leet", "code");
        String s1 = "leetcode";
        System.out.println(wordBreak(s1, dict1)); // true

        List<String> dict2 = Arrays.asList("apple", "pen");
        String s2 = "applepenapple";
        System.out.println(wordBreak(s2, dict2)); // true

        List<String> dict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        String s3 = "catsandog";
        System.out.println(wordBreak(s3, dict3)); // false

        List<String> dict4 = Arrays.asList("a", "aa", "aaa", "aaaa");
        String s4 = "aaaaaaa";
        System.out.println(wordBreak(s4, dict4)); // true
    }
}

