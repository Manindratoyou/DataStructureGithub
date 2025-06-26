package com.manindra.dynamicprogramming_leetcode;

public class StockWithFee { //solution 714

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println("Max Profit: " + maxProfit(prices, fee)); // Output: 8
    }

    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int hold = -prices[0];  // profit if we buy on day 0
        int cash = 0;           // profit if we don't have stock

        for (int i = 1; i < n; i++) {
            hold = Math.max(hold, cash - prices[i]);            // Buy or hold
            cash = Math.max(cash, hold + prices[i] - fee);      // Sell or rest
        }

        return cash; // Final profit is when we're not holding any stock
    }

    public static int maxProfitDP(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0) return 0;

        int[][] dp = new int[n][2]; // dp[i][0] = cash, dp[i][1] = hold

        dp[0][0] = 0;             // not holding on day 0
        dp[0][1] = -prices[0];    // bought on day 0

        for (int i = 1; i < n; i++) {
            // Not holding stock: either we did nothing, or we sold today
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i] - fee);

            // Holding stock: either we did nothing, or we bought today
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }

        // We return dp[n-1][0] because we want to end with no stock
        return dp[n-1][0];
    }
}

