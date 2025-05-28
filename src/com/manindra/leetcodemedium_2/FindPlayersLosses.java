package com.manindra.leetcodemedium_2;

import java.util.*;

public class FindPlayersLosses { //solution 2225

    public static void main(String[] args) {

        int[][] matches = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        System.out.println(findWinners(matches));

    }

    static List<List<Integer>> findWinners(int[][] matches) {
        List<Integer> zeroLoses = new ArrayList<>();
        List<Integer> oneLose = new ArrayList();
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] team : matches) {
            map.put(team[0], map.getOrDefault(team[0], 0) + 0);
            map.put(team[1], map.getOrDefault(team[1], 0) + 1);
        }

        for (int i : map.keySet()) {
            if (map.get(i) == 0) {
                zeroLoses.add(i);
            } else if (map.get(i) == 1) {
                oneLose.add(i);
            }
        }

        Collections.sort(zeroLoses);
        Collections.sort(oneLose);

        return Arrays.asList(zeroLoses, oneLose);
    }
}
