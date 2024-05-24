package com.manindra.util;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> subsets = subsets(arr);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }

    public static List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for (int i = 0; i < arr.length; i++) {
            List<List<Integer>> newSubsets = new ArrayList<>();
            for (List<Integer> subset : subsets) {
                List<Integer> newSubset = new ArrayList<>(subset);
                newSubset.add(arr[i]);
                newSubsets.add(newSubset);
            }
            subsets.addAll(newSubsets);
        }
        return subsets;
    }
}
