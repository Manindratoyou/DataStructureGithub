package com.manindra.stack_ds;

import java.util.Stack;

public class PreviousGreaterElement {

    public static void main(String[] args) {

        int[] arr = {15, 10, 18, 12, 4, 6, 2, 8};
        //printPreviousGreaterElement(arr);
        printPreviousGreaterElementUsingStack(arr);
        System.out.println();
        printPreviousGreaterElementSolutionThree(arr);
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

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            int previousGreater = stack.isEmpty() ? -1 : stack.peek();
            System.out.print(previousGreater + " ");
            stack.push(arr[i]);
        }
    }

    static void printPreviousGreaterElementSolutionThree(int[] arr) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            //pop element from stack while stack is not empty and top of stack is smaller than the arr[i]
            while (stack.isEmpty() == false && arr[i] >= stack.peek())
                stack.pop();

            //if stack=empty=no previous greater element is present else top of stack is previous greater
            int result = stack.isEmpty() ? -1 : stack.peek();
            System.out.print(result + " ");
            stack.push(arr[i]);
        }
    }
}