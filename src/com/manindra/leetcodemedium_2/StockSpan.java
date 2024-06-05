package com.manindra.leetcodemedium_2;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan { //leet code 901

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


}
