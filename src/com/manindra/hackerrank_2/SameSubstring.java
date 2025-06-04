package com.manindra.hackerrank_2;

public class SameSubstring {

    public static int sameSubstring(String s, String t, int K) {
        int n = s.length();
        int[] cost = new int[n];

        // Calculate the cost array (absolute difference between characters)
        for (int i = 0; i < n; i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        // Sliding window approach
        int maxLength = 0;
        int currentCost = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            currentCost += cost[end];

            // If the current cost exceeds K, shrink the window
            while (currentCost > K) {
                currentCost -= cost[start];
                start++;
            }

            // Update the maximum length of the valid substring
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        // Sample test cases
        String s1 = "adpgki";
        String t1 = "cdmxki";
        int K1 = 6;
        System.out.println("Test Case 1:");
        System.out.println("Input: s = " + s1 + ", t = " + t1 + ", K = " + K1);
        System.out.println("Output: " + sameSubstring(s1, t1, K1));
        System.out.println();

        String s2 = "uaccd";
        String t2 = "gbbeg";
        int K2 = 4;
        System.out.println("Test Case 2:");
        System.out.println("Input: s = " + s2 + ", t = " + t2 + ", K = " + K2);
        System.out.println("Output: " + sameSubstring(s2, t2, K2));
        System.out.println();

        String s3 = "abcdef";
        String t3 = "ghijkl";
        int K3 = 10;
        System.out.println("Test Case 3:");
        System.out.println("Input: s = " + s3 + ", t = " + t3 + ", K = " + K3);
        System.out.println("Output: " + sameSubstring(s3, t3, K3));
        System.out.println();
    }
}

