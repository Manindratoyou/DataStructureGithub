package com.manindra.array_leetcode2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MinIndexSum { //solution 599

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};

        String[] result = findRestaurant(list1, list2);
        System.out.println(Arrays.toString(result));
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> result = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;

        for (int j = 0; j < list2.length; j++) {
            String s = list2[j];
            if (map.containsKey(s)) {
                int sum = j + map.get(s);
                if (sum < minSum) {
                    result.clear();
                    result.add(s);
                    minSum = sum;
                } else if (sum == minSum) {
                    result.add(s);
                }
            }
        }

        return result.toArray(new String[0]);
    }

    public static String[] findRestaurant2(String[] list1, String[] list2) {
        Map<String, Integer> map1 = IntStream.range(0, list1.length)
                .boxed()
                .collect(Collectors.toMap(i -> list1[i], i -> i));

        Map<Integer, List<String>> sumMap = new HashMap<>();
        int minSum = Integer.MAX_VALUE;

        for (int j = 0; j < list2.length; j++) {
            String s = list2[j];
            if (map1.containsKey(s)) {
                int sum = j + map1.get(s);
                minSum = Math.min(minSum, sum);
                sumMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(s);
            }
        }

        return sumMap.getOrDefault(minSum, Collections.emptyList()).toArray(new String[0]);
    }
}

