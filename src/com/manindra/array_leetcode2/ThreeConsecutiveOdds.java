package com.manindra.array_leetcode2;

public class ThreeConsecutiveOdds { //solution 1550

    public static void main(String[] args) {
        int[] arr1 = {2, 6, 4, 1};
        int[] arr2 = {1, 2, 34, 3, 4, 5, 7, 23, 12};
        System.out.println(threeConsecutiveOdds(arr1)); // false
        System.out.println(threeConsecutiveOdds(arr2)); // true
    }

    public static boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 == 1) {
                count++;
                if (count == 3)
                    return true;
            } else {
                count = 0; // reset count on even number
            }
        }
        return false;
    }

    public static boolean threeConsecutiveOdds2(int[] arr) {
        int n = arr.length;
        if (n < 3)
            return false;

        for (int i = 0; i <= n - 3; i++) {
            //if ((arr[i] & 1) == 1 && (arr[i + 1] & 1) == 1 && (arr[i + 2] & 1) == 1) {
            if (arr[i] % 2 == 1 && arr[i + 1] % 2 == 1 && arr[i + 2] % 2 == 1) {
                return true;
            }
        }

        return false;
    }

}

