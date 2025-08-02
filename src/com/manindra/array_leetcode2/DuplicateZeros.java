package com.manindra.array_leetcode2;

import java.util.ArrayList;
import java.util.List;

public class DuplicateZeros { //solution 1089

    public static void main(String[] args) {
        DuplicateZeros dz = new DuplicateZeros();
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        dz.duplicateZeros(arr);
        System.out.print("Modified Array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        // Output: 1 0 0 2 3 0 0 4
    }

    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int zeros = 0;

        // Count the number of zeros that would be duplicated
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                zeros++;
        }

        int i = n - 1;
        int j = n + zeros - 1;

        // Traverse backwards and fill in values
        while (i < j) {
            if (j < n) arr[j] = arr[i];
            if (arr[i] == 0) {
                j--;
                if (j < n) arr[j] = 0;
            }
            i--;
            j--;
        }
    }

    public void duplicateZeros2(int[] arr) {
        List<Integer> temp = new ArrayList<>();

        // Step 1: Create a new list with duplicated zeros
        for (int num : arr) {
            if (num == 0) {
                temp.add(0);
                temp.add(0);
            } else {
                temp.add(num);
            }

            // Stop early if we already have enough elements
            if (temp.size() >= arr.length) break;
        }

        // Step 2: Copy back first n elements to original array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp.get(i);
        }
    }

}

