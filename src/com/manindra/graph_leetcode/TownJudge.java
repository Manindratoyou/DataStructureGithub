package com.manindra.graph_leetcode;

public class TownJudge { //solution 997

    public int findJudge(int n, int[][] trust) {
        int[] trustScore = new int[n + 1]; // index 1-based

        for (int[] t : trust) {
            int a = t[0], b = t[1];
            trustScore[a]--; // a trusts someone, can't be judge
            trustScore[b]++; // b is trusted
        }

        for (int i = 1; i <= n; i++) {
            if (trustScore[i] == n - 1) {
                return i; // found the judge
            }
        }

        return -1; // no judge
    }

    public static void main(String[] args) {
        TownJudge obj = new TownJudge();

        System.out.println(obj.findJudge(2, new int[][]{{1, 2}}));            // Output: 2
        System.out.println(obj.findJudge(3, new int[][]{{1, 3}, {2, 3}}));    // Output: 3
        System.out.println(obj.findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}})); // Output: -1
    }
}

