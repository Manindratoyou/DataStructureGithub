package com.manindra.leetcodemedium_2;

public class ReverseWordsInString { //solution 151

    public static void main(String[] args) {

        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }

    static String reverseWords(String s) {
        // Remove leading and trailing whitespaces
        s = s.trim();

        // Split the string by one or more spaces
        String[] words = s.split("\\s+");

        StringBuilder reversed = new StringBuilder();

        // Append words in reverse order to StringBuilder
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) {
                reversed.append(" ");
            }
        }

        return reversed.toString();
    }
}
