package com.manindra.leetcode;

public class Solution344 { // reverse String

    public static void main(String[] args) {
        char [] inputArray={'h','e','l','l','o'};
        reverseString(inputArray);
        System.out.println("Reverse Array ");
        for (char ch : inputArray)
            System.out.print(ch+" ");
    }

    public static void reverseString(char [] s){
        int left=0;
        int right=s.length-1;

        while (left<right){
            //swap character at left and right pointers
            char temp=s[left];
            s[left]=s[right];
            s[right]=temp;

            //move the pointers towards center
            left++;
            right--;

        }
    }
}
