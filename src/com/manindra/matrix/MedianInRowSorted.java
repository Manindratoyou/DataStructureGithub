package com.manindra.matrix;

public class MedianInRowSorted {

    public static void main(String[] args) {
        int[][] mat = {{2, 4, 6, 8, 10}, {1, 3, 5, 7, 9}, {100, 200, 400, 500, 800}};
        int R = mat.length;
        int C = mat[0].length;
        System.out.println(matrixMedian(mat, R, C));
    }

    static int matrixMedian(int[][] mat, int R, int C) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < R; i++) {
            if (mat[i][0] < min)
                min = mat[i][0];
            if (mat[i][C - 1] > max)
                max = mat[i][C - 1];
        }

        while (min < max) {
            int mid = min + (max - min) / 2;
            int count = 0;
            for (int i = 0; i < R; i++) {
                count += upperBound(mat[i], mid);
            }
            if (count < (R * C + 1) / 2)
                min = mid + 1;
            else
                max = mid;
        }
        return min;
    }

    // Custom upperBound implementation
    static int upperBound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
