package com.manindra.hackerrank;

import java.util.stream.IntStream;

public class RepeatedString {

    public static void main(String[] args) {
        // Test cases
        String s1 = "aba";
        long n1 = 10;
        long result1 = repeatedString(s1, n1);
        System.out.println("Test Case 1: " + result1);

        String s2 = "abcac";
        long n2 = 10;
        long result2 = repeatedString(s2, n2);
        System.out.println("Test Case 2: " + result2);

        String s3 = "a";
        long n3 = 1000000000000L;
        long result3 = repeatedString(s3, n3);
        System.out.println("Test Case 3: " + result3);
    }

    public static long repeatedString(String s, long n) {
        // Count occurrences of 'a' in the input string
        long countInString = s.chars().filter(ch -> ch == 'a').count();

        // Calculate full repetitions and remainder
        long fullRepetitions = n / s.length();
        long remainder = n % s.length();

        // Count 'a' in the remainder substring
        long countInRemainder = IntStream.range(0, (int) remainder)
                .filter(i -> s.charAt(i) == 'a')
                .count();

        return fullRepetitions * countInString + countInRemainder;
    }

    public static long repeatedString2(String s, long n) {
        // Count occurrences of 'a' in the input string
        long countInString = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                countInString++;
            }
        }

        // Calculate full repetitions and remainder
        long fullRepetitions = n / s.length();
        long remainder = n % s.length();

        // Count 'a' in the remainder substring
        long countInRemainder = 0;
        for (int i = 0; i < remainder; i++) {
            if (s.charAt(i) == 'a') {
                countInRemainder++;
            }
        }

        return fullRepetitions * countInString + countInRemainder;
    }

    public static long repeatedString3(String s, long n) {
        int a_count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a')
                a_count++;
        }
        long reminder = n % s.length();
        if (reminder == 0)
            return (n / s.length()) * a_count;
        long count = noOfA(s, reminder);
        return (n / s.length()) * a_count + count;
    }

    public static int noOfA(String s, long reminder) {
        int count = 0;
        for (int i = 0; i < reminder; i++) {
            if (s.charAt(i) == 'a')
                count++;
        }
        return count;
    }

}

