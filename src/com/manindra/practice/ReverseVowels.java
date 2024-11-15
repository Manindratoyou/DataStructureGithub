package com.manindra.practice;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowels { //same code with leetcode solution 345

    public static void main(String[] args) {
        String input1 = "hello";
        System.out.println("Original: " + input1);
        System.out.println("Reversed Vowels: " + reverseVowels(input1));
        System.out.println("Reversed Vowels: " + reverseVowelsSolutionTwo(input1));

        String input2 = "leetcode";
        System.out.println("\nOriginal: " + input2);
        System.out.println("Reversed Vowels: " + reverseVowels(input2));
        System.out.println("Reversed Vowels: " + reverseVowelsSolutionTwo(input2));

        String input3 = "aA";
        System.out.println("\nOriginal: " + input3);
        System.out.println("Reversed Vowels: " + reverseVowels(input3));
        System.out.println("Reversed Vowels: " + reverseVowelsSolutionTwo(input3));

        String input4 = "programming";
        System.out.println("\nOriginal: " + input4);
        System.out.println("Reversed Vowels: " + reverseVowels(input4));
        System.out.println("Reversed Vowels: " + reverseVowelsSolutionTwo(input4));

        String input5 = "aeiou";
        System.out.println("\nOriginal: " + input5);
        System.out.println("Reversed Vowels: " + reverseVowels(input5));
        System.out.println("Reversed Vowels: " + reverseVowelsSolutionTwo(input5));

        String input6 = "bcdfghjklmnpqrstvwxyz";
        System.out.println("\nOriginal: " + input6);
        System.out.println("Reversed Vowels: " + reverseVowels(input6));
        System.out.println("Reversed Vowels: " + reverseVowelsSolutionTwo(input6));

        String input7 = "race car";
        System.out.println("\nOriginal: " + input7);
        System.out.println("Reversed Vowels: " + reverseVowels(input7));
        System.out.println("Reversed Vowels: " + reverseVowelsSolutionTwo(input7));

        String input8 = "HELLO";
        System.out.println("\nOriginal: " + input8);
        System.out.println("Reversed Vowels: " + reverseVowels(input8));
        System.out.println("Reversed Vowels: " + reverseVowelsSolutionTwo(input8));
    }


    public static String reverseVowels(String s) {
        // Convert the string to a character array for easy manipulation
        char[] chars = s.toCharArray();

        // Define the set of vowels
        Set<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
        vowels.add('A'); vowels.add('E'); vowels.add('I'); vowels.add('O'); vowels.add('U');

        // Two pointers: one starting from the beginning, the other from the end
        int left = 0, right = s.length() - 1;

        // Loop until the two pointers meet
        while (left < right) {
            // Move the left pointer until it points to a vowel
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }

            // Move the right pointer until it points to a vowel
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }

            // Swap the vowels at the left and right pointers
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            // Move both pointers towards the center
            left++;
            right--;
        }

        // Convert the character array back to a string and return it
        return new String(chars);
    }

    public static String reverseVowelsSolutionTwo(String s) {

        char[] word = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        String vowels = "aeiouAEIOU";
        while (start < end) {
            while (start < end && vowels.indexOf(word[start]) == -1)
                start++;
            while (start < end && vowels.indexOf(word[end]) == -1)
                end--;

            char temp = word[start];
            word[start] = word[end];
            word[end] = temp;

            start++;
            end--;
        }
        return String.valueOf(word);
    }

}

