package com.manindra.stack_leetcode;

import java.util.*;

public class AsteroidCollision { //solution 735

    public static void main(String[] args) {
        int[] test1 = {5, 10, -5};
        System.out.println(Arrays.toString(asteroidCollision(test1))); // [5, 10]

        int[] test2 = {8, -8};
        System.out.println(Arrays.toString(asteroidCollision(test2))); // []

        int[] test3 = {10, 2, -5};
        System.out.println(Arrays.toString(asteroidCollision(test3))); // [10]

        int[] test4 = {-2, -1, 1, 2};
        System.out.println(Arrays.toString(asteroidCollision(test4))); // [-2, -1, 1, 2]
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            boolean alive = true;

            // Process only if current is moving left and stack top is moving right
            while (alive && ast < 0 && !stack.isEmpty() && stack.peek() > 0) {
                if (stack.peek() < -ast) {
                    stack.pop(); // smaller right-moving asteroid explodes
                } else if (stack.peek() == -ast) {
                    stack.pop(); // both explode
                    alive = false;
                } else {
                    alive = false; // current left-moving explodes
                }
            }

            if (alive) {
                stack.push(ast);
            }
        }

        // Convert to array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

}

