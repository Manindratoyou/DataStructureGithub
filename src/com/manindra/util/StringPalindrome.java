package com.manindra.util;

public class StringPalindrome {

    public static void main(String[] args) {

        System.out.println(isPalindrome("madam"));
    }

    static boolean isPalindrome(String word){
        char[] charArray=word.toCharArray();
        int start=0;
        int end=word.length()-1;//charArray.length-1
        while (start<end){
            if (charArray[start]!=charArray[end])
                return false;
            start++;
            end--;
        }
        return true;
    }
}
