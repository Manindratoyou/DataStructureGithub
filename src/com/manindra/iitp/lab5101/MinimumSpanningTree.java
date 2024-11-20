package com.manindra.iitp.lab5101;

import java.io.*;
import java.util.*;

//https://www.hackerrank.com/tutorial-11
public class MinimumSpanningTree {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");

        int V = Integer.parseInt(firstLine[0]);
        int E = Integer.parseInt(firstLine[1]);

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            String[] edgeLine = br.readLine().split(" ");
            int u = Integer.parseInt(edgeLine[0]);
            int v = Integer.parseInt(edgeLine[1]);
            int w = Integer.parseInt(edgeLine[2]);
            edges.add(new Edge(u, v, w));
        }

        // Calculate MST weight
        int mstWeight = kruskalMST(V, edges);
        System.out.println(mstWeight);
    }

    public static int kruskalMST(int V, List<Edge> edges) {
        // Sort edges by weight
        Collections.sort(edges, Comparator.comparingInt(edge -> edge.weight));

        UnionFind uf = new UnionFind(V);
        int mstWeight = 0;
        int edgesInMST = 0;

        for (Edge edge : edges) {
            if (uf.find(edge.u) != uf.find(edge.v)) {
                uf.union(edge.u, edge.v);
                mstWeight += edge.weight;
                edgesInMST++;

                // Stop if we have V-1 edges in the MST
                if (edgesInMST == V - 1) {
                    break;
                }
            }
        }

        return mstWeight;
    }

    // Edge class to represent an edge with a weight
    static class Edge {
        int u, v, weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    // Union-Find data structure with path compression and union by rank
    static class UnionFind {
        int[] parent, rank;

        UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int u) {
            if (parent[u] != u) {
                parent[u] = find(parent[u]); // Path compression
            }
            return parent[u];
        }

        void union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);

            if (rootU != rootV) {
                // Union by rank
                if (rank[rootU] > rank[rootV]) {
                    parent[rootV] = rootU;
                } else if (rank[rootU] < rank[rootV]) {
                    parent[rootU] = rootV;
                } else {
                    parent[rootV] = rootU;
                    rank[rootU]++;
                }
            }
        }
    }
}

