package com.manindra.graph_leetcode;

import java.util.*;

public class KeysAndRooms { //solution 841

    public static void main(String[] args) {
        KeysAndRooms obj = new KeysAndRooms();
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(new ArrayList<>());
        System.out.println(obj.canVisitAllRooms(rooms)); // true
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) { //DFS
        Set<Integer> visited = new HashSet<>();
        dfs(0, rooms, visited);
        return visited.size() == rooms.size();
    }

    private void dfs(int room, List<List<Integer>> rooms, Set<Integer> visited) {
        if (visited.contains(room)) return;
        visited.add(room);
        for (int key : rooms.get(room)) {
            dfs(key, rooms, visited);
        }
    }

    public boolean canVisitAllRooms2(List<List<Integer>> rooms) { //BFS
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int room = queue.poll();
            for (int key : rooms.get(room)) {
                if (!visited[key]) {
                    visited[key] = true;
                    queue.offer(key);
                }
            }
        }

        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }
}

