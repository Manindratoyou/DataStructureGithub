package com.manindra.hackerrank;

public class DesignerPDFViewerTestArray {

    public static void main(String[] args) {
        // Test cases
        int[] heights1 = {1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        String word1 = "zaba";
        System.out.println("Test Case 1: " + calculateArea(heights1, word1)); // Expected: 28

        int[] heights2 = {1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5};
        String word2 = "hackerrank";
        System.out.println("Test Case 2: " + calculateArea(heights2, word2)); // Expected: 56

        int[] heights3 = {6, 5, 4, 3, 2, 1, 7, 5, 4, 3, 2, 1, 7, 5, 4, 3, 2, 1, 7, 5, 4, 3, 2, 1, 7, 5};
        String word3 = "designer";
        System.out.println("Test Case 3: " + calculateArea(heights3, word3)); // Expected: 56

        int[] heights4 = {7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
        String word4 = "aaa";
        System.out.println("Test Case 4: " + calculateArea(heights4, word4)); // Expected: 21

        int[] heights5 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        String word5 = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("Test Case 5: " + calculateArea(heights5, word5)); // Expected: 26
    }

    // Method to calculate the highlighted area
    public static int calculateArea(int[] heights, String word) {
        int maxHeight = 0;

        // Find the maximum height of the letters in the word
        for (char c : word.toCharArray()) {
            int height = heights[c - 'a'];
            maxHeight = Math.max(maxHeight, height);
        }

        // Calculate and return the area of the rectangle
        return maxHeight * word.length();
    }

}

