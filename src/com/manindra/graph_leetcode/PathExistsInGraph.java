package com.manindra.graph_leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathExistsInGraph { //solution 1971

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Build the adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]); // undirected
        }

        boolean[] visited = new boolean[n];
        return dfs(graph, source, destination, visited);
    }

    private boolean dfs(List<List<Integer>> graph, int current, int destination, boolean[] visited) {
        if (current == destination) return true;
        if (visited[current]) return false;

        visited[current] = true;
        for (int neighbor : graph.get(current)) {
            if (dfs(graph, neighbor, destination, visited))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PathExistsInGraph obj = new PathExistsInGraph();

        int[][] edges1 = {{0,1},{1,2},{2,0}};
        System.out.println(obj.validPath(3, edges1, 0, 2)); // true

        int[][] edges2 = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        System.out.println(obj.validPath(6, edges2, 0, 5)); // false
    }
}

