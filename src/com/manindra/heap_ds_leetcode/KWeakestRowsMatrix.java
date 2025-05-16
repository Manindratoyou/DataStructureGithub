package com.manindra.heap_ds_leetcode;

import java.util.*;

public class KWeakestRowsMatrix { //solution 1337

    public static int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
        );

        for (int i = 0; i < mat.length; i++) {
            int soldiers = countSoldiers(mat[i]);
            pq.offer(new int[]{soldiers, i});
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[1];
        }
        return result;
    }

    // Count soldiers using binary search (since 1s always come before 0s)
    private static int countSoldiers(int[] row) {
        int low = 0, high = row.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (row[mid] == 1) low = mid + 1;
            else high = mid;
        }
        return low;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}
        };
        int k = 3;

        int[] result = kWeakestRows(mat, k);
        System.out.println("K weakest rows: " + Arrays.toString(result));
    }
}

