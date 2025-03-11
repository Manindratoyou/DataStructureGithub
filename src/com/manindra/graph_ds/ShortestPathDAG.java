package com.manindra.graph_ds;

import java.util.*;

class ShortestPathDAG {

    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    // Topological Sort using DFS
    private static void topologicalSort(int node, List<List<Edge>> graph, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (Edge edge : graph.get(node)) {
            if (!visited[edge.to]) {
                topologicalSort(edge.to, graph, visited, stack);
            }
        }
        stack.push(node);
    }

    // Find shortest path in DAG
    public static int[] shortestPathDAG(int V, List<List<Edge>> graph, int source) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        // Step 1: Perform Topological Sort
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSort(i, graph, visited, stack);
            }
        }

        // Step 2: Initialize distances
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // Step 3: Process nodes in topological order
        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (dist[u] != Integer.MAX_VALUE) {
                for (Edge edge : graph.get(u)) {
                    if (dist[u] + edge.weight < dist[edge.to]) {
                        dist[edge.to] = dist[u] + edge.weight;
                    }
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Adding directed edges
        graph.get(0).add(new Edge(1, 5));
        graph.get(0).add(new Edge(2, 3));
        graph.get(1).add(new Edge(3, 6));
        graph.get(1).add(new Edge(2, 2));
        graph.get(2).add(new Edge(4, 4));
        graph.get(2).add(new Edge(5, 2));
        graph.get(2).add(new Edge(3, 7));
        graph.get(3).add(new Edge(5, 1));
        graph.get(4).add(new Edge(5, 3));

        int source = 0;
        int[] shortestDistances = shortestPathDAG(V, graph, source);

        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("To " + i + " -> " + (shortestDistances[i] == Integer.MAX_VALUE ? "INF" : shortestDistances[i]));
        }
    }
}
