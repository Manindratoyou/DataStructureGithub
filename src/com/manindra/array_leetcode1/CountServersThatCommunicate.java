package com.manindra.array_leetcode1;

public class CountServersThatCommunicate {

    public static void main(String[] args) { //solution 1267

        int [] [] grid = {{1,0},{1,1}};
        //int [] [] grid = {{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};
        System.out.println(countServers(grid));

    }

    static int countServers(int[][] grid) {

        int rows = grid.length;
        int cols = rows == 0 ? 0 : grid[0].length;

        int[] rowCount = new int[rows];
        int[] colCount = new int[cols];

        int servers = 0;

        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                if (grid[row][col] == 1) {
                    ++rowCount[row];
                    ++colCount[col];
                }

        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                if (grid[row][col] == 1 && (rowCount[row] > 1 || colCount[col] > 1)) {
                    ++servers;
                }

        return servers;
    }
}
