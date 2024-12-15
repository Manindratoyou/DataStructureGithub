package com.manindra.hackerrank;

public class FindDigits {

    public static void main(String[] args) {

        int var1 = 1012;
        int var2 = 124;
        System.out.println(findDigits(var1));
        System.out.println(countDivisors(var2));

    }

    public static int findDigits(int n) {
        int temp = n;
        int count = 0;
        while (temp != 0) {
            int a = temp % 10;
            if (a==0) {
                temp=temp/10;
                continue;
            }
            if (n%a==0)
                count++;
            temp=temp/10;
        }
        return count;
    }

    public static int countDivisors(int n) {
        int originalNumber = n;
        int count = 0;

        while (n > 0) {
            int digit = n % 10; // Get the last digit
            if (digit != 0 && originalNumber % digit == 0) {
                count++; // Increment if the digit divides the number
            }
            n /= 10; // Remove the last digit
        }

        return count;
    }
}
