package com.manindra.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnagramDeletions {

    static int makeAnagram(String a, String b) {

        // Count the frequency of characters in both strings
        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : a.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (char c : b.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) - 1);
        }

        // Calculate the total number of deletions required
        int deletions = 0;

        for (int count : charCount.values()) {
            deletions += Math.abs(count);
        }

        return deletions;
    }

    /*
    cde
    abc
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        scanner.close();

        int result = makeAnagram(a, b);
        System.out.println(result);
    }
}

