package com.manindra.hackerrank;

import java.util.Scanner;

public class BeautifulBinaryString {

    static int beautifulBinaryString(String b) {
        int steps = 0;
        int index = 0;

        while (index < b.length() - 2) {
            if (b.charAt(index) == '0' && b.charAt(index + 1) == '1' && b.charAt(index + 2) == '0') {
                steps++;
                index += 3; // Move past the current '010' sequence
            } else {
                index++;
            }
        }

        return steps;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example Input:
        // 10
        // 0100101010

        // Input length of the binary string
        System.out.println("Enter the length of the binary string:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        // Input binary string
        System.out.println("Enter the binary string:");
        String b = scanner.nextLine();

        // Calculate and print the minimum number of steps needed
        int result = beautifulBinaryString(b);
        System.out.println("Minimum steps needed: " + result);

        scanner.close();
    }
}

