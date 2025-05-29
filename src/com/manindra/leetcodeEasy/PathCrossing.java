package com.manindra.leetcodeEasy;

import java.util.HashSet;
import java.util.Set;

public class PathCrossing { //solution 1496

    public static void main(String[] args) {
        PathCrossing solution = new PathCrossing();

        System.out.println(solution.isPathCrossing("NES"));        // false
        System.out.println(solution.isPathCrossing("NESWW"));      // true
        System.out.println(solution.isPathCrossing("NENESSWWS"));  // true
    }

    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();

        int x = 0;
        int y = 0;
        set.add("0,0");

        for (char c : path.toCharArray()) {
            if (c == 'N') {
                y++;
            } else if (c == 'S') {
                y--;
            } else if (c == 'E') {
                x++;
            } else if (c == 'W') {
                x--;
            }

            String coord = x + "," + y;
            if (set.contains(coord)) {
                return true;
            }
            set.add(coord);
        }

        return false;
    }
}

