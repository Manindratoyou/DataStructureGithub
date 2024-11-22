package com.manindra.graph_ds;

import java.util.*;

class BoruvkaMST {
    static class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        int edgesCount = 6;

        Edge[] edges = {
                new Edge(0, 1, 1), // A-B
                new Edge(1, 2, 3), // B-C
                new Edge(2, 3, 4), // C-D
                new Edge(3, 4, 2), // D-E
                new Edge(4, 0, 5), // E-A
                new Edge(1, 3, 2)  // B-D
        };

        boruvkaMST(vertices, edges, edgesCount);
    }

    static void boruvkaMST(int vertices, Edge[] edges, int edgesCount) {
        int[] parent = new int[vertices];
        int[] cheapest = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            parent[i] = i;
        }

        int mstEdges = 0, totalWeight = 0;

        while (mstEdges < vertices - 1) {
            Arrays.fill(cheapest, -1);

            for (int i = 0; i < edgesCount; i++) {
                int set1 = find(parent, edges[i].src);
                int set2 = find(parent, edges[i].dest);

                if (set1 != set2) {
                    if (cheapest[set1] == -1 || edges[cheapest[set1]].weight > edges[i].weight) {
                        cheapest[set1] = i;
                    }
                    if (cheapest[set2] == -1 || edges[cheapest[set2]].weight > edges[i].weight) {
                        cheapest[set2] = i;
                    }
                }
            }

            for (int i = 0; i < vertices; i++) {
                if (cheapest[i] != -1) {
                    int set1 = find(parent, edges[cheapest[i]].src);
                    int set2 = find(parent, edges[cheapest[i]].dest);

                    if (set1 != set2) {
                        union(parent, set1, set2);
                        mstEdges++;
                        totalWeight += edges[cheapest[i]].weight;
                        System.out.println("Edge: " + edges[cheapest[i]].src + " - " + edges[cheapest[i]].dest + " | Weight: " + edges[cheapest[i]].weight);
                    }
                }
            }
        }

        System.out.println("Total Weight: " + totalWeight);
    }

    static int find(int[] parent, int i) {
        if (parent[i] != i) {
            parent[i] = find(parent, parent[i]);
        }
        return parent[i];
    }

    static void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        parent[rootY] = rootX;
    }
}

