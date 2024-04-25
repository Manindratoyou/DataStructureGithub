package com.manindra.hackerrank;

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

}

