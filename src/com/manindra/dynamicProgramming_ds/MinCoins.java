package com.manindra.dynamicProgramming_ds;

public class MinCoins {

    public static void main(String[] args) {
        int arr[] = {3, 4, 1}, val = 5;
        int arr1[] = {25, 10, 5}, val1 = 30; //op ->  2


        System.out.println(minCoins(arr, arr.length, val));
        System.out.println(minCoins(arr1, arr.length, val1));


    }

    static int minCoinsRecursion(int arr[], int n, int value) {

        if (value == 0)
            return 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] <= value) {
                int sub_res = minCoinsRecursion(arr, n, value - arr[i]);
                if (sub_res != Integer.MAX_VALUE) {
                    result = Math.min(result, sub_res + 1);
                }
            }
        }
        return result;

    }

    static int minCoins(int arr[], int n, int value) {

        int dp[] = new int[value + 1];


        dp[0] = 0;


        for (int i = 1; i <= value; i++)
            dp[i] = Integer.MAX_VALUE;


        for (int i = 1; i <= value; i++) {

            for (int j = 0; j < n; j++)
                if (arr[j] <= i) {
                    int sub_res = dp[i - arr[j]];
                    if (sub_res != Integer.MAX_VALUE
                            && sub_res + 1 < dp[i])
                        dp[i] = sub_res + 1;


                }

        }
        return dp[value];

    }
}
