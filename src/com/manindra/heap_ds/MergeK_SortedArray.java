package com.manindra.heap_ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeK_SortedArray {

    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        list1.add(10);
        list1.add(20);
        list1.add(30);

        List<Integer> list2 = new ArrayList<>();
        list2.add(5);
        list2.add(15);

        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(9);
        list3.add(11);
        list3.add(18);

        list.add(list1);
        list.add(list2);
        list.add(list3);

        printListOfLists(list);
        System.out.println("Merged list using solution 1: " + mergeArrays(list));
        System.out.println("Merged list using solution 2: " + mergeKArraysSolutionTwo(list));
    }

    public static void printListOfLists(List<List<Integer>> listOfLists) {
        for (List<Integer> innerList : listOfLists) {
            System.out.println(innerList);
        }
    }

    // Solution 1: Flatten the lists and then sort
    static List<Integer> mergeArrays(List<List<Integer>> lists) {
        List<Integer> result = new ArrayList<>();
        for (List<Integer> list : lists) {
            result.addAll(list);
        }
        Collections.sort(result);
        return result;
    }

    // Helper function to merge two sorted lists
    static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        int i = 0, j = 0;
        List<Integer> list3 = new ArrayList<>();
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j))
                list3.add(list1.get(i++));
            else
                list3.add(list2.get(j++));
        }
        while (i < list1.size())
            list3.add(list1.get(i++));
        while (j < list2.size())
            list3.add(list2.get(j++));
        return list3;
    }

    // Solution 2: Iteratively merge lists using the merge helper function
    static List<Integer> mergeKArraysSolutionTwo(List<List<Integer>> lists) {
        if (lists.isEmpty()) {
            return new ArrayList<>(); // Handle edge case where lists might be empty
        }
        List<Integer> result = lists.get(0);
        for (int i = 1; i < lists.size(); i++) {
            result = merge(result, lists.get(i));
        }
        return result;
    }
}
