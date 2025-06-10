package com.manindra.util;

public class ExpandString {

    public static void main(String[] args) {
        // Test cases
        String input1 = "a1b10";
        String input2 = "b3c6d15";

        System.out.println("Input: " + input1);
        System.out.println("Output: " + expandString(input1));  // Expected Output: abbbbbbbbbb

        System.out.println("Input: " + input2);
        System.out.println("Output: " + expandString(input2));  // Expected Output: bbbccccccddddddddddddddd
    }

    public static String expandString(String input) {
        StringBuilder result = new StringBuilder();
        int length = input.length();
        int i = 0;

        while (i < length) {
            char currentChar = input.charAt(i);  // Read the character
            i++;
            StringBuilder number = new StringBuilder();

            // Collect the digits following the character
            while (i < length && Character.isDigit(input.charAt(i))) {
                number.append(input.charAt(i));
                i++;
            }

            // Convert the collected digits to an integer
            int repeatCount = Integer.parseInt(number.toString());

            // Append the character `repeatCount` times to the result
            for (int j = 0; j < repeatCount; j++) {
                result.append(currentChar);
            }
        }

        return result.toString();
    }

    public static String expandString2(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            int j = i + 1;

            // Find the number part
            while (j < input.length() && Character.isDigit(input.charAt(j))) {
                j++;
            }

            // Append character 'n' times
            int count = Integer.parseInt(input.substring(i + 1, j));
            result.append(String.valueOf(ch).repeat(count));

            // Move to the next character block
            i = j - 1;
        }
        return result.toString();
    }

}
