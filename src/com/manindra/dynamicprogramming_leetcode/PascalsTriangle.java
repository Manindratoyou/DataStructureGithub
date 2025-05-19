package com.manindra.dynamicprogramming_leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle { //solution 118

    public static void main(String[] args) {
        PascalsTriangle obj = new PascalsTriangle();
        int numRows = 6;
        List<List<Integer>> result = obj.generate(numRows);

        System.out.println("Pascal's Triangle (DP) with " + numRows + " rows:");
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> dp = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 0));
            row.set(0, 1);             // first element is always 1
            row.set(i, 1);             // last element is always 1

            // Fill the rest using previously computed row (i-1)
            for (int j = 1; j < i; j++) {
                int val = dp.get(i - 1).get(j - 1) + dp.get(i - 1).get(j);
                row.set(j, val);
            }

            dp.add(row);
        }

        return dp;
    }

    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                // First and last elements in a row are always 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // Sum of the two numbers directly above
                    int val = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                    row.add(val);
                }
            }

            triangle.add(row);
        }

        return triangle;
    }
}
