package com.manindra.graph_ds;

import java.util.*;

class TopologicalSort {

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        addEdge(adj, 0, 2);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);

        System.out.println("Following is a Topological Sort:");
        topologicalSort(adj, V);
    }

    // Method to add a directed edge from u to v
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
    }

    // Kahn's Algorithm for Topological Sort
    static void topologicalSort(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] in_degree = new int[V];

        // Compute in-degree of each vertex
        for (int u = 0; u < V; u++) {
            for (int x : adj.get(u))
                in_degree[x]++;
        }

        // Add vertices with in-degree 0 to the queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++)
            if (in_degree[i] == 0)
                q.add(i);

        // Process vertices in the queue
        int count = 0; // To track processed vertices
        ArrayList<Integer> topoOrder = new ArrayList<>(); // Store topological order

        while (!q.isEmpty()) {
            int u = q.poll();
            topoOrder.add(u);
            count++;

            for (int x : adj.get(u)) {
                if (--in_degree[x] == 0)
                    q.add(x);
            }
        }

        // Check if the graph contains a cycle
        if (count != V) {
            System.out.println("The graph contains a cycle. Topological sorting is not possible.");
            return;
        }

        // Print the topological order
        System.out.println("Topological Sort: " + topoOrder);
    }

}

