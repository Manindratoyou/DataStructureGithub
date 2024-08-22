package com.manindra.leetcodemedium_2;

import java.util.HashSet;
import java.util.Set;

public class MaximumVowelsInASubstring { //solution 1456

    public static void main(String[] args) {
        String s1 = "abciiidef";
        int k1 = 3;
        String s2 = "aeiou";
        int k2 = 2;
        String s3 = "leetcode";
        int k3 = 3;
        String s4 = "rhythms";
        int k4 = 4;
        String s5 = "tryhard";
        int k5 = 4;

        System.out.println(maxVowels(s1, k1)); // Expected output: 3
        System.out.println(maxVowels(s2, k2)); // Expected output: 2
        System.out.println(maxVowels(s3, k3)); // Expected output: 2
        System.out.println(maxVowels(s4, k4)); // Expected output: 0
        System.out.println(maxVowels(s5, k5)); // Expected output: 1
    }


    static int maxVowels(String s, int k) {
        int maxVowels = 0;
        int windowVowels = 0;

        Set<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i');
        vowels.add('o'); vowels.add('u');

        // Count the number of vowels in the first window
        for (int i = 0; i < k; i++)
            if (vowels.contains(s.charAt(i)))
                windowVowels++;

        maxVowels = windowVowels;

        // Slide the window and update the maximum number of vowels
        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i - k)))
                windowVowels--;

            if (vowels.contains(s.charAt(i)))
                windowVowels++;

            maxVowels = Math.max(maxVowels, windowVowels);
        }

        return maxVowels;
    }

}
