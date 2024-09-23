package com.manindra.leetcodemedium_2;

public class SumOfSquareNumbers {

    public static void main(String[] args) { //solution 633

        SumOfSquareNumbers solution = new SumOfSquareNumbers();

        int c = 5;
        boolean result = solution.judgeSquareSum(c);
        System.out.println("Can " + c + " be expressed as the sum of two squares? " + result); // Expected output: true

        int d = 3;
        boolean result2 = solution.judgeSquareSum(d);
        System.out.println("Can " + d + " be expressed as the sum of two squares? " + result2); // Expected output: false

        int e = 73;
        boolean result3 = solution.judgeSquareSum(c);
        System.out.println("Can " + e + " be expressed as the sum of two squares? " + result); // Expected output: true

    }


    boolean judgeSquareSum(int c) {

        // Base case
        if (c < 0) return false;

        // Two pointers
        long left = 0;
        long right = (int) Math.sqrt(c);

        while (left <= right) {
            long sum = left * left + right * right;

            if (sum == c)
                return true;
            else if (sum < c)
                left++;
            else
                right--;
        }

        return false;
    }

}
