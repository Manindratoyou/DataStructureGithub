package com.manindra.string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SortStringCharacters {

    public static void main(String[] args) {
        String input = "manindra";
        String result = sortCharacters(input);
        System.out.println("Sorted: " + result);  // Output: aadimnnr
    }

    public static String sortCharacters(String input) {
        char[] chars = input.toCharArray();   // Convert string to char array
        Arrays.sort(chars);                   // Sort the char array
        return new String(chars);             // Convert back to string
    }

    public static String sortCharacters2(String input) {
        return input.chars()                        // Convert to IntStream
                .sorted()                       // Sort the stream
                .mapToObj(c -> String.valueOf((char)c)) // Convert back to characters
                .collect(Collectors.joining()); // Join into a single string
    }

    public static String sortCharacters3(String str) {
        char[] chars = str.toCharArray(); // Convert string to char array

        // Bubble sort
        for (int i = 0; i < chars.length - 1; i++) {
            for (int j = 0; j < chars.length - 1 - i; j++) {
                if (chars[j] > chars[j + 1]) {
                    // Swap
                    char temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                }
            }
        }

        // Convert sorted char array back to string
        String sorted = "";
        for (char ch : chars) {
            sorted += ch;
        }

        return sorted;
    }
}

