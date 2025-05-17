package com.manindra.dynamicprogramming_leetcode;

public class Solution121 { //best time to buy and sell stocks

    public static void main(String[] args) {

        int [] prices={7,1,5,3,6,4};
        System.out.println("Maximum Profit = " +maxProfit(prices));
        System.out.println("Maximum Profit = " +maxProfitSolutionTwo(prices));
        System.out.println("Maximum Profit = " +maxProfit3(prices));
    }

    static int maxProfit(int [] prices){
        if (prices==null || prices.length==0)
            return 0;
        int minPrice=Integer.MAX_VALUE;
        int maxProfit=0;

        for (int i=0;i<prices.length;i++){
            if (prices[i]<minPrice)
                minPrice=prices[i];
            else if (prices[i]-minPrice>maxProfit) {
                maxProfit=prices[i]-minPrice;
            }
        }
        return maxProfit;
    }
    static int maxProfitSolutionTwo(int [] prices){
        if (prices==null || prices.length==0)
            return 0;
        int minPrice=prices[0];
        int maxProfit=0;

        for (int i=0;i<prices.length;i++){
            if (prices[i]<minPrice)
                minPrice=prices[i];
            else
                maxProfit=Math.max(maxProfit,prices[i]-minPrice);
        }
        return maxProfit;
    }

    static int maxProfit3(int[] prices) {

        // at the beginning the minimum price is the first price
        int buy_price = prices[0];

        // at the beginning the minimum  profit is zero
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {

            // if the current price is less update the buy_price
            if (prices[i] < buy_price) {
                buy_price = prices[i];
            }
            else {
                // else check if we can get a better profit
                int current_profit = prices[i] - buy_price;
                profit = Math.max(current_profit, profit);
            }
        }

        return profit;
    }

}
