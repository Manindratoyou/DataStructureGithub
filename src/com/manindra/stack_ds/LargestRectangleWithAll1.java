package com.manindra.stack_ds;

import java.util.List;

import java.util.*;

public class LargestRectangleWithAll1 {

    public static void main(String[] args) {
        // Sample matrix
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(1, 0, 1, 0, 0));
        matrix.add(Arrays.asList(1, 0, 1, 1, 1));
        matrix.add(Arrays.asList(1, 1, 1, 1, 1));
        matrix.add(Arrays.asList(1, 0, 0, 1, 0));
        int n = matrix.size();
        int m = matrix.get(0).size();

        LargestRectangleWithAll1 obj = new LargestRectangleWithAll1();
        int maxArea = obj.maximalRectangle(matrix, n, m);
        System.out.println("Maximal Rectangle Area: " + maxArea);
    }

    public int maximalRectangle(List<List<Integer>> matrix, int n, int m) {
        int maxArea = 0;
        int[] height = new int[m]; // Array to store heights

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix.get(i).get(j) == 1)
                    height[j]++;
                else
                    height[j] = 0;
            }
            int area = getMaxAreaSolutionOne(height);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
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
}
