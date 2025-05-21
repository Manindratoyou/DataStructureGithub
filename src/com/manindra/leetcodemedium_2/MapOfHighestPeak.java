package com.manindra.leetcodemedium_2;

import java.util.*;

public class MapOfHighestPeak { //solution 1765

    public static void main(String[] args) {
        MapOfHighestPeak solver = new MapOfHighestPeak();

        int[][] isWater1 = {
                {0,1},
                {0,0}
        };

        int[][] result1 = solver.highestPeak(isWater1);
        System.out.println("Test Case 1:");
        printMatrix(result1);

        int[][] isWater2 = {
                {0,0,1},
                {1,0,0},
                {0,0,0}
        };

        int[][] result2 = solver.highestPeak(isWater2);
        System.out.println("Test Case 2:");
        printMatrix(result2);
    }

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] result = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Add all water cells to queue and mark height 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    result[i][j] = 0;
                }
            }
        }

        // Directions: up, down, left, right
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // Step 2: BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny]) {
                    result[nx][ny] = result[x][y] + 1;
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }


}

