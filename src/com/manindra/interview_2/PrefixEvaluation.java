package com.manindra.interview_2;

import java.util.Stack;

public class PrefixEvaluation {
    public static void main(String[] args) {
        System.out.println(evaluatePrefix("+23")); // Output: 5
        System.out.println(evaluatePrefix("+*235")); // Output: 11
        System.out.println(evaluatePrefix("+*523")); // Output 13
        System.out.println(evaluatePrefix("+9*26")); // 21
    }

    public static int evaluatePrefix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            } else {
                int operand1 = stack.pop();
                int operand2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(operand1 + operand2);
                        break;
                    case '-':
                        stack.push(operand1 - operand2);
                        break;
                    case '*':
                        stack.push(operand1 * operand2);
                        break;
                    case '/':
                        stack.push(operand1 / operand2);
                        break;
                }
            }
        }

        return stack.pop();
    }
}

