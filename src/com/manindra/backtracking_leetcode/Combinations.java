package com.manindra.backtracking_leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Combinations { //solution 77

    public static void main(String[] args) {
        Combinations obj = new Combinations();
        System.out.println(obj.combine(4, 2));
        // Expected: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {
        // Base case: if current combination has k elements
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try adding each number from 'start' to 'n'
        for (int i = start; i <= n; i++) {
            current.add(i);  // choose
            backtrack(i + 1, n, k, current, result);  // explore
            current.remove(current.size() - 1); // un-choose
        }
    }

    public List<List<Integer>> combine2(int n, int k) {
        if (k == 0) return Arrays.asList(new ArrayList<>());
        if (n < k) return new ArrayList<>();

        // Include 'n'
        List<List<Integer>> withN = combine2(n - 1, k - 1)
                .stream()
                .map(list -> {
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(n);
                    return newList;
                })
                .collect(Collectors.toList());

        // Exclude 'n'
        List<List<Integer>> withoutN = combine2(n - 1, k);

        withN.addAll(withoutN);
        return withN;
    }


}

