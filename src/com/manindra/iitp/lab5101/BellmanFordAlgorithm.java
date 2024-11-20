package com.manindra.iitp.lab5101;

import java.util.*;

//https://www.hackerrank.com/iitp-tutorial-12
public class BellmanFordAlgorithm {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of vertices, edges, and source vertex
        int V = scanner.nextInt();
        int E = scanner.nextInt();
        int S = scanner.nextInt();

        // Input edges
        int[][] edges = new int[E][3];
        for (int i = 0; i < E; i++) {
            edges[i][0] = scanner.nextInt(); // u
            edges[i][1] = scanner.nextInt(); // v
            edges[i][2] = scanner.nextInt(); // w
        }

        // Calculate shortest distances using Bellman-Ford
        int[] result = bellmanFord(V, E, S, edges);

        // Output result
        if (result.length == 1 && result[0] == -1) {
            System.out.println("-1");
        } else {
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + " ");
            }
        }
    }

    public static int[] bellmanFord(int V, int E, int S, int[][] edges) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9); // Initialize distances to a large value
        dist[S] = 0; // Distance to source is 0

        // Relax edges V-1 times
        for (int i = 1; i < V; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if (dist[u] != (int) 1e9 && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        // Check for negative weight cycle
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            if (dist[u] != (int) 1e9 && dist[u] + w < dist[v]) {
                return new int[]{-1}; // Negative weight cycle detected
            }
        }

        // Replace unreachable distances with 10^9
        for (int i = 0; i < V; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = (int) 1e9;
            }
        }

        return dist;
    }
}

