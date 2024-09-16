package com.manindra.interview_2;

import java.util.Stack;

public class PostfixEvaluation {

    public static void main(String[] args) {
        System.out.println(evaluatePostfix("23+")); // Output: 5
        System.out.println(evaluatePostfix("23*5+")); // Output: 11
        System.out.println(evaluatePostfix("52*3+")); // Output: 13
        System.out.println(evaluatePostfix("231*+9-")); //
    }

    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(Character.getNumericValue(c));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

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

