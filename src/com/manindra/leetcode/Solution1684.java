package com.manindra.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
Output: 2
Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
 */
public class Solution1684 {

    public static void main(String[] args) {

        String [] words = {"ad","bd","aaab","baa","badab"};
        String allowed = "ab";
        //String allowed = "abc";
        //String [] words = {"a","b","c","ab","ac","bc","abc"};
        System.out.println(countConsistentStrings(words,allowed));
    }

    static int countConsistentStrings(String [] words,String allowed){

        int count=0;

        Set<Character> set=new HashSet<>();
        for (int i=0;i<allowed.length();i++){
            set.add(allowed.charAt(i));
        }
        for (String str: words){
            boolean flag=true;
            for (int i=0;i<str.length();i++){
                if (!set.contains(str.charAt(i)))
                    flag=false;
            }
            if (flag)
                count++;
        }
        return count;
    }

    public int countConsistentStringsSolTwo(String allowed, String[] words) {
        int count = 0;
        boolean[] allowedChars = new boolean[26];

        // Mark characters allowed in the string
        for (char c : allowed.toCharArray()) {
            allowedChars[c - 'a'] = true;
        }

        // Check each word
        for (String word : words) {
            boolean consistent = true;
            // Check if all characters in the word are allowed
            for (char c : word.toCharArray()) {
                if (!allowedChars[c - 'a']) {
                    consistent = false;
                    break;
                }
            }
            // Increment count if the word is consistent
            if (consistent) {
                count++;
            }
        }

        return count;
    }
}
