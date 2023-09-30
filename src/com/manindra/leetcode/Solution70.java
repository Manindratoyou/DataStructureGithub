package com.manindra.leetcode;

public class Solution70 { //Climbing Stairs

    public static void main(String[] args) {

        Solution70 solution70=new Solution70();
        //test cases
        int [] inputs={1,2,3,4,5,6};
        for(int n: inputs){
            //int ways= solution70.climbStairs(n);
            int ways= solution70.climbStairsSolTwo(n);
            System.out.println("Number of distinct way to climb "+ n+ " stairs "+ ways);
        }
    }

    public int climbStairs(int n){
        if (n<=2) return n;

        int [] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;

        for (int i=3;i<=n;i++)
            dp[i]=dp[i-1]+dp[i-2];

        return dp[n];
    }
    /*
    this solution has a time complexity of 0(n) and doesn't require extra space compared to the dynamic programing solution.
     */

    public int climbStairsSolTwo(int n){
        if (n<=2) return n;

        int prev=1;//Number of ways to reach the first step
        int current=2;//number of ways to reach the second step

        for (int i=3;i<=n;i++){
            int next=prev+current;
            prev=current;
            current=next;
        }
        return current;
    }
}
