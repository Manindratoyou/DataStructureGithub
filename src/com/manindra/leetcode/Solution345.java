package com.manindra.leetcode;

public class Solution345 { //Reverse Vowels

    public static void main(String[] args) {
        String inputString="hello";
        String reversedVowels=reverseVowels(inputString);
        System.out.println("Reversed Vowels = "+reversedVowels);
    }

    public static String reverseVowels(String input){
        char [] chars=input.toCharArray();
        int left=0;
        int right= chars.length-1;
        while (left<right && !isVowel(chars[left]))
            left++;
        while (left<right && !isVowel(chars[right]))
            right--;
        //swap vowels at left and right pointers
        char temp=chars[left];
        chars[left]=chars[right];
        chars[right]=temp;

        //move the pointer to center
        left++;
        right--;

        return new String(chars);
    }

    public static boolean isVowel(char c){
        return "aeiouAEIOU".indexOf(c) !=-1;
    }
}
