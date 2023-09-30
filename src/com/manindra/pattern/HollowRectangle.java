package com.manindra.pattern;

public class HollowRectangle {

    public static void main(String[] args) {
        int rows = 4; // Number of rows
        int columns = 6; // Number of columns

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                if (i == 1 || i == rows || j == 1 || j == columns) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}

