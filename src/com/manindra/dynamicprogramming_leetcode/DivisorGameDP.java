package com.manindra.dynamicprogramming_leetcode;

public class DivisorGameDP { //solution 1025

    public static void main(String[] args) {
        DivisorGameDP obj = new DivisorGameDP();
        System.out.println(obj.divisorGame(2)); // true
        System.out.println(obj.divisorGame(3)); // false
        System.out.println(obj.divisorGame(4)); // true
        System.out.println(obj.divisorGame(5)); // false
        System.out.println(obj.divisorGame(10)); // true
    }

    public boolean divisorGame(int n) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = false; // not used
        dp[1] = false; // only move is to lose
        if (n >= 2) dp[2] = true; // Alice can subtract 1 and win

        for (int i = 3; i <= n; i++) {
            for (int x = 1; x < i; x++) {
                if (i % x == 0 && !dp[i - x]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}

