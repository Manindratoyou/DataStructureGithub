package com.manindra.dynamicprogramming_leetcode;

public class BeautifulArrangement { //solution 526

    public static void main(String[] args) {
        BeautifulArrangement solution = new BeautifulArrangement();
        System.out.println(solution.countArrangement(2)); // Output: 2
        System.out.println(solution.countArrangement(3)); // Output: 3
    }

    public int countArrangement(int n) { //DP with Bitmask
        int size = 1 << n;
        int[] dp = new int[size];
        dp[0] = 1; // Base case: empty arrangement

        for (int mask = 0; mask < size; mask++) {
            int pos = Integer.bitCount(mask) + 1; // current position (1-based)

            for (int num = 1; num <= n; num++) {
                int bit = 1 << (num - 1);
                if ((mask & bit) == 0 && (num % pos == 0 || pos % num == 0)) {
                    dp[mask | bit] += dp[mask];
                }
            }
        }
        return dp[size - 1]; // All numbers used
    }

    public int countArrangement2(int n) { //Backtracking Approach
        boolean[] visited = new boolean[n + 1];
        return backtrack(n, 1, visited);
    }

    private int backtrack(int n, int pos, boolean[] visited) {
        if (pos > n) return 1;

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i] && (i % pos == 0 || pos % i == 0)) {
                visited[i] = true;
                count += backtrack(n, pos + 1, visited);
                visited[i] = false;
            }
        }
        return count;
    }

}

