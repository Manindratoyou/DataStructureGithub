package com.manindra.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class BreakingTheRecords {

    public static void main(String[] args) {
        // Test cases
        List<Integer> scores1 = List.of(10, 5, 20, 20, 4, 5, 2, 25, 1);
        List<Integer> scores2 = List.of(3, 4, 21, 36, 10, 28, 35, 5, 24, 42);

        System.out.println(breakingRecords(scores1)); // Output: [2, 4]
        System.out.println(breakingRecords(scores2)); // Output: [4, 0]
    }

    public static List<Integer> breakingRecords(List<Integer> scores) {
        int maxScore = scores.get(0);
        int minScore = scores.get(0);
        int maxBreaks = 0;
        int minBreaks = 0;

        for (int i = 1; i < scores.size(); i++) {
            int score = scores.get(i);
            if (score > maxScore) {
                maxScore = score;
                maxBreaks++;
            } else if (score < minScore) {
                minScore = score;
                minBreaks++;
            }
        }

        List<Integer> result = new ArrayList<>();
        result.add(maxBreaks);
        result.add(minBreaks);
        return result;
    }
}
