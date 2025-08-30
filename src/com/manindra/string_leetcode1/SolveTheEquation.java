package com.manindra.string_leetcode1;

public class SolveTheEquation { //solution 640

    public static void main(String[] args) {
        System.out.println(solveEquation("x+5-3+x=6+x-2"));  // x=2
        System.out.println(solveEquation("x=x"));            // Infinite solutions
        System.out.println(solveEquation("2x=x"));           // x=0
        System.out.println(solveEquation("2x+3x-6x=x+2"));   // x=-1
        System.out.println(solveEquation("x=x+2"));          // No solution
    }

    public static String solveEquation(String equation) {
        String[] sides = equation.split("=");
        int[] left = evaluate(sides[0]);
        int[] right = evaluate(sides[1]);

        // Bring everything to left-hand side
        int coeff = left[0] - right[0]; // coefficient of x
        int constVal = right[1] - left[1]; // constants

        if (coeff == 0 && constVal == 0) {
            return "Infinite solutions";
        } else if (coeff == 0) {
            return "No solution";
        } else {
            return "x=" + constVal / coeff;
        }
    }

    private static int[] evaluate(String expr) {
        int coeff = 0, constVal = 0;
        String[] tokens = expr.replace("-", "+-").split("\\+");

        for (String token : tokens) {
            if (token.equals("")) continue;
            if (token.equals("x")) {
                coeff += 1;
            } else if (token.equals("-x")) {
                coeff -= 1;
            } else if (token.contains("x")) {
                coeff += Integer.parseInt(token.substring(0, token.length() - 1));
            } else {
                constVal += Integer.parseInt(token);
            }
        }
        return new int[]{coeff, constVal};
    }

}

