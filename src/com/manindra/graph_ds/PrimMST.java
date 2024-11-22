package com.manindra.graph_ds;

import java.util.*;

class PrimMST {
    static class Edge {
        int vertex, weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        List<List<Edge>> graph = new ArrayList<>();

        // Initialize adjacency list for graph
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges to the graph
        addEdge(graph, 0, 1, 1); // A-B
        addEdge(graph, 1, 2, 3); // B-C
        addEdge(graph, 2, 3, 4); // C-D
        addEdge(graph, 3, 4, 2); // D-E
        addEdge(graph, 4, 0, 5); // E-A
        addEdge(graph, 1, 3, 2); // B-D

        primMST(graph, vertices);
    }

    static void addEdge(List<List<Edge>> graph, int src, int dest, int weight) {
        graph.get(src).add(new Edge(dest, weight));
        graph.get(dest).add(new Edge(src, weight));
    }

    static void primMST(List<List<Edge>> graph, int vertices) {
        boolean[] inMST = new boolean[vertices];
        int[] key = new int[vertices];
        int[] parent = new int[vertices];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        // Start from vertex 0
        key[0] = 0;
        pq.add(new Edge(0, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;
            inMST[u] = true;

            for (Edge neighbor : graph.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    parent[v] = u;
                    pq.add(new Edge(v, key[v]));
                }
            }
        }

        // Print MST
        System.out.println("Edges in the Minimum Spanning Tree:");
        int totalWeight = 0;
        for (int i = 1; i < vertices; i++) {
            System.out.println("Edge: " + parent[i] + " - " + i + " | Weight: " + key[i]);
            totalWeight += key[i];
        }
        System.out.println("Total Weight: " + totalWeight);
    }
}

