package com.manindra.dynamicprogramming_leetcode;

public class BestTimeToBuyAndSellStockWithCooldown { //solution 309

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println("Maximum Profit: " + maxProfit(prices)); // Output: 3
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int n = prices.length;
        int hold = -prices[0]; // Max profit if holding a stock
        int sold = 0;          // Max profit if just sold a stock
        int rest = 0;          // Max profit if resting (cooldown or idle)

        for (int i = 1; i < n; i++) {
            int prevHold = hold;
            int prevSold = sold;
            int prevRest = rest;

            hold = Math.max(prevHold, prevRest - prices[i]); // Buy today or keep holding
            sold = prevHold + prices[i];                     // Sell today
            rest = Math.max(prevRest, prevSold);             // Cooldown or rest
        }

        return Math.max(sold, rest); // Final profit (can't end on holding)
    }
}

