package com.manindra.matrix;

//Fully Sorted Matrix
public class SearchFullySortedMatrix { //LeetCode 74

    public static void main(String[] args) {
        SearchFullySortedMatrix searcher = new SearchFullySortedMatrix();

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };

        int target = 3;
        System.out.println("Found target? " + searcher.searchFullySortedMatrix(matrix, target)); // true

        target = 13;
        System.out.println("Found target? " + searcher.searchFullySortedMatrix(matrix, target)); // false
    }

    //Time Complexity: O(log(m × n))
    //Space Complexity: O(1)
    public boolean searchFullySortedMatrix(int[][] matrix, int target) {

        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = matrix[mid / n][mid % n];

            if (midVal == target)
                return true;
            else if (midVal < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }
}
