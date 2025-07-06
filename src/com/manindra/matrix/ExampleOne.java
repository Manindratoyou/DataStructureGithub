package com.manindra.matrix;

public class ExampleOne {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 8, 9}, {4, 5, 6}};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("==================");
        printMatrixIndex2();
    }

    public static void printMatrixIndex2() {
        int rows = 4;
        int cols = 4;

        for (int i = 0; i < rows; i++) {
            // Inner loop for columns
            // The loop will run from 0 to cols-1 (i.e., 0, 1, 2, 3 for 4 columns)
            for (int j = 0; j < cols; j++) {
                System.out.print(i + "," + j + "  ");
            }
            System.out.println();
        }
    }


}
