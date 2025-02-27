package com.manindra.matrix;

import java.util.Scanner;

public class IdentityMatrix {
    // Method to generate and print an identity matrix
    public static void generateIdentityMatrix(int n) {
        int[][] identity = new int[n][n];

        // Filling the diagonal with 1s
        for (int i = 0; i < n; i++) {
            identity[i][i] = 1;
        }

        // Printing the identity matrix
        System.out.println("Identity Matrix of size " + n + "x" + n + ":");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(identity[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the identity matrix (n): ");
        int n = scanner.nextInt();
        scanner.close();

        if (n <= 0) {
            System.out.println("Size must be a positive integer.");
        } else {
            generateIdentityMatrix(n);
        }
    }
}

