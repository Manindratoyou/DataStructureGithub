package com.manindra.iitp.lab5101;

public class Stringmatching2 {

    public static void main(String[] args) {
        // Test case 1
        String str1_1 = "hello";
        String str2_1 = "hello";
        runTestCase(str1_1, str2_1);  // Expected output: YES

        // Test case 2
        String str1_2 = "hello";
        String str2_2 = "world";
        runTestCase(str1_2, str2_2);  // Expected output: NO

        // Test case 3
        String str1_3 = "abcdef";
        String str2_3 = "abcde";
        runTestCase(str1_3, str2_3);  // Expected output: NO

        // Test case 4
        String str1_4 = "123";
        String str2_4 = "123";
        runTestCase(str1_4, str2_4);  // Expected output: YES

        // Test case 5
        String str1_5 = "abc";
        String str2_5 = "ab";
        runTestCase(str1_5, str2_5);  // Expected output: NO
    }

    private static void runTestCase(String str1, String str2) {
        if (str1.length() != str2.length()) {
            System.out.println("NO");
            return;
        }

        boolean areEqual = true;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                areEqual = false;
                break;
            }
        }

        if (areEqual) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
