package com.manindra.string;

public class LongestEvenWord {

    public static void main(String[] args) {
        String sentence = "This is a sample sentence to test the program";
        String longestEvenWord = findLongestEvenWord(sentence);
        System.out.println("Longest even word: " + longestEvenWord);
    }

    static String findLongestEvenWord(String sentence){
        String[] words=sentence.split(" ");
        String longestEvenWord = "";
        for (String word : words){
            if (word.length()%2 == 0 && word.length() > longestEvenWord.length())
                longestEvenWord=word;
        }
        return longestEvenWord;
    }
}
