package com.manindra.graph_leetcode;

import java.util.*;

public class ReorderRoutes { //solution 1466

    public static void main(String[] args) {
        ReorderRoutes obj = new ReorderRoutes();
        int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        System.out.println(obj.minReorder(6, connections)); // Output: 3
    }

    public int minReorder(int n, int[][] connections) { //DFS
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] conn : connections) {
            int from = conn[0], to = conn[1];
            graph.computeIfAbsent(from, x -> new ArrayList<>()).add(new int[]{to, 1}); // original direction
            graph.computeIfAbsent(to, x -> new ArrayList<>()).add(new int[]{from, 0}); // reverse direction
        }

        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }

    private int dfs(int node, Map<Integer, List<int[]>> graph, boolean[] visited) {
        visited[node] = true;
        int count = 0;

        for (int[] neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            int nextNode = neighbor[0];
            int needsReversal = neighbor[1];

            if (!visited[nextNode]) {
                count += needsReversal + dfs(nextNode, graph, visited);
            }
        }

        return count;
    }

    public int minReorder2(int n, int[][] connections) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<String> directedEdges = new HashSet<>();

        // Build undirected graph and track original directions
        for (int[] conn : connections) {
            int from = conn[0], to = conn[1];
            graph.computeIfAbsent(from, x -> new ArrayList<>()).add(to);
            graph.computeIfAbsent(to, x -> new ArrayList<>()).add(from);
            directedEdges.add(from + "->" + to); // record original direction
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : graph.get(current)) {
                if (visited[neighbor]) continue;

                // If the original edge was from current to neighbor, it needs reversal
                if (directedEdges.contains(current + "->" + neighbor)) {
                    count++;
                }

                visited[neighbor] = true;
                queue.offer(neighbor);
            }
        }

        return count;
    }



}

