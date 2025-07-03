package com.manindra.hackerrank_2;

import java.util.*;

public class UsernameStrengthChecker {

    public static List<String> getUsernameStrength(List<String> usernames, List<String> commonWords) {
        Set<String> dict = new HashSet<>(commonWords);
        List<String> result = new ArrayList<>();

        for (String username : usernames) {
            if (isWeak(username, dict)) {
                result.add("weak");
            } else {
                result.add("strong");
            }
        }

        return result;
    }

    private static boolean isWeak(String username, Set<String> dict) {
        // Rule 1: Username is in the dictionary
        if (dict.contains(username)) return true;

        // Rule 2: Any substring is in the dictionary
        int len = username.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (dict.contains(username.substring(i, j))) return true;
            }
        }

        // Rule 3: Only digits
        if (username.matches("\\d+")) return true;

        // Rule 4: All uppercase or all lowercase
        if (username.equals(username.toLowerCase()) || username.equals(username.toUpperCase())) return true;

        // Rule 5: Shorter than 6 characters
        if (username.length() < 6) return true;

        // Otherwise, it's strong
        return false;
    }

    // Sample test cases
    public static void main(String[] args) {
        List<String> usernames = Arrays.asList("hello", "chargeR", "pass123");
        List<String> commonWords = Arrays.asList("hello", "123", "password", "xyz", "999");

        List<String> result = getUsernameStrength(usernames, commonWords);
        for (String status : result) {
            System.out.println(status);
        }

        // Expected Output:
        // weak
        // strong
        // weak
    }
}

