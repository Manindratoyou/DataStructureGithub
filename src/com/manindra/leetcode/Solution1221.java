package com.manindra.leetcode;

import java.util.Stack;

/*
Input: s = "RLRRLLRLRL"
Output: 4
Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
 */
public class Solution1221 { //Split a String in Balanced Strings

    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        System.out.println(balancedStringSplit(s));
        System.out.println(balancedStringSplitSolutionTwo(s));
    }

    //Time Complexity: O(n) where n is the length of the input string.
    //Auxiliary Space: O(1)
    static int balancedStringSplit(String s) {
        int balance = 0;
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'L') {
                balance++;
            } else {
                balance--;
            }

            if (balance == 0) {
                count++;
            }
        }

        return count;
    }

    static int balancedStringSplitSolutionTwo(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() != ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }

            if (stack.isEmpty()) {
                count++;
            }
        }

        return count;
    }

}
