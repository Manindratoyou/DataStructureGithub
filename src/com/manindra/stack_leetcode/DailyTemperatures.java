package com.manindra.stack_leetcode;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures { //solution739

    public static void main(String[] args) {

        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperatures(temperatures);
        int[] result1 = dailyTemperatures2(temperatures);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result1));
    }


    static int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            //popping all indices with a lower or equal
            //temperature than the current index

            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            //if the stack still has elements then the next warmer temperature exists!
            if (!stack.isEmpty()) {
                result[i] = stack.peek() - i;
            }
            //inserting current index in the stack
            stack.push(i);
        }
        return result;
    }

    static int[] dailyTemperatures2(int[] temperatures) { // time limit exceed

        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                Integer pop = stack.pop();
                result[pop] = i - pop;
            }
            stack.push(i);
        }
        return result;
    }

    static int[] dailyTemperatures3(int[] temperatures) { // time limit exceed

        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int current = temperatures[i];
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > current) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }
}
