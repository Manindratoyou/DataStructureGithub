package com.manindra.hackerrank_2;

import java.util.*;

public class GridChallenge {

    public static String gridChallenge(List<String> grid) {
        // Step 1: Sort each row
        for (int i = 0; i < grid.size(); i++) {
            char[] chars = grid.get(i).toCharArray();
            Arrays.sort(chars);
            grid.set(i, new String(chars));
        }

        // Step 2: Check if columns are sorted
        int n = grid.size();
        int m = grid.get(0).length();

        for (int col = 0; col < m; col++) {
            for (int row = 1; row < n; row++) {
                if (grid.get(row).charAt(col) < grid.get(row - 1).charAt(col)) {
                    return "NO";
                }
            }
        }

        return "YES";
    }

    public static void main(String[] args) {
        List<String> grid1 = Arrays.asList("ebacd", "fghij", "olmkn", "trpqs", "xywuv");
        System.out.println(gridChallenge(grid1)); // YES

        List<String> grid2 = Arrays.asList("zyx", "wvu", "tsr");
        System.out.println(gridChallenge(grid2)); // NO

        List<String> grid3 = Arrays.asList("abc", "def", "ghi");
        System.out.println(gridChallenge(grid3)); // YES
    }
}

