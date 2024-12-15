package com.manindra.hackerrank;

import java.util.*;

public class DesignerPDFViewerTestList {

    public static void main(String[] args) {
        // Test case 1
        List<Integer> heights1 = Arrays.asList(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);
        String word1 = "zaba";
        System.out.println("Test Case 1: " + designerPdfViewer(heights1, word1)); // Expected: 28

        // Test case 2
        List<Integer> heights2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5);
        String word2 = "hackerrank";
        System.out.println("Test Case 2: " + designerPdfViewer(heights2, word2)); // Expected: 56

        // Test case 3
        List<Integer> heights3 = Arrays.asList(6, 5, 4, 3, 2, 1, 7, 5, 4, 3, 2, 1, 7, 5, 4, 3, 2, 1, 7, 5, 4, 3, 2, 1, 7, 5);
        String word3 = "designer";
        System.out.println("Test Case 3: " + designerPdfViewer(heights3, word3)); // Expected: 56

        // Test case 4
        List<Integer> heights4 = Arrays.asList(7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7);
        String word4 = "aaa";
        System.out.println("Test Case 4: " + designerPdfViewer(heights4, word4)); // Expected: 21

        // Test case 5
        List<Integer> heights5 = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        String word5 = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("Test Case 5: " + designerPdfViewer(heights5, word5)); // Expected: 26
    }

    public static int designerPdfViewer(List<Integer> h, String word) {
        int maxHeight = 0;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            maxHeight = Math.max(maxHeight, h.get(index));
        }
        return maxHeight * word.length();
    }

    public static int designerPdfViewerSolutionTwo(List<Integer> h, String word) {
        int maxHeight = 0;
        for (int i = 0; i < word.length(); i++) {
            int ascii = word.charAt(i);
            int val = ascii - 97;
            if (h.get(val) > maxHeight)
                maxHeight = h.get(val);
        }
        return maxHeight;
    }

}

