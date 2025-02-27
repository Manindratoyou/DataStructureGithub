package com.manindra.iitp.labAI;

import java.util.*;

class AStarSearch {
    static class Node {
        int x, y, g, h, f;
        Node parent;

        Node(int x, int y, int g, int h, Node parent) {
            this.x = x;
            this.y = y;
            this.g = g;
            this.h = h;
            this.f = g + h;
            this.parent = parent;
        }
    }

    private static final int[][] grid = {
            {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 1},
            {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
            {0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
            {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
            {1, 1, 1, 0, 0, 0, 1, 0, 0, 1},
            {1, 1, 1, 0, 0, 0, 1, 0, 0, 1}
    };

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    private static int heuristic(int x, int y) {
        return (int) Math.sqrt((9 - x) * (9 - x) + (0 - y) * (0 - y));
    }

    public static void aStarSearch() {
        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingInt(n -> n.f));
        boolean[][] closedList = new boolean[10][10];

        openList.add(new Node(0, 0, 0, heuristic(0, 0), null));

        while (!openList.isEmpty()) {
            Node current = openList.poll();
            if (current.x == 9 && current.y == 0) {
                System.out.println("Path found!");
                return;
            }
            closedList[current.x][current.y] = true;

            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];

                if (newX >= 0 && newX < 10 && newY >= 0 && newY < 10 && grid[newX][newY] == 1 && !closedList[newX][newY]) {
                    openList.add(new Node(newX, newY, current.g + 1, heuristic(newX, newY), current));
                }
            }
        }
        System.out.println("No path found!");
    }

    public static void main(String[] args) {
        System.out.println("Solving A* Search on 10x10 Grid:");
        aStarSearch();
    }
}

