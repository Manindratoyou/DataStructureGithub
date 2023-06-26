package com.manindra.util;

import java.util.Arrays;

/*
A cab service offers three types of passes. 1D, 7D, 30D. A T days pass can be used for a continuous
duration only. Consider the days of the year being labeled sequentially from 1 to 365. Travelling is
required only on some selected days of the year(input). Given the cost of different passes and the
days on which travel is required, Calculate the minimum amount using which we can travel on all these days.
Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11(2 + 7 + 2)
 */
public class CabService {

    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        int minimumAmount = minCost(days, costs);
        System.out.println("Minimum amount using which you can travel on all these days: " + minimumAmount);
    }

    public static int minCost(int[] days, int[] costs) {
        int[] dp = new int[366];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        boolean[] travelDays = new boolean[366];
        for (int day : days) {
            travelDays[day] = true;
        }

        for (int i = 1; i <= 365; i++) {
            if (!travelDays[i]) {
                dp[i] = dp[i - 1];
                continue;
            }

            dp[i] = Math.min(dp[i], dp[i - 1] + costs[0]); // 1-day pass

            if (i >= 7) {
                dp[i] = Math.min(dp[i], dp[i - 7] + costs[1]); // 7-day pass
            } else {
                dp[i] = Math.min(dp[i], costs[1]);
            }

            if (i >= 30) {
                dp[i] = Math.min(dp[i], dp[i - 30] + costs[2]); // 30-day pass
            } else {
                dp[i] = Math.min(dp[i], costs[2]);
            }
        }

        return dp[365];
    }

}