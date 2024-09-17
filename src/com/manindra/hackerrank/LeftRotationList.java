package com.manindra.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftRotationList {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        int k = 3;

        // Uncomment one of the following methods to perform the rotation
        // leftRotate(list, k);
        leftRotateUsingReverse(list, k);

        System.out.println(list);
    }

    static void leftRotate(List<Integer> list, int k) {
        k %= list.size();
        List<Integer> temp = new ArrayList<>(list.subList(0, k));

        // Shift the rest of the list
        for (int i = 0; i < list.size() - k; i++) {
            list.set(i, list.get(i + k));
        }

        // Place back the first k elements
        for (int i = 0; i < temp.size(); i++) {
            list.set(list.size() - k + i, temp.get(i));
        }
    }

    // Helper function to reverse a sublist from start index to end index
    static void reverse(List<Integer> list, int start, int end) {
        while (start < end) {
            int temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;
            end--;
        }
    }

    static void leftRotateUsingReverse(List<Integer> list, int k) {
        k %= list.size();

        // Reverse the entire list
        reverse(list, 0, list.size() - 1);

        // Reverse the first list.size() - k elements
        reverse(list, 0, list.size() - k - 1);

        // Reverse the last k elements
        reverse(list, list.size() - k, list.size() - 1);
    }
}

