package com.manindra.leetcode;

public class Solution345 { //Reverse Vowels

    public static void main(String[] args) {
        String inputString = "hello";
        String reversedVowels = reverseVowels(inputString);
        System.out.println("Reversed Vowels = " + reversedVowels);
    }

    public static String reverseVowels(String input) {
        char[] chars = input.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right && !isVowel(chars[left]))
            left++;
        while (left < right && !isVowel(chars[right]))
            right--;
        //swap vowels at left and right pointers
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;

        //move the pointer to center
        left++;
        right--;

        return new String(chars);
    }

    public static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    static String reverseVowels2(String s) {
        StringBuilder sb = new StringBuilder(s);
        int n = sb.length();
        int i = 0, j = n - 1;
        while (i < j) {
            if (!isVowel2(sb.charAt(i)))
                i++;
            else if (!isVowel2(sb.charAt(j))) {
                j--;
            } else {
                //swap sb.charAt(i) with sb.charAt(j)
                char temp = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, sb.charAt(temp));
                i++;
                j--;
            }
        }
        return sb.toString();
    }

    static boolean isVowel2(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
