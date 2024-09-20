package com.manindra.leetcodeEasy;

import java.util.HashSet;
import java.util.Set;

public class CheckIfTheSentenceIsPangram { //solution 1832

    public static void main(String[] args) {

        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        String sentence1 = "leetcode";
        //System.out.println(checkIfPanagram(sentence));
        System.out.println(checkIfPanagram2(sentence));
    }

    static boolean checkIfPanagram(String sentence) {
        int[] count = new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            count[sentence.charAt(i) - 'a']++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0)
                return false;
        }
        return true;
    }

    static boolean checkIfPanagram2(String sentence) {

        Set<Character> alphabetSet = new HashSet<>();

        //add all character from 'a' to 'z' in hashset
        for (int i = 'a'; i <= 'z'; i++) {
            alphabetSet.add((char) i);
        }
        //remove every character and check if set becomes empty at any point of time
        for (int i = 0; i < sentence.length(); i++) {
            alphabetSet.remove(sentence.charAt(i));
            if (alphabetSet.isEmpty())
                return true;
        }
        return false;
    }

    public boolean checkIfPangram3(String sentence) {
        for (char i = 97; i< 123; i++){
            if (sentence.indexOf(i) == -1) return false;
        }
        return true;
    }
}

