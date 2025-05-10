package com.manindra.stack_ds;

import java.util.Stack;

public class StockSpan {

    public static void main(String[] args) {

        int[] arr = {13, 15, 12, 14, 16, 8, 6, 4, 10, 30};
        int[] arr1 = {30, 20, 25, 28, 27, 29};
        int[] arr2 = {10,20,30,40};
        printSpanNaive(arr, arr.length);
        System.out.println();
        printSpanEfficient(arr1, arr1.length);
        printSpanEfficient(arr2, arr2.length);
    }

    //solution 1 : Naive
    static void printSpanNaive(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int span = 1; // Initialize span for the current day
            int j = i - 1;
            while (j >= 0 && arr[j] <= arr[i]) {
                span++;
                j--;
            }
            System.out.print(span + " ");
        }
    }

    //solution 2 : efficient
    static void printSpanEfficient(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        System.out.print(1 + " ");
        for (int i = 1; i < n; i++) {
            while (stack.isEmpty() == false && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            int span = stack.isEmpty() ? i + 1 : i - stack.peek();
            System.out.print(span + " ");
            stack.push(i);
        }
    }
}
