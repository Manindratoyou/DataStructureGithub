package com.manindra.leetcodeMedium;

public class Solution74 {

    public static void main(String[] args)  {

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target=30;
        System.out.println(searchMatrix(matrix,target));
    }


    /**
     * Searches for the target value in a 2D matrix where each row is sorted,
     * and the first element of each row is greater than the last element of the previous row.
     *
     * @param matrix The input 2D matrix.
     * @param target The target value to search for.
     * @return True if the target is found, false otherwise.
     */
    static boolean searchMatrix(int[][] matrix, int target) {
        // Step 1: Find the potential row where the target might exist.
        int rowIdx = searchPotentialRow(matrix, target);

        // Step 2: If a potential row is found, perform binary search within that row.
        if (rowIdx != -1)
            return binarySearchOverRow(rowIdx, matrix, target);

        // If the potential row is not found, the target is not present in the matrix.
        return false;
    }

    /**
     * Searches for the potential row where the target might exist.
     *
     * @param matrix The input 2D matrix.
     * @param target The target value to search for.
     * @return The index of the potential row where the target might exist, or -1 if not found.
     */
    static int searchPotentialRow(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;
        int idx = matrix[0].length - 1;

        // Perform binary search to find the potential row.
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (matrix[mid][0] <= target && target <= matrix[mid][idx]) {
                // Target might exist in this row, return the potential row index.
                return mid;
            } else if (matrix[mid][0] < target) {
                // Target might exist in a row after mid, narrow the search to the right half.
                low = mid + 1;
            } else if (matrix[mid][0] > target) {
                // Target might exist in a row before mid, narrow the search to the left half.
                high = mid - 1;
            }
        }

        // If no potential row is found, return -1.
        return -1;
    }

    /**
     * Performs binary search within a specific row to find the target value.
     *
     * @param rowIdx The index of the row where binary search needs to be performed.
     * @param matrix The input 2D matrix.
     * @param target The target value to search for.
     * @return True if the target is found in the specified row, false otherwise.
     */
    static boolean binarySearchOverRow(int rowIdx, int[][] matrix, int target) {
        int low = 0;
        int high = matrix[rowIdx].length - 1;

        // Perform binary search within the specified row.
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (matrix[rowIdx][mid] == target) {
                // Target is found in the row, return true.
                return true;
            } else if (matrix[rowIdx][mid] > target) {
                // Target might exist in the left half of the row.
                high = mid - 1;
            } else {
                // Target might exist in the right half of the row.
                low = mid + 1;
            }
        }

        // If the target is not found in the row, return false.
        return false;
    }

}
