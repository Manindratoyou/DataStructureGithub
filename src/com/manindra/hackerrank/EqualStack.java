package com.manindra.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class EqualStack {

    public static void main(String[] args) {

        List<Integer> h1 = new ArrayList<>(Arrays.asList(3, 2, 1, 1, 1));
        List<Integer> h2 = new ArrayList<>(Arrays.asList(4, 3, 2));
        List<Integer> h3 = new ArrayList<>(Arrays.asList(1, 1, 4, 1));
        int result = equalStacks(h1, h2, h3);
        System.out.println("Maximum height all stacks can be made equal : " + result);
    }

    static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {

        int maxHeight = 0;

        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> st3 = new Stack<>();

        fillStack(st1, h1);
        fillStack(st2, h2);
        fillStack(st3, h3);

        while (!st1.isEmpty() && !st2.isEmpty() && !st3.isEmpty()) {
            int stack1Height = st1.peek();
            int stack2Height = st2.peek();
            int stack3Height = st3.peek();

            if (stack1Height == stack2Height && stack2Height == stack3Height) {
                maxHeight = stack1Height;
                break;
            }

            if (stack1Height >= stack2Height && stack1Height >= stack3Height) {
                st1.pop();
            } else if (stack2Height >= stack1Height && stack2Height >= stack3Height) {
                st2.pop();
            } else {
                st3.pop();
            }
        }

        return maxHeight;
    }


    static void fillStack(Stack<Integer> stack, List<Integer> heights) {
        int totalHeight = 0;
        for (int i = heights.size() - 1; i >= 0; i--) {
            totalHeight += heights.get(i);
            stack.push(totalHeight);
        }
    }
}
