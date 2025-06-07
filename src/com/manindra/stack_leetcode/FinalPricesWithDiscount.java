package com.manindra.stack_leetcode;

import java.util.Arrays;
import java.util.Stack;

public class FinalPricesWithDiscount { //solution 1475


    public static void main(String[] args) {
        // Test Case 1
        int[] prices1 = {8, 4, 6, 2, 3};
        System.out.println("Test Case 1:");
        System.out.println("Original Prices: " + Arrays.toString(prices1));
        System.out.println("Final Prices:    " + Arrays.toString(finalPrices(Arrays.copyOf(prices1, prices1.length))));
        System.out.println();

        // Test Case 2
        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println("Test Case 2:");
        System.out.println("Original Prices: " + Arrays.toString(prices2));
        System.out.println("Final Prices:    " + Arrays.toString(finalPrices(Arrays.copyOf(prices2, prices2.length))));
        System.out.println();

        // Test Case 3
        int[] prices3 = {10, 1, 1, 6};
        System.out.println("Test Case 3:");
        System.out.println("Original Prices: " + Arrays.toString(prices3));
        System.out.println("Final Prices:    " + Arrays.toString(finalPrices(Arrays.copyOf(prices3, prices3.length))));
        System.out.println();

        // Test Case 4
        int[] prices4 = {5, 5, 5, 5};
        System.out.println("Test Case 4:");
        System.out.println("Original Prices: " + Arrays.toString(prices4));
        System.out.println("Final Prices:    " + Arrays.toString(finalPrices(Arrays.copyOf(prices4, prices4.length))));
        System.out.println();


    }

    public static int[] finalPrices(int[] prices) {
        int n = prices.length;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int idx = stack.pop();
                prices[idx] -= prices[i];
            }
            stack.push(i);
        }

        return prices;
    }

    public static int[] finalPricesBruteForce(int[] prices) {
        int n = prices.length;
        int[] result = Arrays.copyOf(prices, n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    result[i] -= prices[j];
                    break;
                }
            }
        }

        return result;
    }

}

