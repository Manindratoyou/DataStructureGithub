package com.manindra.interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class Program8 { //left most non repeating character through stream

    public static void main(String[] args) {
        String input = "lleetcode";
        Optional<Character> result = findLeftmostNonRepeatingCharacter(input);
        result.ifPresentOrElse(
                c -> System.out.println("Leftmost non-repeating character: " + c),
                () -> System.out.println("No non-repeating character found.")
        );
    }

    static Optional<Character> findLeftmostNonRepeatingCharacter(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> input.indexOf(c) == input.lastIndexOf(c))
                .findFirst();
    }

    static Optional<Character> findLeftmostNonRepeatingCharacterSolTwo(String input) {
        Map<Character, Long> charCountMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(LinkedHashMap::new,
                        (map, c) -> map.merge(c, 1L, Long::sum),
                        LinkedHashMap::putAll);

        return charCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
    }
}
