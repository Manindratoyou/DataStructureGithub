package com.manindra.mathematics;

public class NumberPalindrome {

    public static void main(String[] args) {
        System.out.println(palindrome(363));
        System.out.println(palindrome(78987));
        System.out.println(palindrome(8));
        System.out.println(palindrome(89));
        System.out.println("-------------------------");
        System.out.println(3 % 10);
        System.out.println(3 / 10);
        System.out.println(13 % 10);
        System.out.println(13 / 10);
    }

    static boolean palindrome(int number) {
        int rev = 0;
        int temp = number;
        while (temp != 0) {
            int ld = temp % 10;
            rev = rev * 10 + ld;
            temp = temp / 10;
        }
        return rev == number;
    }
}
