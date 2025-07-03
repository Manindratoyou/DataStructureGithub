package com.manindra.hackerrank_2;

import java.util.*;

public class DeploymentScheduler { //IBM

    // Main method to run sample test cases
    public static void main(String[] args) {
        // Test Case 1
        List<Integer> setup1 = Arrays.asList(1, 1, 1);
        List<Integer> test1 = Arrays.asList(2, 3, 4);
        int totalDeploys1 = 3;
        System.out.println("Test Case 1 Output: " + getMinTime(setup1, test1, totalDeploys1)); // Expected: 7

        // Test Case 2
        List<Integer> setup2 = Arrays.asList(3, 2, 4);
        List<Integer> test2 = Arrays.asList(4, 3, 2);
        int totalDeploys2 = 4;
        System.out.println("Test Case 2 Output: " + getMinTime(setup2, test2, totalDeploys2)); // Expected: 18

        // Test Case 3
        List<Integer> setup3 = Arrays.asList(5);
        List<Integer> test3 = Arrays.asList(2);
        int totalDeploys3 = 5;
        System.out.println("Test Case 3 Output: " + getMinTime(setup3, test3, totalDeploys3)); // Expected: 5 + 4*2 = 13

        // Test Case 4 (Edge case: only 1 deploy needed)
        List<Integer> setup4 = Arrays.asList(2, 5, 1);
        List<Integer> test4 = Arrays.asList(3, 1, 4);
        int totalDeploys4 = 1;
        System.out.println("Test Case 4 Output: " + getMinTime(setup4, test4, totalDeploys4)); // Expected: 2+3 = 5
    }

    // Method to compute minimum deployment time
    public static long getMinTime(List<Integer> setupTime, List<Integer> testTime, int totalDeploys) {
        int n = setupTime.size();
        long minTotalTime = Long.MAX_VALUE;
        long prefixTime = 0;
        int minTest = Integer.MAX_VALUE;

        for (int i = 0; i < Math.min(n, totalDeploys); i++) {
            prefixTime += setupTime.get(i) + testTime.get(i); // setup + test for feature i
            minTest = Math.min(minTest, testTime.get(i));     // track minimum test time so far

            int remaining = totalDeploys - (i + 1); // remaining redeployments
            long totalTime = prefixTime + (long) remaining * minTest;

            minTotalTime = Math.min(minTotalTime, totalTime); // update minimum
        }

        return minTotalTime;
    }

    /*
        📘 Problem Summary: Minimum Deployment Time
    🧩 Objective:
    You are given:

    A list of setupTime[i]: Time to set up the i-th feature.

    A list of testTime[i]: Time to test the i-th feature.

    An integer totalDeploys: The total number of feature deployments you must perform.

    You must choose:

    How many unique features to deploy in order (starting from feature 0, sequentially).

    Then, reuse one of the already deployed features for the remaining deployments — this costs only testTime[i].

    🧠 Constraints:
    You can only deploy Feature i+1 if Feature i has already been deployed.

    Every first-time deployment costs: setupTime[i] + testTime[i]

    Every repeat deployment (of already deployed feature) costs: testTime[i]

    🎯 Goal:
    Minimize the total deployment time needed to complete exactly totalDeploys deployments.

    ✅ Optimal Strategy:
    Try all possible numbers of initial deployments (k = 1 to min(n, totalDeploys)).

    For each:

    Calculate time to deploy first k features.

    Calculate remaining deployments using the cheapest testTime among deployed features.

    Track the minimum total time.

    📌 Example:
    java
    Copy
    Edit
    setupTime = [1, 1, 1];
    testTime  = [2, 3, 4];
    totalDeploys = 3;
    Choices:

    Deploy Feature 0 → 1+2 = 3

    Deploy Feature 1 → 1+3 = 4

    Total = 7 ✅ (no repeat needed)

    Answer: 7


     */


}

