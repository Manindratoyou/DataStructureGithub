package com.manindra.graph_leetcode;

import java.util.*;

public class AccountsMergeDFS { //solution 721

    // example
    public static void main(String[] args) {
        List<List<String>> accounts = Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("Mary", "mary@mail.com")
        );

        List<List<String>> merged = accountsMerge(accounts);
        for (List<String> acc : merged) {
            System.out.println(acc);
        }
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        // map email -> name
        Map<String, String> emailToName = new HashMap<>();
        // adjacency list for email graph
        Map<String, Set<String>> graph = new HashMap<>();

        // build graph
        for (List<String> acc : accounts) {
            String name = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                emailToName.put(email, name);
                graph.putIfAbsent(email, new HashSet<>());
                // connect this email with the first email in the account to form edges
                if (i == 1) continue;
                String first = acc.get(1);
                graph.get(email).add(first);
                graph.get(first).add(email);
            }
        }

        List<List<String>> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        // DFS to collect connected components
        for (String email : graph.keySet()) {
            if (!visited.contains(email)) {
                List<String> component = new ArrayList<>();
                Stack<String> stack = new Stack<>();
                stack.push(email);
                visited.add(email);
                while (!stack.isEmpty()) {
                    String cur = stack.pop();
                    component.add(cur);
                    for (String nei : graph.getOrDefault(cur, Collections.emptySet())) {
                        if (!visited.contains(nei)) {
                            visited.add(nei);
                            stack.push(nei);
                        }
                    }
                }
                Collections.sort(component);
                List<String> merged = new ArrayList<>();
                merged.add(emailToName.get(email));
                merged.addAll(component);
                result.add(merged);
            }
        }
        return result;
    }

}

