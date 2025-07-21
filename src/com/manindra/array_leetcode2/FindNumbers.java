package com.manindra.array_leetcode2;

public class FindNumbers { //solution 1295

    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896};
        System.out.println(findNumbers(nums)); // Output: 2
    }


    //Approach 1: Convert to String
    //Time Complexity: O(n × d), where d is the number of digits in the number
    //Space Complexity: O(1) (ignoring string creation overhead)
    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    //Approach 2: Count Digits Without Converting to String
    //Time Complexity: O(n × log₁₀(num))
    //Space Complexity: O(1)
    public static int findNumbers2(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int digits = 0;
            while (num > 0) {
                digits++;
                num /= 10;
            }
            if (digits % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    //Approach 3: Math Range-Based (Hardcoded Ranges)
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static int findNumbers3(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if ((num >= 10 && num <= 99) || (num >= 1000 && num <= 9999) || num == 100000) {
                count++;
            }
        }
        return count;
    }

    public static int findNumbers4(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int digitCount = countDigit(num);
            if (digitCount % 2 == 0)
                count++;
        }
        return count;
    }

    static int countDigit(int n) {
        int res = 0;
        while (n > 0) {
            n = n / 10;
            res++;
        }
        return res;
    }
}
