package com.manindra.matrix;

//Unsorted Matrix (Brute-force Search)
public class SearchUnsortedMatrix {

    public static void main(String[] args) {
        SearchUnsortedMatrix searcher = new SearchUnsortedMatrix();

        int[][] matrix = {
                {3, 5, 7},
                {10, 12, 14},
                {18, 20, 25}
        };

        int target = 14;
        System.out.println("Found target? " + searcher.searchUnsortedMatrix(matrix, target)); // true

        target = 9;
        System.out.println("Found target? " + searcher.searchUnsortedMatrix(matrix, target)); // false
    }

    //Time Complexity: O(m × n)
    //Space Complexity: O(1)
    public boolean searchUnsortedMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            for (int num : row) {
                if (num == target)
                    return true;
            }
        }
        return false;
    }
}
