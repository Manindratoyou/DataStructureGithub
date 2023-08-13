package com.manindra.matrix;

import java.util.Arrays;

public class SearchInMatrix {

    static int R = 4, C = 4;

    public static void main(String[] args) {
        int key = 29;
        int[][] mat = {{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}};
        Arrays.stream(mat).forEach(row -> {
            Arrays.stream(row).forEach(element ->
                    System.out.print(element + " "));
            System.out.println();
        });
        System.out.println("======");
        searchSolOne(mat, key);
        searchSolTwo(mat, key);
    }

    static void searchSolOne(int[][] mat, int key) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (mat[i][j] == key) {
                    System.out.println("Fount At : " + i + " " + j);
                    return;
                }
            }
        }
        System.out.println("Not Found");
    }
    static void searchSolTwo(int[][] mat, int key) {

        int i=0,j=C-1;
        while (i<R && j>=0){
            if (mat[i][j]==key){
                System.out.println("Fount At : " + i + " " + j);
                return;
            } else if (mat[i][j]>key) {
                j--;
            }else {
                i++;
            }
        }
        System.out.println("Not Found");
    }
}
