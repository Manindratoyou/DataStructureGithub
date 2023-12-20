package com.manindra.leetcode;

import java.util.Stack;

public class OnlineStockSpan {

    public static void main(String[] args) {
        OnlineStockSpan stockSpanner = new OnlineStockSpan();

        System.out.println(stockSpanner.next(100));  // Output: 1
        System.out.println(stockSpanner.next(80));   // Output: 1
        System.out.println(stockSpanner.next(60));   // Output: 1
        System.out.println(stockSpanner.next(70));   // Output: 2
        System.out.println(stockSpanner.next(60));   // Output: 1
        System.out.println(stockSpanner.next(75));   // Output: 4
        System.out.println(stockSpanner.next(85));   // Output: 6
    }

   /* List<Integer> list;

    public OnlineStockSpan() {
        this.list = new ArrayList<>();
    }

    public int next(int price) {
        list.add(price);
        int count = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) > price)
                break;
            count++;
        }
        return count;
    }*/

    private Stack<int[]> stockPrices;

    public OnlineStockSpan() {
        stockPrices = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        while (!stockPrices.isEmpty() && price >= stockPrices.peek()[0]) {
            span += stockPrices.pop()[1];
        }

        stockPrices.push(new int[]{price, span});

        return span;
    }


    public int[] calculateSpans(int[] prices) {

        int[] spans = new int[prices.length];
        spans[0] = 1; // Span of first element is always 1

        Stack<Integer> indexStack = new Stack<>();

        // Push the index of first element
        indexStack.push(0);

        for (int i = 1; i < prices.length; i++) {
            while (!indexStack.isEmpty()
                    && prices[indexStack.peek()] < prices[i])
                indexStack.pop();

            // If index stack is empty, the price at index 'i'
            // is greater than all previous values
            if (indexStack.isEmpty())
                spans[i] = i + 1;
            else
                spans[i] = i - indexStack.peek();

            indexStack.push(i);
        }

        return spans;
    }

}
