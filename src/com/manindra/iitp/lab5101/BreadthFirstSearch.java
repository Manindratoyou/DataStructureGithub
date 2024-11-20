package com.manindra.iitp.lab5101;

import java.io.*;
import java.util.*;

//https://www.hackerrank.com/tutorial-11
public class BreadthFirstSearch {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");

        int V = Integer.parseInt(firstLine[0]);
        int E = Integer.parseInt(firstLine[1]);

        // Initialize the adjacency list
        List<List<Integer>> adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }

        // Read the edges and populate the adjacency list
        for (int i = 0; i < E; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // BFS starting from vertex 0
        bfs(0, V, adjList);
    }

    public static void bfs(int start, int V, List<List<Integer>> adjList) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.append(current).append(" ");

            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        // Print the result, trimming the trailing space
        System.out.println(result.toString().trim());
    }
}

