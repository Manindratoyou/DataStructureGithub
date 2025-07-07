package com.manindra.leetcodemedium_2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquaresDP { //Solution 279

    public static void main(String[] args) {
        int n = 12;
        System.out.println(numSquares(n));  // Output: 3
    }

    public static int numSquares(int n) { //DP Based
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

    public static int numSquares2(int n) { //BFS
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(n);
        visited[n] = true;

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                for (int j = 1; j * j <= curr; j++) {
                    int next = curr - j * j;
                    if (next == 0) return level;

                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
        }

        return -1; // Should never reach here
    }

    public static int numSquares3(int n) { //Approach 3: Mathematical Theorem (Lagrange's 4-square theorem)
        if (isPerfect(n)) return 1;

        // Check sum of two squares
        for (int i = 1; i * i <= n; i++) {
            if (isPerfect(n - i * i)) return 2;
        }

        // Check Legendre's condition for 4 squares
        while (n % 4 == 0) n /= 4;
        if (n % 8 == 7) return 4;

        return 3;
    }

    private static boolean isPerfect(int x) {
        int sqrt = (int)Math.sqrt(x);
        return sqrt * sqrt == x;
    }
}

