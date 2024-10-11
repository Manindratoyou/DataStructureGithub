package com.manindra.graph_ds;

import java.util.*;

class AdjacencyMatrixGraph {

    /*
         0
        / \
       1   2
        \
         3

     */

    public static void main(String[] args) {
        int V = 4;  // Number of vertices
        int[][] graph = new int[V][V]; // Initialize the adjacency matrix with 0

        // Adding edges one by one
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);

        // Print the adjacency matrix representation of the graph
        printGraph(graph);
    }

    // Function to add an edge between two vertices in the adjacency matrix
    static void addEdge(int[][] graph, int u, int v) {
        graph[u][v] = 1;
        graph[v][u] = 1; // Since it's an undirected graph
    }

    // Function to print the adjacency matrix representation of the graph
    static void printGraph(int[][] graph) {
        int V = graph.length;
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

}

