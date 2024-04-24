package com.manindra.stack_ds;

import java.util.Stack;

public class LargestRectangularArea {

    public static void main(String[] args) {

        int [] arr={6,2,5,4,1,5,6};
        System.out.println(getMaxAreaSolutionOne(arr));
        System.out.println(getMaxAreaSolutionTwo(arr));
        System.out.println(getMaxAreaSolutionThree(arr));
        System.out.println(largestRectangleArea(arr));
        System.out.println(largestarea(arr));
    }

    static int getMaxAreaSolutionOne(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int currentHeight = heights[i];
            int width = 1;
            // Extend to the left
            for (int j = i - 1; j >= 0 && heights[j] >= currentHeight; j--) {
                width++;
            }
            // Extend to the right
            for (int j = i + 1; j < heights.length && heights[j] >= currentHeight; j++) {
                width++;
            }
            int area = currentHeight * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }


    static int getMaxAreaSolutionTwo(int[] heights) {
        int maxArea = 0;
        int[] pse = new int[heights.length];
        int[] nse = new int[heights.length];
        Stack<Integer> stack = new Stack<>();

        // Finding Previous Smaller Element (PSE)
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();

        // Finding Next Smaller Element (NSE)
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? heights.length : stack.peek();
            stack.push(i);
        }

        // Calculating maximum area
        for (int i = 0; i < heights.length; i++) {
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }


    static int getMaxAreaSolutionThree(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int top = stack.pop();
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = heights[top] * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
            int width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;
            int area = heights[top] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    static int largestRectangleArea(int[] heights) {
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

    static int largestarea(int heights[]) {
        int n=heights.length;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;
    }


}
