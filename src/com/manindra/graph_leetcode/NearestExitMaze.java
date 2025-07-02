package com.manindra.graph_leetcode;

import java.util.*;

public class NearestExitMaze { //solution 1926

    public static void main(String[] args) {
        NearestExitMaze solver = new NearestExitMaze();
        char[][] maze = {
                {'+','+','.','+'},
                {'.','.','.','+'},
                {'+','+','+','.'}
        };
        int[] entrance = {1, 2};
        System.out.println(solver.nearestExit(maze, entrance)); // Output: 1
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]] = '+'; // mark entrance as visited

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0], col = curr[1], steps = curr[2];

            for (int[] dir : directions) {
                int r = row + dir[0], c = col + dir[1];

                if (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] == '.') {
                    // Check if it's a boundary and not entrance
                    if (r == 0 || r == m - 1 || c == 0 || c == n - 1) {
                        return steps + 1;
                    }

                    maze[r][c] = '+'; // mark visited
                    queue.offer(new int[]{r, c, steps + 1});
                }
            }
        }

        return -1; // no exit found
    }


}

