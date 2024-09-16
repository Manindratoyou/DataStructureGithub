package com.manindra.iitp.lab5101;

public class Stringmatching10 {

    public static void main(String[] args) {
        // Test case 1
        String A1 = "hello world";
        String B1 = "world";
        runTestCase(A1, B1);  // Expected output: YES

        // Test case 2
        String A2 = "hello world";
        String B2 = "worlds";
        runTestCase(A2, B2);  // Expected output: NO

        // Test case 3
        String A3 = "abcdefgh";
        String B3 = "cde";
        runTestCase(A3, B3);  // Expected output: YES

        // Test case 4
        String A4 = "abcdefgh";
        String B4 = "xyz";
        runTestCase(A4, B4);  // Expected output: NO

        // Test case 5
        String A5 = "short";
        String B5 = "short";
        runTestCase(A5, B5);  // Expected output: YES

        // Test case 6
        String A6 = "short";
        String B6 = "shorter";
        runTestCase(A6, B6);  // Expected output: NO
    }

    private static void runTestCase(String A, String B) {
        boolean isSubstring = false;

        // Check each possible starting position in A for B
        for (int i = 0; i <= A.length() - B.length(); i++) {
            boolean match = true;

            // Compare substring of A starting at index i with B
            for (int j = 0; j < B.length(); j++) {
                if (A.charAt(i + j) != B.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (match) {
                isSubstring = true;
                break;
            }
        }

        if (isSubstring) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
