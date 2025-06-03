package com.manindra.dynamicprogramming_leetcode;

public class MaxRepeatingSubstring { //solution 1668

    public static void main(String[] args) {
        MaxRepeatingSubstring obj = new MaxRepeatingSubstring();
        System.out.println(obj.maxRepeating("ababc", "ab")); // Output: 2
        System.out.println(obj.maxRepeating2("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba")); // Output: 5
        //System.out.println(obj.maxRepeating3("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba")); // Output: 5
        System.out.println(obj.maxRepeating3("ababc", "ba")); // Output: 1
    }

    public int maxRepeating(String sequence, String word) {
        int count = 0;
        StringBuilder sb = new StringBuilder(word);

        while (sequence.contains(sb.toString())) {
            count++;
            sb.append(word);
        }

        return count;
    }

    public int maxRepeating2(String sequence, String word) {
        String repeated = word;
        int count = 0;

        while (sequence.contains(repeated)) {
            count++;
            repeated += word;
        }

        return count;
    }

    public int maxRepeating3(String sequence, String word) {
        int n = sequence.length();
        int m = word.length();
        int[] dp = new int[n + 1];
        int maxRepeat = 0;

        for (int i = m; i <= n; i++) {
            if (sequence.substring(i - m, i).equals(word)) {
                dp[i] = dp[i - m] + 1;
                maxRepeat = Math.max(maxRepeat, dp[i]);
            }
        }

        return maxRepeat;
    }
}

