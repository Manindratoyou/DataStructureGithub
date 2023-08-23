package com.manindra.hackerrank;

import java.util.Scanner;

public class RepeatedString {

    static long repeatedString(String s, long n) {
        long aCountInString = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                aCountInString++;
            }
        }

        long totalCount = aCountInString * (n / s.length());

        long remainingChars = n % s.length();
        for (int i = 0; i < remainingChars; i++) {
            if (s.charAt(i) == 'a') {
                totalCount++;
            }
        }

        return totalCount;
    }

    /*
    aba
    10
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        long n = scanner.nextLong();
        scanner.close();

        long result = repeatedString(s, n);
        System.out.println(result);
    }
}

