package com.manindra.graph_ds;

import java.util.*;

class AdjacencyListGraph {

    /*
         0
        / \
       1   2
        \
         3

     */

    public static void main(String[] args) {
        int V = 4;  // Number of vertices
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(V);

        // Initialize each vertex's adjacency list
        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<Integer>());

        // Adding edges one by one
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);

        // Print the adjacency list representation of the graph
        printGraph(graph);
    }

    // Function to add an edge between two vertices
    static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    // Function to print the adjacency list representation of the graph
    static void printGraph(ArrayList<ArrayList<Integer>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            System.out.print("Vertex " + i + ": ");
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(graph.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}

