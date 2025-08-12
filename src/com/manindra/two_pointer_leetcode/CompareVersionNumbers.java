package com.manindra.two_pointer_leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CompareVersionNumbers { //solution 165

    public static void main(String[] args) {
        System.out.println(compareVersion("1.01", "1.001")); // 0
        System.out.println(compareVersion("1.0", "1.0.0")); // 0
        System.out.println(compareVersion("0.1", "1.1"));   // -1
        System.out.println(compareVersion("1.2", "1.10"));  // -1
    }

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int len = Math.max(v1.length, v2.length);
        for (int i = 0; i < len; i++) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;

            if (num1 > num2) return 1;
            if (num1 < num2) return -1;
        }
        return 0;
    }

    public static int compareVersion2(String version1, String version2) {
        List<Integer> v1 = Arrays.stream(version1.split("\\."))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> v2 = Arrays.stream(version2.split("\\."))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int len = Math.max(v1.size(), v2.size());
        for (int i = 0; i < len; i++) {
            int num1 = i < v1.size() ? v1.get(i) : 0;
            int num2 = i < v2.size() ? v2.get(i) : 0;

            if (num1 > num2) return 1;
            if (num1 < num2) return -1;
        }
        return 0;
    }

    public static int compareVersion3(String version1, String version2) {
        int i = 0, j = 0;
        int n1 = version1.length(), n2 = version2.length();

        while (i < n1 || j < n2) {
            int num1 = 0, num2 = 0;

            // Parse number from version1
            while (i < n1 && version1.charAt(i) != '.') {
                num1 = num1 * 10 + (version1.charAt(i) - '0');
                i++;
            }

            // Parse number from version2
            while (j < n2 && version2.charAt(j) != '.') {
                num2 = num2 * 10 + (version2.charAt(j) - '0');
                j++;
            }

            if (num1 > num2) return 1;
            if (num1 < num2) return -1;

            // Move past the '.' in both strings
            i++;
            j++;
        }

        return 0;
    }

}

