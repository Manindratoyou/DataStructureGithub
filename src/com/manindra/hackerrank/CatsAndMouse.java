package com.manindra.hackerrank;

public class CatsAndMouse {

    public static void main(String[] args) { //CAT A ,CAT B, MOUSE
        System.out.println(findWinner(2,5,4));
        System.out.println(findWinner(1,2,3));
        System.out.println(findWinner(1,3,2));
    }

    public static String findWinner(int x, int y, int z) {
        int distanceA = Math.abs(z - x); // Distance between Cat A and the mouse
        int distanceB = Math.abs(z - y); // Distance between Cat B and the mouse

        if (distanceA < distanceB) {
            return "Cat A";
        } else if (distanceB < distanceA) {
            return "Cat B";
        } else {
            return "Mouse C"; // Both cats reach the mouse at the same time
        }
    }
}
