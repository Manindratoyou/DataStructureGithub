package com.manindra.graph_ds;

import java.util.LinkedList;
import java.util.Stack;

public class KosarajusAlgorithm {

    private int V;
    private LinkedList<Integer> adj[];

    public static void main(String args[]) {
        KosarajusAlgorithm g = new KosarajusAlgorithm(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Following are strongly connected components in given graph:");
        g.printSCCs();
    }

    KosarajusAlgorithm(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<>();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int n : adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    KosarajusAlgorithm getTranspose() {
        KosarajusAlgorithm g = new KosarajusAlgorithm(V);
        for (int v = 0; v < V; v++) {
            for (int i : adj[v]) {
                g.adj[i].add(v);  // Reverse the direction of edges
            }
        }
        return g;
    }

    void fillOrder(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;

        for (int n : adj[v]) {
            if (!visited[n])
                fillOrder(n, visited, stack);
        }

        stack.push(v);
    }

    void printSCCs() {
        Stack<Integer> stack = new Stack<>();

        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            if (!visited[i])
                fillOrder(i, visited, stack);

        KosarajusAlgorithm gr = getTranspose();

        for (int i = 0; i < V; i++)
            visited[i] = false;

        while (!stack.isEmpty()) {
            int v = stack.pop();

            if (!visited[v]) {
                gr.DFSUtil(v, visited);
                System.out.println();
            }
        }
    }

}
