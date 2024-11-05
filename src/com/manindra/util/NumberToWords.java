package com.manindra.util;

public class NumberToWords {
    public static void main(String[] args) {
        // Set the input number as a string
        String number = "1234";
        int number1 = 1234;

        // Convert the number to words and print the result
        System.out.println("Output: " + convertToWords(number));
        System.out.println("Output: " + convertNumberToWords(number1));
    }

    public static String convertToWords(String number) {
        StringBuilder result = new StringBuilder();

        // Map each digit to its corresponding word
        for (char digit : number.toCharArray()) {
            switch (digit) {
                case '0': result.append("zero"); break;
                case '1': result.append("one"); break;
                case '2': result.append("two"); break;
                case '3': result.append("three"); break;
                case '4': result.append("four"); break;
                case '5': result.append("five"); break;
                case '6': result.append("six"); break;
                case '7': result.append("seven"); break;
                case '8': result.append("eight"); break;
                case '9': result.append("nine"); break;
                default:
                    System.out.println("Invalid character encountered: " + digit);
                    return "";
            }
        }

        return result.toString();
    }

    // Array to store word representation of digits
    private static final String[] DIGIT_WORDS = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"
    };

    // Function to convert number to string of words
    public static String convertNumberToWords(int number) {
        StringBuilder result = new StringBuilder();

        // Convert number to string and iterate through each character
        for (char digit : Integer.toString(number).toCharArray()) {
            int digitValue = digit - '0'; // Convert char to corresponding integer
            result.append(DIGIT_WORDS[digitValue]).append(" ");
        }

        return result.toString().trim();
    }
}

