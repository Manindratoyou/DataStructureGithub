package com.manindra.graph_ds;

import java.util.*;

class DijkstraAlgorithm {

    static class Edge {
        int destination;
        int weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    public static void dijkstra(int source, List<List<Edge>> graph, int vertices) {
        // Distance array to store shortest distances
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        // Priority queue to store the minimum distance vertex
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(source, 0));

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();
            int currentVertex = current.vertex;

            for (Edge edge : graph.get(currentVertex)) {
                int neighbor = edge.destination;
                int weight = edge.weight;

                if (distance[currentVertex] + weight < distance[neighbor]) {
                    distance[neighbor] = distance[currentVertex] + weight;
                    priorityQueue.add(new Node(neighbor, distance[neighbor]));
                }
            }
        }

        // Print shortest distances from source
        System.out.println("Shortest distances from source vertex " + source + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("To vertex " + i + ": " + distance[i]);
        }
    }

    public static void main(String[] args) {
        int vertices = 5; // Number of vertices
        List<List<Edge>> graph = new ArrayList<>();

        // Initialize adjacency list for each vertex
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges to the graph (directed graph)
        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(2, 2));
        graph.get(1).add(new Edge(2, 3));
        graph.get(1).add(new Edge(3, 2));
        graph.get(2).add(new Edge(3, 4));
        graph.get(2).add(new Edge(4, 1));
        graph.get(3).add(new Edge(4, 2));

        int source = 0; // Source vertex
        dijkstra(source, graph, vertices);
    }
}

