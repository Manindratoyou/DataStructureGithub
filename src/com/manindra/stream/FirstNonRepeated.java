package com.manindra.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
Given a String ,find the first non-repeated character in it using stream function
 */
public class FirstNonRepeated {

    public static void main(String[] args) {

        String input = "java article are awesome";

        Character result = input.chars().mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 1L)
                .map(entry -> entry.getKey()).findFirst().get();

        System.out.println(result);
        printNonRepeated(input);
        printNonrepeated(input);

    }

    static void printNonRepeated(String str) {
        // Calculating frequencies using HashMap
        Map<Character, Integer> freq
                = new HashMap<>();
        for (char c : str.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        str.chars().mapToObj(c -> (char) c).filter(c -> freq.get(c) == 1).findFirst()
                .ifPresent(System.out::println);

        // Traverse the string
        /*for (char c : str.toCharArray()) {
            if (freq.get(c) == 1) {
                System.out.println(
                        "First non-repeating character is "
                                + c);
                return;
            }
        }*/
    }

    public static void printNonrepeated(String str) {
        Map<Character, Long> freq = str.chars()
                .mapToObj(c -> (char) c)
                .collect(HashMap::new,
                        (map, c) -> map.put(c, map.getOrDefault(c, 0L) + 1L),
                        HashMap::putAll);

        Optional<Character> firstNonRepeatedChar = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> freq.get(c) == 1)
                .findFirst();

        firstNonRepeatedChar.ifPresent(c ->
                System.out.println("First non-repeating character is " + c));
    }

}
