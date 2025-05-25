package com.manindra.dynamicProgramming_ds;

public class MaxSumNoConsecutive {

    public static void main (String[] args) {

        int n = 5, arr[]= {10, 20, 30, 40, 50};

        System.out.println(maxSum2(arr, n));

    }

    static int maxSum(int arr[], int n)
    {
        if(n==0)
            return arr[0];

        int prev_prev = arr[0];
        int prev = Math.max(arr[0], arr[1]);
        int res = prev;

        for(int i=3; i<=n; i++)
        {
            res = Math.max(prev, prev_prev + arr[i-1]);

            prev_prev = prev;

            prev = res;
        }

        return res;
    }

    static int maxSum2(int arr[], int n)
    {
        if(n==0)
            return arr[0];

        int dp[] = new int[n+1];

        dp[1] = arr[0];
        dp[2] = Math.max(arr[0], arr[1]);

        for(int i=3; i<=n; i++)
        {
            dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i-1]);
        }

        return dp[n];
    }
}
