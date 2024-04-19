package com.manindra.stack_ds;

import java.util.Stack;

public class PreviousGreaterElement {

    public static void main(String[] args) {

        int[] arr = {15, 10, 18, 12, 4, 6, 2, 8};
        //printPreviousGreaterElement(arr);
        printPreviousGreaterElementUsingStack(arr);
    }

    static void printPreviousGreaterElement(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            boolean found = false;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    System.out.print(arr[j] + " ");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.print(-1 + " ");
            }
        }
    }

    static void printPreviousGreaterElementUsingStack(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        stack.add(arr[0]);

        for (int i = 0; i < arr.length; i++) {
            while (stack.isEmpty() == false && stack.peek() <= arr[i]) {
                stack.pop();
            }
            int previousGreater = stack.isEmpty() ? -1 : stack.peek();
            System.out.print(previousGreater + " ");
            stack.add(arr[i]);
        }
    }
}