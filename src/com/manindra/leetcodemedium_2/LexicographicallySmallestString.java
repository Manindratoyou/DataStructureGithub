package com.manindra.leetcodemedium_2;

import java.util.*;

public class LexicographicallySmallestString { //solution 2434

    public static void main(String[] args) {
        String s1 = "zza";
        System.out.println(robotWithString(s1)); // Output: "azz"

        String s2 = "bac";
        System.out.println(robotWithString(s2)); // Output: "abc"

        String s3 = "bdda";
        System.out.println(robotWithString(s3)); // Output: "addb"
    }

    public static String robotWithString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        char minChar = 'a';
        for (char c : s.toCharArray()) {
            // Push current character to stack
            stack.push(c);
            freq[c - 'a']--;

            // Update minChar to the next smallest char that still has frequency
            while (minChar <= 'z' && freq[minChar - 'a'] == 0) {
                minChar++;
            }

            // Pop from stack if the top <= smallest remaining char
            while (!stack.isEmpty() && stack.peek() <= minChar) {
                result.append(stack.pop());
            }
        }

        // Append remaining chars from the stack
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public String robotWithString2(String s) {
        Stack<Character> t = new Stack<>();
        StringBuilder paper = new StringBuilder();
        int n = s.length();
        char[] minSuffix = new char[n + 1];
        Arrays.fill(minSuffix, 'z');

        for (int i = n - 1; i >= 0; i--) {
            minSuffix[i] = (char) Math.min(minSuffix[i + 1], s.charAt(i));
        }

        for (int i = 0; i < n; i++) {
            t.push(s.charAt(i));
            while (!t.isEmpty() && t.peek() <= minSuffix[i + 1]) {
                paper.append(t.pop());
            }
        }

        while (!t.isEmpty()) {
            paper.append(t.pop());
        }

        return paper.toString();
    }


}

