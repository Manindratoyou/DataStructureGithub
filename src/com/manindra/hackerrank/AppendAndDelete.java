package com.manindra.hackerrank;

import java.util.Scanner;

public class AppendAndDelete {

    static String appendAndDelete(String s, String t, int k) {
        int commonLength = 0;

        // Find the length of common prefix between s and t
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                commonLength++;
            } else {
                break;
            }
        }

        int totalOps = s.length() + t.length() - 2 * commonLength;

        // Check if operations are possible
        if (k >= totalOps && (k - totalOps) % 2 == 0 || k >= s.length() + t.length()) {
            return "Yes";
        } else {
            return "No";
        }
    }

    /*
    hackerhappy
    hackerrank
    9
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String t = scanner.nextLine();
        int k = scanner.nextInt();
        scanner.close();

        String result = appendAndDelete(s, t, k);
        System.out.println(result);
    }
}

