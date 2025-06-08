package com.manindra.leetcodeEasy;

public class RotateStringCheck { //solution 796

    public static void main(String[] args) {
        // Test Case 1
        String s1 = "abcde", goal1 = "cdeab";
        System.out.println("Test Case 1: " + rotateString(s1, goal1)); // true

        // Test Case 2
        String s2 = "abcde", goal2 = "abced";
        System.out.println("Test Case 2: " + rotateString(s2, goal2)); // false

        // Test Case 3
        String s3 = "aa", goal3 = "aa";
        System.out.println("Test Case 3: " + rotateString(s3, goal3)); // true

        // Test Case 4
        String s4 = "waterbottle", goal4 = "erbottlewat";
        System.out.println("Test Case 4: " + rotateString(s4, goal4)); // true

        // Test Case 5
        String s5 = "abc", goal5 = "acb";
        System.out.println("Test Case 5: " + rotateString(s5, goal5)); // false
    }

    public static boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    public static boolean rotateString2(String s, String goal) {
        if (s.length() != goal.length()) return false;
        int n = s.length();

        // Try all possible rotations
        for (int i = 0; i < n; i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            if (rotated.equals(goal)) {
                return true;
            }
        }

        return false;
    }
}

