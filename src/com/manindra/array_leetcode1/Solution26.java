package com.manindra.array_leetcode1;

public class Solution26 { //Remove Duplicates from Sorted Array

    public static void main(String[] args) {

        int[] arr = {1, 1, 2};
        int[] arr1 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        //int n = removeDuplicates(arr1);
        int n = removeDuplicates2(arr1);
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }

    }

    static int removeDuplicates(int[] arr) {
        int result = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[result] = arr[i];
                result++;
            }
        }
        return result;
    }

    static int removeDuplicates2(int[] nums) {
        int n = nums.length;
        int i = 0, j = 1;
        while (j < n) {
            if (nums[i] != nums[j]) { //got a unique element
                i++;
                nums[i] = nums[j];
            }
            j++;//to find unique element
        }
        return i + 1;
    }
}
