package com.manindra.basics;

import java.util.HashSet;
import java.util.Set;

/*
Input: n = 19
Output: True
19 is Happy Number,
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
As we reached to 1, 19 is a Happy Number.
 */
/*
Time Complexity: O(n*log(n)).
Auxiliary Space: O(1).
 */
public class HappyNumber {

    public static void main(String[] args) {

        System.out.println(Math.pow(3,3));
        //int n = 13;//61
        int n = 61;
        //if (isHappynumber(n))
        if (isHappy(n))
            System.out.println(n +
                    " is a Happy number");
        else
            System.out.println(n +
                    " is not a Happy number");
    }

    //  method return true if n is Happy number
    static boolean isHappynumber(int n)
    {
        int slow, fast;

        //  initialize slow and fast by n
        slow = fast = n;
        do
        {
            //  move slow number
            // by one iteration
            slow = numSquareSum(slow);

            //  move fast number
            // by two iteration
            fast = numSquareSum(numSquareSum(fast));

        }
        while (slow != fast);

        //  if both number meet at 1,
        // then return true
        return (slow == 1);
    }
    // Utility method to return sum of square of digit of n
    static int numSquareSum(int n)
    {
        int squareSum = 0;
        while (n!= 0)
        {
            squareSum += (n % 10) * (n % 10);
            n /= 10;
        }
        return squareSum;
    }


    static boolean isHappy(int n) {

        Set<Integer> usedIntegers = new HashSet<>();
        while (true) {

            // Find the sum of squares
            int sum = 0;
            while (n != 0) {
                sum += Math.pow(n % 10, 2.0);
                n = n / 10;
            }

            // If sum is 1, return true
            if (sum == 1)
                return true;

            // Else, the new number is the current sum
            n = sum;

            // Check if we have already encountered
            // that number
            if (usedIntegers.contains(n))
                return false;
            usedIntegers.add(n);
        }
    }


}
