package com.manindra.interview_2;

public class PrintCharOccurence2 {

    public static void main(String[] args) {
        String inputString = "aaavvccaa";
        String compressedString = compressString(inputString);
        System.out.println("Compressed string: " + compressedString); // Output: a3v2c2a2
    }

    public static String compressString(String str) {
        StringBuilder builder = new StringBuilder();
        int count = 1;
        char currentChar = str.charAt(0);

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == currentChar) {
                count++;
            } else {
                builder.append(currentChar).append(count);
                currentChar = str.charAt(i);
                count = 1;
            }
        }

        // Append the last character and its count
        builder.append(currentChar).append(count);

        return builder.toString();
    }
}
