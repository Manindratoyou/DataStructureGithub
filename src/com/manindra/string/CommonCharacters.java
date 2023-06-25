package com.manindra.string;

import java.util.HashSet;

public class CommonCharacters {

    public static void main(String[] args) {
        String input1 = "abcde";
        String input2 = "defrty";
        commonCharactersSolOne(input1,input2);
    }

    static void commonCharactersSolOne(String input1, String input2){
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();

        for (char c : input1.toCharArray()) {
            set1.add(c);
        }

        for (char c : input2.toCharArray()) {
            if (set1.contains(c)) {
                set2.add(c);
            }
        }

        System.out.print("Output: ");
        for (char c : set2) {
            System.out.print(c + " ");
        }
    }
}
