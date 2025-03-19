package com.manindra.leetcode_hard;

public class SimilarStringGroupDFS {

    public static void main(String[] args) {
        SimilarStringGroupDFS solution = new SimilarStringGroupDFS();

        String[] strs1 = {"tars", "rats", "arts", "star"};
        String[] strs2 = {"omv", "ovm"};
        String[] strs3 = {"abc", "acb", "bac", "bca", "cab", "cba"};

        System.out.println(solution.numSimilarGroups(strs1)); // Output: 2
        System.out.println(solution.numSimilarGroups(strs2)); // Output: 1
        System.out.println(solution.numSimilarGroups(strs3)); // Output: 1
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        boolean[] visited = new boolean[n];
        int groups = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                groups++;
                dfs(strs, visited, i);
            }
        }
        return groups;
    }

    private void dfs(String[] strs, boolean[] visited, int index) {
        visited[index] = true;
        for (int i = 0; i < strs.length; i++) {
            if (!visited[i] && isSimilar(strs[index], strs[i])) {
                dfs(strs, visited, i);
            }
        }
    }

    private boolean isSimilar(String s1, String s2) {
        int diffCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
                if (diffCount > 2) return false;
            }
        }
        return diffCount == 2 || diffCount == 0;
    }
}

