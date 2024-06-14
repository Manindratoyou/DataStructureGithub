package com.manindra.dynamicProgramming_ds;

public class LongestIncreasingSubsequence2 { // part2

    public static void main(String[] args) { // TC: O(n log n)

        int[] inputArray = {3, 4, 2, 8, 10, 5, 1};
        System.out.println(findLISLength(inputArray));
    }

    static int findLISLength(int[] inputArray) {
        int arrayLength = inputArray.length;
        int[] tailTable = new int[arrayLength];
        int lisLength = 1;
        tailTable[0] = inputArray[0];

        for (int i = 1; i < arrayLength; i++) {
            if (inputArray[i] > tailTable[lisLength - 1]) {
                tailTable[lisLength] = inputArray[i];
                lisLength++;
            } else {
                int ceilIndex = findCeilIndex(tailTable, 0, lisLength - 1, inputArray[i]);
                tailTable[ceilIndex] = inputArray[i];
            }
        }
        return lisLength;
    }

    static int findCeilIndex(int[] tailTable, int left, int right, int key) {
        while (right > left) {
            int middle = left + (right - left) / 2;
            if (tailTable[middle] >= key)
                right = middle;
            else
                left = middle + 1;
        }
        return right;
    }
}
