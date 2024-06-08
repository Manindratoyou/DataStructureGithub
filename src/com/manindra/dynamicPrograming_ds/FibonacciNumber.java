package com.manindra.dynamicPrograming_ds;

import java.util.Arrays;

public class FibonacciNumber {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(fibonacciNumberWithoutMemoization(n));

        // Memoization example
        Arrays.fill(memo, -1);
        System.out.println(fibonacciNumberWithMemoization(n));
    }

    static int[] memo = new int[100]; // Increase the size of memoization array

    // Time Complexity: O(2^n), Auxiliary Space: O(n)
    static int fibonacciNumberWithoutMemoization(int n) {
        if (n == 0 || n == 1)
            return n;
        else
            return fibonacciNumberWithoutMemoization(n - 1) + fibonacciNumberWithoutMemoization(n - 2);
    }

    // Time Complexity: O(n), Auxiliary Space: O(n)
    static int fibonacciNumberWithMemoization(int n) {
        if (memo[n] == -1) {
            int result;
            if (n == 0 || n == 1)
                result = n;
            else {
                result = fibonacciNumberWithMemoization(n - 1) + fibonacciNumberWithMemoization(n - 2);
                memo[n] = result; // Store the calculated result in memoization array
            }
            return result; // Return the calculated result
        } else {
            return memo[n]; // If already calculated, return from memoization array
        }
    }

}
