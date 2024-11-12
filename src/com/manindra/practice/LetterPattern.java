package com.manindra.practice;

public class LetterPattern {
    public static void main(String[] args) {
        int N = 4;
        char letter = 'A'; // Start from 'A'

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                // Print the letter in uppercase for even positions and lowercase for odd positions
                if ((i + j) % 2 == 0) {
                    System.out.print(Character.toUpperCase(letter) + " ");
                } else {
                    System.out.print(Character.toLowerCase(letter) + " ");
                }
                letter++; // Move to the next letter
            }
            System.out.println(); // Move to the next line after each row
        }
    }
}
