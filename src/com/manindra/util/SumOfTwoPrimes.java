package com.manindra.util;

/*
Check if a prime number can be expressed as sum of two Prime Numbers
Input: N = 13
Output: Yes
Explanation: The number 13 can be written as 11 + 2,
here 11 and 2 are both prime.
Input: N = 11
Output: No
 */
public class SumOfTwoPrimes {

    public static void main(String[] args) {

        int n=34;
        int n1=13;
        int n2=11;
        System.out.println(isSumOfTwoPrimes(n));
        System.out.println("-----------");
        System.out.println(isSumOfTwoPrimes(n1));
        System.out.println("===================");
        System.out.println(isSumOfTwoPrimes(n2));
    }

    // if the number is prime,
    // and number-2 is also prime
    static boolean isSumOfTwoPrimes(int n){
        for (int i = 2; i <= n / 2; ++i) {
            if (isPrimeSolutionTwo(i) && isPrimeSolutionTwo(n - i)) {
                System.out.println("Prime numbers: " + i + " and " + (n - i));
                return true;
            }
        }
        return false;
    }

    static boolean isPrimeSolutionTwo(int n){ //O(sqrt(n))-time complexity
        if (n==1)
            return false;
        for (int i=2;i*i<=n;i++){ //for (int i=2;i<Math.sqrt(n);i++){
            if (n%i==0)
                return false;
        }
        return true;
    }
}
