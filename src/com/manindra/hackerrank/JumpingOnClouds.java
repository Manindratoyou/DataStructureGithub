package com.manindra.hackerrank;

import java.util.*;

public class JumpingOnClouds {

    static int jumpingOnClouds(List<Integer> c) {
        int jumps = 0;
        int i = 0;

        while (i < c.size() - 1) {
            if (i + 2 < c.size() && c.get(i + 2) == 0) {
                i += 2;
            } else {
                i += 1;
            }
            jumps++;
        }

        return jumps;
    }

    /*
    7
    0 0 1 0 0 1 0
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> c = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            c.add(scanner.nextInt());
        }
        scanner.close();

        int result = jumpingOnClouds(c);
        System.out.println(result);
    }
}

