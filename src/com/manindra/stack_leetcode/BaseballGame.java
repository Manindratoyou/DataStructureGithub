package com.manindra.stack_leetcode;

import java.util.*;

public class BaseballGame { //solution 682

    public static void main(String[] args) {
        String[] ops1 = {"5", "2", "C", "D", "+"};  // Expected: 30
        String[] ops2 = {"5", "-2", "4", "C", "D", "9", "+", "+"};  // Expected: 27

        System.out.println("Total Score: " + calPoints(ops1)); // Output: 30
        System.out.println("Total Score: " + calPoints(ops2)); // Output: 27
    }

    public static int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();

        for (String op : ops) {
            if (op.equals("+")) {
                int last = stack.pop();
                int secondLast = stack.peek();
                int sum = last + secondLast;
                stack.push(last); // push back the last one
                stack.push(sum);
            } else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            } else if (op.equals("C")) {
                stack.pop();
            } else {
                stack.push(Integer.parseInt(op));
            }
        }

        int total = 0;
        for (int score : stack) {
            total += score;
        }
        return total;
    }
}

