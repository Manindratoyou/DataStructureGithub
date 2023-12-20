package com.manindra.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8, 10};

        int[] mergedArray = mergeArrays(arr1, arr2);

        System.out.println("Merged Array: " + Arrays.toString(mergedArray));

        System.out.println("=====================================");


        List<Integer> list1 = Arrays.asList(1, 3, 5, 7);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);

        List<Integer> mergedList = mergeLists(list1, list2);

        System.out.println("Merged List: " + mergedList);
    }

    private static int[] mergeArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        int[] mergedArray = new int[n + m];

        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                mergedArray[k++] = arr1[i++];
            } else {
                mergedArray[k++] = arr2[j++];
            }
        }

        while (i < n) {
            mergedArray[k++] = arr1[i++];
        }

        while (j < m) {
            mergedArray[k++] = arr2[j++];
        }

        return mergedArray;
    }

    private static List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) {
        int n = list1.size();
        int m = list2.size();

        List<Integer> mergedList = new ArrayList<>(n + m);

        int i = 0, j = 0;

        while (i < n && j < m) {
            if (list1.get(i) <= list2.get(j)) {
                mergedList.add(list1.get(i++));
            } else {
                mergedList.add(list2.get(j++));
            }
        }

        while (i < n) {
            mergedList.add(list1.get(i++));
        }

        while (j < m) {
            mergedList.add(list2.get(j++));
        }

        return mergedList;
    }
    private static List<Integer> mergeListsUsingStream(List<Integer> list1, List<Integer> list2) {
        return Stream.concat(list1.stream(), list2.stream())
                .sorted()
                .collect(Collectors.toList());
    }

}
