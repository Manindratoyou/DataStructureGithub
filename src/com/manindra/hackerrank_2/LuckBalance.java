package com.manindra.hackerrank_2;

import java.util.*;

public class LuckBalance {

    public static int luckBalance(int k, List<List<Integer>> contests) {
        List<Integer> important = new ArrayList<>();
        int totalLuck = 0;

        for (List<Integer> contest : contests) {
            int luck = contest.get(0);
            int importance = contest.get(1);

            if (importance == 1) {
                important.add(luck); // store for special handling
            } else {
                totalLuck += luck; // lose all unimportant ones
            }
        }

        // Sort important contests descending by luck
        important.sort(Collections.reverseOrder());

        // Lose top k important contests
        for (int i = 0; i < important.size(); i++) {
            if (i < k) {
                totalLuck += important.get(i); // lose it
            } else {
                totalLuck -= important.get(i); // win it
            }
        }

        return totalLuck;
    }

    public static void main(String[] args) {
        List<List<Integer>> contests = Arrays.asList(
                Arrays.asList(5, 1),
                Arrays.asList(1, 1),
                Arrays.asList(4, 0)
        );
        int k = 2;
        System.out.println("Max Luck: " + luckBalance(k, contests)); // Output: 10
    }
}
