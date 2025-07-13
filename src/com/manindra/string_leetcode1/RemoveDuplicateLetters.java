package com.manindra.string_leetcode1;

import java.util.*;

public class RemoveDuplicateLetters { //solution 316

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));      // Output: abc
        System.out.println(removeDuplicateLetters("cbacdcbc"));   // Output: acdb
    }

    public static String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26]; // Last occurrence of each char
        boolean[] visited = new boolean[26]; // Visited chars in stack

        // Step 1: Fill lastIndex
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();

        // Step 2: Process each char
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';

            if (visited[idx])
                continue; // Skip if already in stack

            // Remove characters that are:
            // - greater than current char
            // - appear later again
            while (!stack.isEmpty() && ch < stack.peek() && lastIndex[stack.peek() - 'a'] > i) {
                visited[stack.pop() - 'a'] = false;
            }

            stack.push(ch);
            visited[idx] = true;
        }

        // Step 3: Build result
        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);
        return sb.toString();

        /*
        String result = stack.stream()
                     .map(String::valueOf)
                     .collect(Collectors.joining());
         */
    }

}

