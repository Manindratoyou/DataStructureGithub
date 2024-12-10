package com.manindra.hackerrank;

public class DrawingBook {

    public static void main(String[] args) {
        int n = 6; // Total pages in the book
        int p = 5; // Target page
        System.out.println(pageCount(n, p)); // Output: 1
    }
    public static int pageCount(int n, int p) {
        // From the front
        int frontTurns = p / 2;

        // From the back
        int backTurns = (n / 2) - (p / 2);

        // Return the minimum
        return Math.min(frontTurns, backTurns);
    }

}

