package com.manindra.dynamicprogramming_leetcode;

public class StockWithCooldown { //solution 309

    public static void main(String[] args) {
        StockWithCooldown obj = new StockWithCooldown();
        System.out.println(obj.maxProfit(new int[]{1, 2, 3, 0, 2})); // Output: 3
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;

        int n = prices.length;

        int[] hold = new int[n];
        int[] sold = new int[n];
        int[] rest = new int[n];

        hold[0] = -prices[0];
        sold[0] = 0;
        rest[0] = 0;

        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], rest[i - 1] - prices[i]);
            sold[i] = hold[i - 1] + prices[i];
            rest[i] = Math.max(rest[i - 1], sold[i - 1]);
        }

        return Math.max(sold[n - 1], rest[n - 1]); // Final profit must be after selling or resting
    }

    public int maxProfit2(int[] prices) {
        int hold = -prices[0];
        int sold = 0;
        int rest = 0;

        for (int i = 1; i < prices.length; i++) {
            int prevHold = hold;
            hold = Math.max(hold, rest - prices[i]);
            rest = Math.max(rest, sold);
            sold = prevHold + prices[i];
        }

        return Math.max(sold, rest);
    }
}

