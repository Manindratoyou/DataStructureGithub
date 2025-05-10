package com.manindra.stack_leetcode;

public class MaximalRectangle { //solution 85

    public static void main(String[] args) {
        // Sample matrix
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        MaximalRectangle obj = new MaximalRectangle();
        int maxArea = obj.maximalRectangle(matrix);
        System.out.println("Maximal Rectangle Area: " + maxArea);
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int maxArea = 0;
        int[] height = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                height[j] = (matrix[i][j] == '1') ? height[j] + 1 : 0;
            }
            int area = largestArea(height);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    static int largestArea(int heights[]) {
        int n = heights.length;
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
