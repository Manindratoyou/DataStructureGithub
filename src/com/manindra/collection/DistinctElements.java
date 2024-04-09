package com.manindra.collection;

import java.util.HashSet;
import java.util.Set;

public class DistinctElements {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 1, 2, 5};

        int distinctCount = countDistinctElements(array);
        System.out.println("Number of distinct elements: " + distinctCount);
    }

    public static int countDistinctElements(int[] array) {
        Set<Integer> distinctElements = new HashSet<>();

        for (int element : array) {
            distinctElements.add(element);
        }

        return distinctElements.size();
    }
}

