package com.manindra.backtracking_leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses { //solution 93

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
        // Output: [255.255.11.135, 255.255.111.35]
        System.out.println(restoreIpAddresses("0000"));
        // Output: [0.0.0.0]
        System.out.println(restoreIpAddresses("101023"));
        // Output: [1.0.10.23, 1.0.102.3, 10.1.0.23, 10.10.2.3, 101.0.2.3]
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(String s, int start, List<String> current, List<String> result) {
        // If we have 4 parts and consumed entire string, add to result
        if (current.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", current));
            }
            return;
        }

        // Try to take 1 to 3 digits
        for (int len = 1; len <= 3 && start + len <= s.length(); len++) {
            String part = s.substring(start, start + len);

            // Skip if leading zero (unless single digit "0")
            if (part.length() > 1 && part.startsWith("0"))
                continue;

            int value = Integer.parseInt(part);
            if (value > 255)
                continue; // Invalid part

            current.add(part);
            backtrack(s, start + len, current, result);
            current.remove(current.size() - 1); // Backtrack
        }
    }


}

