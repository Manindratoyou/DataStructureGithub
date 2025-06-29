package com.manindra.hashing_leetcode;

import java.util.*;
import java.util.stream.IntStream;

public class GroupThePeople { //solution 1282

    public static void main(String[] args) {
        System.out.println(groupThePeople(new int[]{3,3,3,3,3,1,3}));
        System.out.println(groupThePeople(new int[]{2,1,3,3,3,2}));
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            map.putIfAbsent(size, new ArrayList<>());
            map.get(size).add(i);

            // When a full group is formed
            if (map.get(size).size() == size) {
                result.add(new ArrayList<>(map.get(size)));
                map.get(size).clear(); // start collecting a new group
            }
        }

        return result;
    }

    public static List<List<Integer>> groupThePeople2(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        IntStream.range(0, groupSizes.length).forEach(i -> {
            int size = groupSizes[i];
            map.computeIfAbsent(size, k -> new ArrayList<>()).add(i);
            if (map.get(size).size() == size) {
                result.add(new ArrayList<>(map.get(size)));
                map.get(size).clear();
            }
        });

        return result;
    }

}

