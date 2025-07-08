package com.manindra.array_leetcode1;

import java.util.Arrays;

public class Solution2114 { //Maximum Number of Words Found in Sentences

    public static void main(String[] args) {

        String [] sentences =
                {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        countWord(sentences);

        System.out.println(maxWordsInSentence(sentences));
    }

    static void countWord(String [] arr){

        int maxLength=0;
        for (String a:arr) {
            String[] words = a.split(" ");
            maxLength=Math.max(maxLength,words.length);
        }
        System.out.println(maxLength);
    }

    public static int maxWordsInSentence(String[] sentences) {
        return Arrays.stream(sentences)
                .mapToInt(s -> countWords(s))
                .max()
                .orElse(0);
    }

    private static int countWords(String s) {
        return (int) Arrays.stream(s.split("\\s+"))
                .count();
    }

}
