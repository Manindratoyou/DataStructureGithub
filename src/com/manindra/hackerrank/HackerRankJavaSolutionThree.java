package com.manindra.hackerrank;

import java.util.Scanner;

public class HackerRankJavaSolutionThree {

    /*
    java 100
cpp 65
python 50

     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("================================");

        while (scanner.hasNext()) {
            String str = scanner.next();
            int num = scanner.nextInt();

            // Format and print the output
            System.out.printf("%-15s%03d%n", str, num);
        }

        System.out.println("================================");

        scanner.close();
    }
}
