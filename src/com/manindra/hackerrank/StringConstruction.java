package com.manindra.hackerrank;

/**
 * Problem Description:
 *
 * String Construction
 *
 * You are given a string `s`. You need to construct a new string, `p`, using the characters
 * of `s` such that each character can only be used once. The cost of constructing string `p`
 * is equal to the number of distinct characters in `s`.
 *
 * Determine the cost to construct string `p`.
 *
 * Input Format:
 * - A single string `s` consisting of lowercase English letters.
 *
 * Output Format:
 * - Print an integer, the minimum cost to construct string `p`.
 *
 * Constraints:
 * - 1 ≤ |s| ≤ 10^5
 *
 * Examples:
 * 1. Input: "abcd"
 *    Output: 4 (All characters are distinct, so cost = 4)
 *
 * 2. Input: "abab"
 *    Output: 2 (Only 'a' and 'b' are distinct)
 *
 * 3. Input: "aaaa"
 *    Output: 1 (Only 'a' is distinct)
 *
 * 4. Input: "xyz"
 *    Output: 3 (All characters are distinct, so cost = 3)
 */
import java.util.HashSet;

public class StringConstruction {

    public static void main(String[] args) {
        // Test cases
        System.out.println(stringConstruction("abcd"));  // Output: 4
        System.out.println(stringConstruction("abab"));  // Output: 2
        System.out.println(stringConstruction("aaaa"));  // Output: 1
        System.out.println(stringConstruction("xyz"));   // Output: 3
        System.out.println(stringConstruction("abcabc")); // Output: 3
    }

    public static int stringConstruction(String s) {
        // Use a HashSet to track distinct characters
        HashSet<Character> distinctCharacters = new HashSet<>();
        for (char c : s.toCharArray()) {
            distinctCharacters.add(c);
        }
        // The cost is the size of the set
        return distinctCharacters.size();
    }
}

