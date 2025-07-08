package com.manindra.string_leetcode1;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
Input: s = "Hello how are you Contestant", k = 4
Output: "Hello how are you"
Explanation:
The words in s are ["Hello", "how" "are", "you", "Contestant"].
The first 4 words are ["Hello", "how", "are", "you"].
Hence, you should return "Hello how are you".
 */
public class Solution1816 { //Truncate Sentence

    public static void main(String[] args) {

        String s = "Hello how are you Contestant"; int k = 4;
        System.out.println(truncateSentence(s,k));
    }

    static String truncateSentence(String s, int k) {

        String [] word= s.split("\\s");

        StringBuilder sb=new StringBuilder();
        for (int i=0;i<k;i++){
             sb.append(word[i]).append(" ");
        }
        return sb.toString().trim();
    }

    //Time Complexity: O(n)
    //Auxiliary Space: O(n)
    public String truncateSentenceSolutionTwo(String s, int k) {
        return Arrays.stream(s.split(" "))
                .limit(k)
                .collect(Collectors.joining(" "));
    }

    //Time Complexity: O(n)
    //Auxiliary Space: O(1)
    public String truncateSentenceSolutionThree(String s, int k) {
        int count = 0;
        int index = 0;

        while (count < k && index < s.length()) {
            if (s.charAt(index) == ' ') {
                count++;
            }
            index++;
        }

        return s.substring(0, index - 1);
    }
}
