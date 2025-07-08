package com.manindra.matrix_leetcode;

//Row-wise and Column-wise Sorted Matrix
public class SearchSortedMatrix { //LeetCode 240

    public static void main(String[] args) {
        SearchSortedMatrix searcher = new SearchSortedMatrix();

        int[][] matrix = {
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}
        };

        int target = 5;
        System.out.println("Found target? " + searcher.searchSortedMatrix(matrix, target)); // true

        target = 20;
        System.out.println("Found target? " + searcher.searchSortedMatrix(matrix, target)); // false
    }

    //Time Complexity: O(m + n)
    //Space Complexity: O(1)
    public boolean searchSortedMatrix(int[][] matrix, int target) {
        int row = 0, col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] > target)
                col--;
            else
                row++;
        }
        return false;
    }
}
