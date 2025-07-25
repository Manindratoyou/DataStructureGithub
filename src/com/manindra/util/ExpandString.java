package com.manindra.util;

public class ExpandString {

    public static void main(String[] args) {
        // Test cases
        String input1 = "a1b10";
        String input2 = "b3c6d15";

        System.out.println("Input: " + input1);
        System.out.println("Output: " + expandString2(input1));  // Expected Output: abbbbbbbbbb

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
        int i = 0;

        while (i < input.length()) {
            char letter = input.charAt(i++);
            StringBuilder number = new StringBuilder();

            // Read full number (can be multiple digits)
            while (i < input.length() && Character.isDigit(input.charAt(i))) {
                number.append(input.charAt(i++));
            }

            int count = Integer.parseInt(number.toString());
            for (int j = 0; j < count; j++) {
                result.append(letter);
            }
        }

        return result.toString();
    }

}
