package com.manindra.hackerrank;

import java.util.Arrays;

public class Pairs {

    public static void main(String[] args) {
        // Test cases
        int[] numbers1 = {1, 5, 3, 4, 2};
        int difference1 = 2;
        System.out.println("Test Case 1: " + countPairWithDifferenceK(difference1, numbers1));

        int[] numbers2 = {1, 3, 5, 7, 9};
        int difference2 = 4;
        System.out.println("Test Case 2: " + countPairWithDifferenceK(difference2, numbers2));

        // Add more test cases as needed
    }

    static int countPairWithDifferenceK(int difference,int [] numbers){
        //sort the array
        Arrays.sort(numbers);

        int pairCount=0;
        for (int num: numbers){
            int targetNumber=num-difference;
            if (binarySearch(numbers,targetNumber))
                pairCount++;
        }
        return pairCount;
    }
    static boolean binarySearch(int [] sortedArray,int target){
        int left=0,right= sortedArray.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (sortedArray[mid]==target)
                return true;
            if (sortedArray[mid]<target)
                left=mid+1;
            else
                right=mid-1;
        }
        return false;
    }
}
