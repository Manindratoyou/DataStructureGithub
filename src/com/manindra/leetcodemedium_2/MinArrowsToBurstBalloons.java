package com.manindra.leetcodemedium_2;

import java.util.Arrays;

public class MinArrowsToBurstBalloons { //solution 452

    public static void main(String[] args) {
        MinArrowsToBurstBalloons obj = new MinArrowsToBurstBalloons();
        int[][] points = {{10,16}, {2,8}, {1,6}, {7,12}};
        System.out.println("Minimum arrows needed: " + obj.findMinArrowShots(points)); // Output: 2
    }

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // Sort by end coordinate
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int lastArrowPos = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > lastArrowPos) {
                arrows++;
                lastArrowPos = points[i][1];
            }
        }

        return arrows;
    }
}

