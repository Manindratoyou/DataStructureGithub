package com.manindra.hashing_leetcode;

import java.util.stream.IntStream;

public class BullsAndCows { //solution 299

    public static void main(String[] args) {
        System.out.println(getHint("1807", "7810")); // 1A3B
        System.out.println(getHint("1123", "0111")); // 1A1B
        System.out.println(getHint("11", "10"));     // 1A0B
    }

    public static String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        int[] secretCount = new int[10];
        int[] guessCount = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s == g) {
                bulls++;
            } else {
                secretCount[s - '0']++;
                guessCount[g - '0']++;
            }
        }

        // Count cows
        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretCount[i], guessCount[i]);
        }

        return bulls + "A" + cows + "B";
    }

    public static String getHint2(String secret, String guess) {
        int bulls = 0;
        int[] sCount = new int[10];
        int[] gCount = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i), g = guess.charAt(i);
            if (s == g) {
                bulls++;
            } else {
                sCount[s - '0']++;
                gCount[g - '0']++;
            }
        }

        int cows = IntStream.range(0, 10)
                .map(i -> Math.min(sCount[i], gCount[i]))
                .sum();

        return bulls + "A" + cows + "B";
    }

}

