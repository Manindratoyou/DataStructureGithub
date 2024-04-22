package com.manindra.util;

/*
A number is said to be interesting if the following two condition hold true after removing all leading zero from it
The count of odd digit is even
the count of even digit is odd
You are given two integers l and r ,write a java program to find the count of interesting numbers in the range [l,r] l and r inclusive
Example
Number 455 is an interesting integer as
The count of odd digit is 2(5,5)
The count of even digit is 1(4)
 */
public class InterestingNumbers {

    public static void main(String[] args) {

        int l=1,r=9;

        //int count = countInterestingNumbers(l, r);
        //System.out.println("Number of interesting numbers in the range [" + l + ", " + r + "]: " + count);
        int number=455;
        System.out.println(isInteresting(number));
    }

    public static int countInterestingNumbers(int l, int r) {
        int count = 0;
        for (int num = l; num <= r; num++) {
            if (isInteresting(num)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isInteresting(int num) {
        int oddCount = 0, evenCount = 0;
        while (num > 0) {
            int digit = num % 10;
            if (digit == 0) {
                num /= 10; // Skip leading zeros
            } else {
                if (digit % 2 == 0) {
                    evenCount++;
                } else {
                    oddCount++;
                }
                num /= 10;
            }
        }
        return oddCount % 2 == 0 && evenCount % 2 == 1;
    }
}

