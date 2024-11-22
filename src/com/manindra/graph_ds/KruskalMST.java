package com.manindra.graph_ds;

import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class UnionFind {
    private int[] parent, rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            return false; // Cycle detected
        }

        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return true;
    }
}

public class KruskalMST {
    public static void main(String[] args) {
        int vertices = 5; // Number of vertices
        List<Edge> edges = new ArrayList<>();

        // Add edges (src, dest, weight)
        edges.add(new Edge(0, 1, 1)); // A-B
        edges.add(new Edge(1, 2, 3)); // B-C
        edges.add(new Edge(2, 3, 4)); // C-D
        edges.add(new Edge(3, 4, 2)); // D-E
        edges.add(new Edge(4, 0, 5)); // E-A
        edges.add(new Edge(1, 3, 2)); // B-D

        // Kruskal's algorithm
        Collections.sort(edges); // Sort edges by weight
        UnionFind uf = new UnionFind(vertices);
        List<Edge> mst = new ArrayList<>();

        for (Edge edge : edges) {
            if (uf.union(edge.src, edge.dest)) {
                mst.add(edge); // Add edge to MST
                if (mst.size() == vertices - 1) break; // MST is complete
            }
        }

        // Print MST
        System.out.println("Edges in the Minimum Spanning Tree:");
        int totalWeight = 0;
        for (Edge edge : mst) {
            System.out.println("Edge: " + edge.src + " - " + edge.dest + " | Weight: " + edge.weight);
            totalWeight += edge.weight;
        }
        System.out.println("Total Weight: " + totalWeight);
    }
}

