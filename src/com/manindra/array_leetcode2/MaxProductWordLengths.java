package com.manindra.array_leetcode2;

import java.util.HashSet;
import java.util.Set;

public class MaxProductWordLengths { //solution 318

    public static void main(String[] args) {
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println("Maximum Product: " + maxProduct(words)); // Output: 16
    }

    public static int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        int[] lens = new int[n];

        // Create bitmask for each word
        for (int i = 0; i < n; i++) {
            int bitmask = 0;
            for (char c : words[i].toCharArray()) {
                bitmask |= (1 << (c - 'a'));
            }
            masks[i] = bitmask;
            lens[i] = words[i].length();
        }

        int maxProduct = 0;

        // Compare each pair
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((masks[i] & masks[j]) == 0) { // no common letters
                    maxProduct = Math.max(maxProduct, lens[i] * lens[j]);
                }
            }
        }

        return maxProduct;
    }

    public static int maxProduct2(String[] words) {
        int n = words.length;
        int max = 0;

        // Create a set of characters for each word
        Set<Character>[] charSets = new HashSet[n];

        for (int i = 0; i < n; i++) {
            charSets[i] = new HashSet<>();
            for (char c : words[i].toCharArray()) {
                charSets[i].add(c);
            }
        }

        // Compare each pair
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (!hasCommonLetters(charSets[i], charSets[j])) {
                    int product = words[i].length() * words[j].length();
                    max = Math.max(max, product);
                }
            }
        }

        return max;
    }

    private static boolean hasCommonLetters(Set<Character> set1, Set<Character> set2) {
        for (char c : set1) {
            if (set2.contains(c)) {
                return true;
            }
        }
        return false;
    }
}

