package com.manindra.matrix_leetcode;

import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix { //solution 378

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
        System.out.println("Kth Smallest Element: " + kthSmallest(matrix, k)); // Output: 13
    }

    static class Cell {
        int value, row, col;

        Cell(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);

        // Push the first element of each row into the heap
        for (int i = 0; i < Math.min(n, k); i++) {
            minHeap.offer(new Cell(matrix[i][0], i, 0));
        }

        // Pop the smallest k-1 elements from the heap
        for (int i = 0; i < k - 1; i++) {
            Cell curr = minHeap.poll();
            if (curr.col + 1 < n) {
                minHeap.offer(new Cell(matrix[curr.row][curr.col + 1], curr.row, curr.col + 1));
            }
        }

        return minHeap.poll().value;
    }

    public static int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n - 1][n - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessEqual(matrix, mid);

            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private static int countLessEqual(int[][] matrix, int target) {
        int n = matrix.length;
        int row = n - 1, col = 0;
        int count = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= target) {
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }

        return count;
    }
}

