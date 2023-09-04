package com.manindra.hackerrank;

import java.util.Scanner;

public class HackerRankJavaLoop1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 1; i <= 10; i++) {
            int result = n * i;
            System.out.println(n + " x " + i + " = " + result);
        }

        scanner.close();
    }
}
