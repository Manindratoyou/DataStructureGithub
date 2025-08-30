package com.manindra.string_leetcode1;

public class LicenseKeyFormatting { //solution 482

    public static void main(String[] args) {
        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w", 4)); // Output: 5F3Z-2E9W
        System.out.println(licenseKeyFormatting("2-5g-3-J", 2));   // Output: 2-5G-3J
    }

    public static String licenseKeyFormatting(String s, int k) {
        // Remove dashes and convert to uppercase
        String str = s.replace("-", "").toUpperCase();
        int n = str.length();
        if (n == 0) return "";

        StringBuilder sb = new StringBuilder();
        int firstGroup = n % k; // size of the first group

        // If first group is not empty, add it
        if (firstGroup > 0) {
            sb.append(str.substring(0, firstGroup));
        }

        // Process remaining groups
        for (int i = firstGroup; i < n; i += k) {
            if (sb.length() > 0) sb.append("-");
            sb.append(str.substring(i, i + k));
        }

        return sb.toString();
    }

    public static String licenseKeyFormatting2(String s, int k) {
        String str = s.replace("-", "").toUpperCase();
        StringBuilder sb = new StringBuilder();

        int count = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
            count++;
            if (count == k && i > 0) {
                sb.append("-");
                count = 0;
            }
        }

        return sb.reverse().toString();
    }
}

