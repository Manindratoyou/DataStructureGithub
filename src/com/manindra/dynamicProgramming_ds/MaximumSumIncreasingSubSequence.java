package com.manindra.dynamicProgramming_ds;

public class MaximumSumIncreasingSubSequence {

    public static void main(String[] args) {

        int[] inputArray = {3, 20, 4, 6, 7, 30}; // Expected output: 53 (3 + 20 + 30)
        System.out.println(findMSIS(inputArray));

    }

    static int findMSIS(int[] inputArray) {
        int arrayLength = inputArray.length;
        int[] msisArray = new int[arrayLength];

        // Initialize msisArray with inputArray values
        for (int i = 0; i < arrayLength; i++) {
            msisArray[i] = inputArray[i];
            for (int j = 0; j < i; j++) {
                if (inputArray[j] < inputArray[i]) {
                    msisArray[i] = Math.max(msisArray[i], inputArray[i] + msisArray[j]);
                }
            }
        }

        // Find the maximum value in msisArray
        int maxSum = msisArray[0];
        for (int i = 1; i < arrayLength; i++) {
            maxSum = Math.max(maxSum, msisArray[i]);
        }

        return maxSum;
    }
}
