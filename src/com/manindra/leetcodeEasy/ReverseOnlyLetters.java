package com.manindra.leetcodeEasy;

import java.util.Stack;

public class ReverseOnlyLetters { //solution 917

    public static void main(String[] args) {

        String s = "a-bC-dEf-ghIj";
        System.out.println(reverseOnlyLetters(s));
        System.out.println(reverseOnlyLettersStack(s));
    }

    static String reverseOnlyLetters(String s) {

        //convert the string to the character array
        char[] charArray = s.toCharArray();

        //get the left and right pointers
        int left = 0;
        int right = charArray.length - 1;

        //start the loop and compare characters
        while (left < right) {

            //if left is not a letter ,move right
            if (!Character.isLetter(charArray[left]))
                left++;
                //if right is not letter ,move left
            else if (!Character.isLetter(charArray[right])) {
                right--;
            }
            //if both are letters,swap them
            else {
                char temp = charArray[left];
                charArray[left++] = charArray[right];
                charArray[right--] = temp;
            }
        }
        //convert the character array to a string
        return new String(charArray);
    }

    static String reverseOnlyLettersStack(String s) {

        //convert the string to a character array
        char[] arr = s.toCharArray();


        //create a stack to store letters
        Stack<Character> stack = new Stack<>();

        //push letters into stack
        for (char c : arr) {
            if (Character.isLetter(c)) {
                stack.push(c);
            }
        }

        //pop letters from the stack and replace them in the array
        for (int i = 0; i < arr.length; i++) {

            if (Character.isLetter(arr[i])) {
                arr[i] = stack.pop();
            }
        }
        //convert the character array to string array
        return new String(arr);
    }

    static String reverseOnlyLettersStack2(String s) {

        Stack<Character> stack = new Stack<>();

        //push all the letters onto the stack
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c))
                stack.push(c);
        }
        //build the result string
        StringBuilder result = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c))
                result.append(stack.pop());
            else
                result.append(c);
        }
        return result.toString();
    }

    static String reverseOnlyLetters5(String s) {

        int i = 0;
        int j = s.length();
        char[] arr = s.toCharArray();
        while (i < j) {
            if (isEnglish(arr[i])) {
                while (!isEnglish(arr[j])) { //ab-cd123-
                    j--;
                }
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
            }
            i++;
        }
        return new String(arr);
    }

    static boolean isEnglish(char c) {
        return (65 <= c && c <= 90) || (97 <= c && c <= 122);
    }
}
