package com.manindra.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/*
Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.
 */
public class Solution1832 { //Check if the Sentence Is Pangram

    public static void main(String[] args) {

        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        String sentence1 = "The quick brown fox jumps over the lazy dog";
        String sentence2 = "Hello World";
        System.out.println(panagramCheck(sentence));
        System.out.println(checkIfPangram4(sentence2));
    }

    static boolean panagramCheck(String s) {
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0)
                return false;
        }
        return true;
    }

    static boolean checkIfPangram(String sentence) {
        char ch = 'a';
        for (int i = 0; i < 26; i++)
            if (sentence.contains(String.valueOf(ch))) ch++;
            else return false;
        return true;
    }

    static boolean checkIfPangramStream(String sentence) {
        return IntStream.rangeClosed('a', 'z')
                .allMatch(ch -> sentence.contains(String.valueOf((char) ch)));
    }

    static boolean checkIfPangram4(String sentence) {
        Set<Character> set = new HashSet<>();

        //add all character from 'a' to 'z' in hashset
        for (int i = 'a'; i <= 'z'; i++) {
            set.add((char) i);
        }
        //remove every character and check if set becomes empty at any point of time
        for (int i = 0; i < sentence.length(); i++) {
            set.remove(sentence.charAt(i));
            if (set.isEmpty())
                return true;
        }
        return false;
    }
}
