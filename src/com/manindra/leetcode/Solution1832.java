package com.manindra.leetcode;

import java.util.stream.IntStream;

/*
Input: sentence = "thequickbrownfoxjumpsoverthelazydog"
Output: true
Explanation: sentence contains at least one of every letter of the English alphabet.
 */
public class Solution1832 { //Check if the Sentence Is Pangram

    public static void main(String[] args) {

    String sentence = "thequickbrownfoxjumpsoverthelazydog";
        //System.out.println(panagramCheck(sentence));
        System.out.println(checkIfPangram(sentence));
}

    static boolean panagramCheck(String s){
        int [] count=new int[26];

        for (int i=0;i< s.length();i++){
            count[s.charAt(i)-'a']++;
        }

        for (int i=0;i< count.length;i++){
            if (count[i]==0)
                return false;
        }
        return true;
    }
    static boolean checkIfPangram(String sentence) {
        char ch ='a' ;
        for(int i=0;i<26;i++)
            if (sentence.contains(String.valueOf(ch))) ch++;
            else return false;
        return true;
    }

    static boolean checkIfPangramStream(String sentence) {
        return IntStream.rangeClosed('a', 'z')
                .allMatch(ch -> sentence.contains(String.valueOf((char) ch)));
    }
}
