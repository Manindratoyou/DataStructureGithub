package com.manindra.leetcodeEasy;

public class ReverseString2 { //solution 541

    public static void main(String[] args) {

        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStringK(s,k));
    }

    static void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    static String reverseStringK(String s, int k) {
        char[] arr = s.toCharArray();
        int i = 0, n = arr.length;
        while (i < n) {
            int j = Math.min(i + k - 1, n - 1);
            reverse(arr, i, j);
            i = i + 2 * k;
        }
        return new String(arr);
    }
}
