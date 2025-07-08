package com.manindra.stack_leetcode;

import java.util.Stack;

public class ValidateStackSequence { //solution 946

    public static void main(String[] args) {
        int[] pushed1 = {1,2,3,4,5};
        int[] popped1 = {4,5,3,2,1};
        System.out.println(validateStackSequences(pushed1, popped1)); // true

        int[] pushed2 = {1,2,3,4,5};
        int[] popped2 = {4,3,5,1,2};
        System.out.println(validateStackSequences(pushed2, popped2)); // false
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0; // Pointer to `popped`

        for (int num : pushed) {
            stack.push(num);

            // Pop from stack while top matches the `popped[j]`
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        // If stack is empty, it's a valid sequence
        return stack.isEmpty();
    }

    public static boolean validateStackSequences2(int[] pushed, int[] popped) {
        int n = pushed.length;
        int[] stack = new int[n];
        int top = -1; // simulate stack top
        int j = 0; // index for popped array

        for (int num : pushed) {
            stack[++top] = num; // push operation

            // simulate pop while top of stack matches popped[j]
            while (top >= 0 && stack[top] == popped[j]) {
                top--; // pop operation
                j++;
            }
        }

        return top == -1; // if stack is empty, sequence is valid
    }

}

