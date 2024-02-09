package com.manindra.mathematics;

public class Factor {

    public static void main(String[] args) {

        printAllFactors(24);
    }

    static void printAllFactors(int n) {
        if (n <= 0) {
            System.out.println("Invalid input");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}
