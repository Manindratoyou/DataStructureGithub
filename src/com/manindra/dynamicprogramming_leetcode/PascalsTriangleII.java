package com.manindra.dynamicprogramming_leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII { //solution 119

    public static void main(String[] args) {
        PascalsTriangleII pt = new PascalsTriangleII();
        int rowIndex = 4;

        List<Integer> row = pt.getRow(rowIndex);
        System.out.println("Row " + rowIndex + ": " + row);
    }

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1); // first and last elements are 1
                } else {
                    // DP relation: value = sum of the two values above it
                    int val = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                    row.add(val);
                }
            }

            triangle.add(row);
        }

        return triangle.get(rowIndex);
    }
    public List<Integer> getRow2(int rowIndex) { //optimize
        List<Integer> row = new ArrayList<>();
        row.add(1);  // First row is always [1]

        for (int i = 1; i <= rowIndex; i++) {
            // Traverse the list in reverse to update in-place
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);  // Add 1 at the end for new row
        }

        return row;
    }
}
