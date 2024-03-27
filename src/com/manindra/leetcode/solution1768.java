package com.manindra.leetcode;

/*
Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
 */
public class solution1768 {

    public static void main(String[] args) {

        String word1="abc" ,word2="pqr";
        System.out.println(mergeAlternately(word1,word2));

    }

    static String mergeAlternately(String word1,String word2){

        StringBuilder result=new StringBuilder();
        int i=0,j=0;
        while (i<word1.length() && j<word2.length()){
            result.append(word1.charAt(i++));
            result.append(word2.charAt(j++));
        }
        return result.toString();
    }
}
