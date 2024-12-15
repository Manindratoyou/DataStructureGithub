package com.manindra.hackerrank;

import java.util.*;

/*
HashMap Approach: Efficient for large lists.
Brute Force: Easy to implement for small lists but inefficient for large inputs.
Two-Pointer-Like Approach: Elegant and useful when sorting is acceptable.
 */
public class MinimumDistances {

    public static void main(String[] args) {
        // Test case 1
        List<Integer> list1 = List.of(7, 1, 3, 4, 1, 7);
        System.out.println(minimumDistances(list1)); // Output: 3
        //System.out.println(minimumDistances2(list1)); // Output: 3
        System.out.println(minimumDistances3(list1)); // Output: 3

        // Test case 2
        List<Integer> list2 = List.of(1, 2, 3, 4, 10);
        System.out.println(minimumDistances(list2)); // Output: -1

        // Test case 3
        List<Integer> list3 = List.of(1, 1);
        System.out.println(minimumDistances(list3)); // Output: 1
    }

    //brut-force
    public static int minimumDistances(List<Integer> list) {
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    minDistance = Math.min(minDistance, j - i);
                }
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    //efficient
    public static int minimumDistances2(List<Integer> list) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < list.size(); i++) {
            if (indexMap.containsKey(list.get(i))) {
                int distance = i - indexMap.get(list.get(i));
                minDistance = Math.min(minDistance, distance);
            }
            // Update the last seen index
            indexMap.put(list.get(i), i);
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    public static int minimumDistances3(List<Integer> list) {
        List<int[]> indexPairs = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            indexPairs.add(new int[]{list.get(i), i});
        }

        indexPairs.sort(Comparator.comparingInt(a -> a[0]));

        int minDistance = Integer.MAX_VALUE;

        for (int i = 1; i < indexPairs.size(); i++) {
            if (indexPairs.get(i)[0] == indexPairs.get(i - 1)[0]) {
                int distance = Math.abs(indexPairs.get(i)[1] - indexPairs.get(i - 1)[1]);
                minDistance = Math.min(minDistance, distance);
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

}

