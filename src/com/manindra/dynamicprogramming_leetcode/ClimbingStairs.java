package com.manindra.dynamicprogramming_leetcode;

public class ClimbingStairs { //Solution 70

    public static void main(String[] args) {

        int n=7;
        System.out.println(climbStairs(n));
    }

    static int climbStairs(int n){
        if (n==1) return 1;

        int [] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;

        for (int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];
    }
}
