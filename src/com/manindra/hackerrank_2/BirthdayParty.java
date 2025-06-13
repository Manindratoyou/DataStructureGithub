package com.manindra.hackerrank_2;

public class BirthdayParty {

    // Method to find the kid who gets the damaged toy
    public static int findDamagedToy(int N, int T, int D) {
        // Adjust D to zero-based indexing
        int startIndex = D - 1;
        // Find the position of the last toy
        int lastToyPosition = (startIndex + T - 1) % N;
        // Convert back to one-based indexing
        return lastToyPosition + 1;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("Test Case 1:");
        System.out.println("N = 5, T = 2, D = 1 -> Output: " + findDamagedToy(5, 2, 1)); // Expected: 2

        System.out.println("\nTest Case 2:");
        System.out.println("N = 6, T = 8, D = 3 -> Output: " + findDamagedToy(6, 8, 3)); // Expected: 4

        System.out.println("\nTest Case 3:");
        System.out.println("N = 4, T = 5, D = 2 -> Output: " + findDamagedToy(4, 5, 2)); // Expected: 2

        System.out.println("\nTest Case 4:");
        System.out.println("N = 7, T = 14, D = 5 -> Output: " + findDamagedToy(7, 14, 5)); // Expected: 5

        System.out.println("\nTest Case 5:");
        System.out.println("N = 10, T = 25, D = 7 -> Output: " + findDamagedToy(10, 25, 7)); // Expected: 1);
    }
}

