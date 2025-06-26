package com.manindra.stack_leetcode;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan { //solution 901

    public static void main(String[] args) {

        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] spans = calculateSpan(prices);
        System.out.println(Arrays.toString(spans));
    }

    static int[] calculateSpan(int[] prices) {

        int[] spans = new int[prices.length];
        spans[0] = 1;

        Stack<Integer> indexStack = new Stack();

        //push the index of first element
        indexStack.push(0);

        for (int i = 1; i < prices.length; i++) {
            while (!indexStack.isEmpty() && prices[indexStack.peek()] <= prices[i]) {
                indexStack.pop();
            }

            // if the stack is empty ,the price at index 'i' is greater than all the previous value
            if (indexStack.isEmpty()) {
                spans[i] = i + 1;
            } else {
                spans[i] = i - indexStack.peek();
            }

            indexStack.push(i);
        }
        return spans;

    }

    /*

    static int[] printSpan(int[] span) {
        int[] result = new int[span.length];
        result[0] = 1;
        for (int i = span.length - 1; i >= 0; i--) {

            for (int j = i - 1; j >= 0; j--) {

                if (span[j] > span[i]) {
                    result[i] = i - j;
                    System.out.println(i - j);
                    break;
                }
            }
        }
        return result;
    }
     */


}
