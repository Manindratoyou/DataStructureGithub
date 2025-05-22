package com.manindra.leetcodeEasy;

import java.util.*;

public class FirstLetterTwice { //solution 2351

    public static void main(String[] args) {
        FirstLetterTwice solution = new FirstLetterTwice();

        System.out.println("Test 1: " + solution.repeatedCharacter("abccba"));  // Output: c
        System.out.println("Test 2: " + solution.repeatedCharacter("abcdd"));   // Output: d
        System.out.println("Test 3: " + solution.repeatedCharacter("aabbcc"));  // Output: a
        System.out.println("Test 4: " + solution.repeatedCharacter("abcdefgabc")); // Output: a
        System.out.println("Test 5: " + solution.repeatedCharacter("xyzwx"));   // Output: x
    }

    public char repeatedCharacter(String s) {

        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return c;
            } else {
                set.add(c);
            }
        }
        return 0; // Not expected per constraints
    }

    public char repeatedCharacter2(String s) {
        boolean[] seen = new boolean[26];

        for (char c : s.toCharArray()) {
            int index = c - 'a';
            if (seen[index]) return c;
            seen[index] = true;
        }
        return 0; // Should never hit per constraints
    }
}

