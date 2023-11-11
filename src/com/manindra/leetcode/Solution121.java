package com.manindra.leetcode;

public class Solution121 { //best time to buy and sell stocks

    public static void main(String[] args) {

        int [] prices={7,1,5,3,6,4};
        System.out.println("Maximum Profit = " +maxProfit(prices));
        System.out.println("Maximum Profit = " +maxProfitSolutionTwo(prices));
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

}
