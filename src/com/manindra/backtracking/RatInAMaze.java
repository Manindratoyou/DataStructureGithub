package com.manindra.backtracking;

//only two moves allowed from (i,j)
// 1.(i+1,j)   2.(i+j+1)
public class RatInAMaze {

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        int size = maze.length;

        boolean result = solveMaze(maze, size);
        System.out.println(result);
    }

    static boolean solveMaze(int[][] maze, int size) {
        int[][] solution = new int[size][size];
        if (!solveMazeUtil(maze, 0, 0, solution, size)) {
            System.out.println("Solution doesn't exist");
            return false;
        }
        printSolution(solution, size);
        return true;
    }

    static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] solution, int size) {
        if (x == size - 1 && y == size - 1 && maze[x][y] == 1) {
            solution[x][y] = 1;
            return true;
        }
        if (isSafe(maze, x, y, size)) {
            solution[x][y] = 1;

            if (solveMazeUtil(maze, x + 1, y, solution, size))
                return true;
            if (solveMazeUtil(maze, x, y + 1, solution, size))
                return true;

            solution[x][y] = 0;
        }
        return false;
    }

    static boolean isSafe(int[][] maze, int x, int y, int size) {
        return x >= 0 && y >= 0 && x < size && y < size && maze[x][y] == 1;
    }

    static void printSolution(int[][] solution, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(solution[i][j] + " ");
            }
            System.out.println();
        }
    }
}
