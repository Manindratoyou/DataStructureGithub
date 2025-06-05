package com.manindra.interview_2;

public class CompressString {

    public static void main(String[] args) {
        // Input string
        String input = "ffaggghsssaaagggaaaaagggaa";

        // Output the compressed string
        System.out.println("Input: " + input);
        System.out.println("Output: " + compressString(input));
    }

    public static String compressString(String input) {
        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            // Check if the current character is the same as the previous one
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                // Append the previous character and its count to the result
                compressed.append(input.charAt(i - 1)).append(count);
                count = 1; // Reset count for the new character
            }
        }

        // Append the last character and its count
        compressed.append(input.charAt(input.length() - 1)).append(count);

        return compressed.toString();
    }
}

