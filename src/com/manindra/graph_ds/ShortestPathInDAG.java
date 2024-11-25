package com.manindra.graph_ds;

import java.util.LinkedList;
import java.util.Stack;

class AdjListNode {
    private int vertex;
    private int weight;

    AdjListNode(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    int getVertex() {
        return vertex;
    }

    int getWeight() {
        return weight;
    }
}

class Graph {
    private int vertices;
    private LinkedList<AdjListNode>[] adjList;

    @SuppressWarnings("unchecked")
    Graph(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int from, int to, int weight) {
        adjList[from].add(new AdjListNode(to, weight));
    }

    private void topologicalSortUtil(int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;

        for (AdjListNode node : adjList[vertex]) {
            if (!visited[node.getVertex()]) {
                topologicalSortUtil(node.getVertex(), visited, stack);
            }
        }

        stack.push(vertex);
    }

    void shortestPath(int source) {
        Stack<Integer> stack = new Stack<>();
        int[] distances = new int[vertices];
        boolean[] visited = new boolean[vertices];

        // Perform topological sort
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        // Initialize distances to infinity
        for (int i = 0; i < vertices; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[source] = 0;

        // Process vertices in topological order
        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (distances[current] != Integer.MAX_VALUE) {
                for (AdjListNode node : adjList[current]) {
                    if (distances[node.getVertex()] > distances[current] + node.getWeight()) {
                        distances[node.getVertex()] = distances[current] + node.getWeight();
                    }
                }
            }
        }

        // Print distances
        for (int i = 0; i < vertices; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                System.out.print("INF ");
            } else {
                System.out.print(distances[i] + " ");
            }
        }
    }
}

public class ShortestPathInDAG {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 4, 1);
        graph.addEdge(1, 2, 3);
        graph.addEdge(4, 2, 2);
        graph.addEdge(4, 5, 4);
        graph.addEdge(2, 3, 6);
        graph.addEdge(5, 3, 1);

        int source = 0;
        System.out.println("Following are shortest distances from source " + source + ":");
        graph.shortestPath(source);
    }
}

