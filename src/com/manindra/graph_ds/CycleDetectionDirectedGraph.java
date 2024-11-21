package com.manindra.graph_ds;

import java.util.*;

class CycleDetectionDirectedGraph {

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        addEdge(adj, 0, 1);
        addEdge(adj, 4, 1);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 1); // This edge creates a cycle

        // Detect cycle
        boolean hasCycle = detectCycle(adj, V);
        if (hasCycle) {
            System.out.println("There exists a cycle in the graph");
        } else {
            System.out.println("There exists no cycle in the graph");
        }
    }

    // Method to add a directed edge from u to v
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

    // Method to detect a cycle in a directed graph using Kahn's Algorithm
    static boolean detectCycle(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] in_degree = new int[V];

        // Compute in-degree of each vertex
        for (int u = 0; u < V; u++) {
            for (int x : adj.get(u)) {
                in_degree[x]++;
            }
        }

        // Add vertices with in-degree 0 to the queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (in_degree[i] == 0) {
                q.add(i);
            }
        }

        // Process vertices in the queue
        int count = 0; // Track processed vertices
        while (!q.isEmpty()) {
            int u = q.poll();

            // Reduce in-degree of neighbors and add to queue if in-degree becomes 0
            for (int x : adj.get(u)) {
                if (--in_degree[x] == 0) {
                    q.add(x);
                }
            }

            count++;
        }

        // Check if all vertices were processed
        return count != V; // True if there's a cycle, false otherwise
    }

}

