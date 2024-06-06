package com.manindra.backtracking;

public class PrintPermutations {

    // Given a string, print all permutations which do not contain "AB" as a substring
    // Input: "ABC"  Output: "ACB", "BAC", "BCA", "CBA"
    public static void main(String[] args) {
        String input = "ABC";
        printPermutations(input, 0, input.length() - 1);
    }

    // Naive solution to print permutations
    static void printPermutations(String input, int left, int right) {
        // If we reach the end of the string
        if (left == right) {
            // Check if the current permutation does not contain "AB"
            if (!input.contains("AB"))
                System.out.println(input);
            return;
        } else {
            for (int i = left; i <= right; i++) {
                // Swap the current character with the leftmost character
                input = swap(input, left, i);
                // Recur for the rest of the string
                printPermutations(input, left + 1, right);
                // Swap back to backtrack and revert the changes made by swap
                input = swap(input, left, i);
            }
        }
    }

    // Method to swap characters at position i and j in the string
    static String swap(String str, int i, int j) {
        char[] charArray = str.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return new String(charArray);
    }
    //using backtracking
    static void printPermutationsSolutionTwo(String input, int left, int right) {


    }
}
