package com.manindra.hackerrank;

import java.util.Scanner;

public class HackerRankJavaIntToString {

    //100

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        // Convert the integer to a string
        String str = Integer.toString(n); // or str = "" + n;

        // Check if the conversion is successful
        if (str.equals(Integer.toString(n))) {
            System.out.println("Good job");
        } else {
            System.out.println("Wrong answer");
        }
    }
}
