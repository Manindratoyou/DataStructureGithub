package com.manindra.stack_leetcode;

import java.util.Stack;

public class LargestRectangleHistogram { //solution 84

    public static void main(String[] args) {
        LargestRectangleHistogram obj = new LargestRectangleHistogram();

        int[] heights1 = {2, 1, 5, 6, 2, 3};
        System.out.println(obj.largestRectangleArea(heights1)); // Output: 10

        int[] heights2 = {2, 4};
        System.out.println(obj.largestRectangleArea(heights2)); // Output: 4

        int[] heights3 = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(obj.largestRectangleArea(heights3)); // Output: 12
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int leftSmall[] = new int[n];
        int rightSmall[] = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) leftSmall[i] = 0;
            else leftSmall[i] = st.peek() + 1;
            st.push(i);
        }

        // clear the stack to be re-used
        while (!st.isEmpty()) st.pop();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) rightSmall[i] = n - 1;
            else rightSmall[i] = st.peek() - 1;

            st.push(i);
        }

        int maxA = 0;
        for (int i = 0; i < n; i++) {
            maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
        }
        return maxA;
    }

}
