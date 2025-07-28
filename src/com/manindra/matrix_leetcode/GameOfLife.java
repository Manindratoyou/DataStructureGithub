package com.manindra.matrix_leetcode;

public class GameOfLife { //solution 289

    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };

        System.out.println("Original Board:");
        printBoard(board);

        gameOfLife(board);

        System.out.println("\nNext Generation:");
        printBoard(board);
    }

    public static void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;

        // 0 -> 0 : dead remains dead
        // 1 -> 1 : live remains live
        // 1 -> 0 : live becomes dead (mark as 2)
        // 0 -> 1 : dead becomes live (mark as 3)

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countLive(board, i, j);

                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = 2; // live to dead
                    }
                } else {
                    if (liveNeighbors == 3) {
                        board[i][j] = 3; // dead to live
                    }
                }
            }
        }

        // Second pass: finalize new state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) board[i][j] = 0;
                if (board[i][j] == 3) board[i][j] = 1;
            }
        }
    }

    private static int countLive(int[][] board, int row, int col) {
        int count = 0;
        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                { 0, -1},          { 0, 1},
                { 1, -1}, { 1, 0}, { 1, 1}
        };

        for (int[] d : directions) {
            int r = row + d[0];
            int c = col + d[1];

            if (r >= 0 && r < board.length && c >= 0 && c < board[0].length) {
                // Consider 1 and 2 as originally live
                if (board[r][c] == 1 || board[r][c] == 2) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

}

