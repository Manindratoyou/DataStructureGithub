package com.manindra.hackerrank;

import java.util.Scanner;

public class CountingValleys {

    static int countingValleys(int steps, String path) {
        int altitude = 0;
        int valleys = 0;

        for (char step : path.toCharArray()) {
            if (step == 'U') {
                altitude++;
                if (altitude == 0) {
                    valleys++;
                }
            } else if (step == 'D') {
                altitude--;
            }
        }

        return valleys;
    }

    public static int countingValleys2(int steps, String path) {
        int sum = 0;
        int vally = 0;
        for (int i = 0; i < steps; i++) {
            if (path.charAt(i) == 'U') {
                if (sum == -1) {
                    vally++;
                }
                sum++;
            } else {
                sum--;
            }
        }
        return vally;
    }

    /*

    _/\      _
   \    /
    \/\/

    8
    UDDDUDUU
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int steps = scanner.nextInt();
        String path = scanner.next();
        scanner.close();

        //int result = countingValleys(steps, path);
        int result = countingValleys2(steps, path);
        System.out.println(result);
    }
}

