package com.manindra.iitp.lab5101;

import java.util.*;

//https://www.hackerrank.com/iitp-tutorial-12
public class DijkstrasAlgorithm5 {

    static class Node implements Comparable<Node> {
        int vertex, weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Number of nodes (n) and edges (m)
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // Create an adjacency list for the graph
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Input edges
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();

            // Since the graph is undirected, add both directions
            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }

        // Input source node
        int source = scanner.nextInt();

        // Find shortest paths using Dijkstra's Algorithm
        int[] distances = dijkstra(graph, source, n);

        // Print the shortest distances from the source node to all nodes
        for (int i = 0; i < n; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                System.out.print("-1 "); // Unreachable nodes
            } else {
                System.out.print(distances[i] + " ");
            }
        }
    }

    private static int[] dijkstra(List<List<Node>> graph, int source, int n) {
        // Array to store the shortest distances, initialize with infinity
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        // Priority queue to process nodes based on the shortest distance
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));

        // Visited set to avoid reprocessing nodes
        boolean[] visited = new boolean[n];

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentVertex = current.vertex;

            // Skip if already visited
            if (visited[currentVertex]) continue;
            visited[currentVertex] = true;

            // Update distances for adjacent nodes
            for (Node neighbor : graph.get(currentVertex)) {
                int newDist = distances[currentVertex] + neighbor.weight;

                if (newDist < distances[neighbor.vertex]) {
                    distances[neighbor.vertex] = newDist;
                    pq.add(new Node(neighbor.vertex, newDist));
                }
            }
        }

        return distances;
    }
}

