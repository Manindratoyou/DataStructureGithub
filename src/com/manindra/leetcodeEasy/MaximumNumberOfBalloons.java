package com.manindra.leetcodeEasy;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaximumNumberOfBalloons { //solution 1189

    public static void main(String[] args) {

        String text = "nlaebolko";
        String text2 = "loonbalxballpoon";
        System.out.println(maxNumberOfBalloons(text));
        System.out.println(maxNumberOfBalloons2(text2));

    }

    static int maxNumberOfBalloons(String text) {
        int[] count = new int[26];

        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }

        int b = count['b' - 'a'];
        int a = count['a' - 'a'];
        int l = count['l' - 'a'] / 2;
        int o = count['o' - 'a'] / 2;
        int n = count['n' - 'a'];

        return Math.min(Math.min(Math.min(b, a), Math.min(l, o)), n);
    }

    static int maxNumberOfBalloons2(String text) {
        Map<Character, Long> freq = text.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        long b = freq.getOrDefault('b', 0L);
        long a = freq.getOrDefault('a', 0L);
        long l = freq.getOrDefault('l', 0L) / 2;
        long o = freq.getOrDefault('o', 0L) / 2;
        long n = freq.getOrDefault('n', 0L);

        return (int) Math.min(Math.min(Math.min(b, a), Math.min(l, o)), n);
    }
}

