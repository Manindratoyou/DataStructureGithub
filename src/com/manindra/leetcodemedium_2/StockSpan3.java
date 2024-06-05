package com.manindra.leetcodemedium_2;

import java.util.Stack;

public class StockSpan3 {

    public static void main(String[] args) {

        StockSpan3 stockSpan = new StockSpan3();
        System.out.println(stockSpan.next(100));
        System.out.println(stockSpan.next(80));
        System.out.println(stockSpan.next(60));
        System.out.println(stockSpan.next(70));
        System.out.println(stockSpan.next(60));
        System.out.println(stockSpan.next(75));
        System.out.println(stockSpan.next(85));
    }

    private Stack<int[]> stack;

    public StockSpan3() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        //pop elements from the stack while the current price is greater than or equal to the price
        //at the top of the stack

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        //push the current price and its span onto the stack
        stack.push(new int[]{price, span});

        return span;
    }

}
