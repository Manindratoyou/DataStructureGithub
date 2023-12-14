package com.manindra.leetcode;

import java.util.Arrays;

/*
Input: accounts = [[1,5],[7,3],[3,5]]
Output: 10
Explanation:
1st customer has wealth = 6
2nd customer has wealth = 10
3rd customer has wealth = 8
The 2nd customer is the richest with a wealth of 10.
 */
public class Solution1672 { //Richest Customer Wealth

    public static void main(String[] args) {
        int[][] accounts = {
                {1, 2, 3},
                {3, 2, 1},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(maximumWealthSolutionOne(accounts));
        System.out.println(maximumWealthSolutionTwo(accounts));
    }

    //Time Complexity: O(m * n) where m is the number of customers and n is the number of accounts.
    //Auxiliary Space: O(1)
    static int maximumWealthSolutionOne(int[][] accounts) {
        int maxWealth = 0;

        for (int[] customerAccounts : accounts) {
            int currentWealth = 0;
            for (int accountBalance : customerAccounts) {
                currentWealth += accountBalance;
            }
            maxWealth = Math.max(maxWealth, currentWealth);
        }

        return maxWealth;
    }

    //Time Complexity: O(m * n) where m is the number of customers and n is the number of accounts.
    //Auxiliary Space: O(1)
    static int maximumWealthSolutionTwo(int[][] accounts) {
        return Arrays.stream(accounts)
                .mapToInt(customerAccounts -> Arrays.stream(customerAccounts).sum())
                .max()
                .orElse(0);
    }

    public int maximumWealth(int[][] accounts) { //Using Stream API with Parallelism
        return Arrays.stream(accounts)
                .parallel()
                .mapToInt(customerAccounts -> Arrays.stream(customerAccounts).sum())
                .max()
                .orElse(0);
    }

}
