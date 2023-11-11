package com.manindra.leetcode;

import java.util.HashSet;

public class Solution202 { //Happy Number

    public static void main(String[] args) {

        Solution202 solution = new Solution202();

// Sample Input: 19
// Explanation: 1^2 + 9^2 = 82, 8^2 + 2^2 = 68, 6^2 + 8^2 = 100, 1^2 + 0^2 + 0^2 = 1
        boolean result1 = solution.isHappy(19); // Output: true

// Sample Input: 4
// Explanation: 4^2 = 16, 1^2 + 6^2 = 37, 3^2 + 7^2 = 58, 5^2 + 8^2 = 89, 8^2 + 9^2 = 145,
// 1^2 + 4^2 + 5^2 = 42, 4^2 + 2^2 = 20, 2^2 + 0^2 = 4 (loop detected)
        boolean result2 = solution.isHappy(4); // Output: false

// Sample Input: 7
// Explanation: 7^2 = 49, 4^2 + 9^2 = 97, 9^2 + 7^2 = 130, 1^2 + 3^2 + 0^2 = 10, 1^2 + 0^2 = 1
        boolean result3 = solution.isHappy(7); // Output: true

// Sample Input: 100
// Explanation: 1^2 + 0^2 + 0^2 = 1
        boolean result4 = solution.isHappy(100); // Output: true

// Sample Input: 123
// Explanation: 1^2 + 2^2 + 3^2 = 14, 1^2 + 4^2 = 17, 1^2 + 7^2 = 50, 5^2 + 0^2 = 25, 2^2 + 5^2 = 29,
// 2^2 + 9^2 = 85, 8^2 + 5^2 = 89, 8^2 + 9^2 = 145, 1^2 + 4^2 + 5^2 = 42, 4^2 + 2^2 = 20, 2^2 + 0^2 = 4 (loop detected)
        boolean result5 = solution.isHappy(123); // Output: false

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);

    }

    public boolean isHappy(int n){
        HashSet<Integer> seen=new HashSet<>();
        while (n !=1 && !seen.contains(n)){
            seen.add(n);
            n=getNext(n);
        }
        return n==1;
    }
    private int getNext(int n){
        int sum=0;
        while (n>0){
            int digit=n%10;
            sum+=digit*digit;
            n/=10;
        }
        return sum;
    }

    public boolean isHappySolutionTwo(int n){
        int slow=n;
        int fast=n;

        do {
            slow=getNext(slow);
            fast=getNext(getNext(fast));
        }while (slow !=fast);

        return slow==1;
    }
}
