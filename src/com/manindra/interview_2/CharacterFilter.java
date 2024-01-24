package com.manindra.interview_2;

import java.util.Set;
import java.util.stream.Collectors;

public class CharacterFilter {

    public static void main(String[] args) {
        String inputString = "Hello World";
        String result = getRemainingAlphabets(inputString);
        System.out.println(result);
    }

    public static String getRemainingAlphabets(String input) {

        Set<Character> inputCharacter = input.toLowerCase().chars().
                mapToObj(c -> (char) c).collect(Collectors.toSet());

        return "abcdefghijklmnopqrstuvwxyz".chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !inputCharacter.contains(c))
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    static String getRemainingCharacter1(String input) {
        String s = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        for (char c : s.toLowerCase().toCharArray()) {

            if (input.toLowerCase().indexOf(c) < 0) {
                System.out.println(input.toLowerCase().indexOf(c));
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

