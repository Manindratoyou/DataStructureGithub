package com.manindra.interview_2;

import java.util.HashMap;
import java.util.Map;

public class HighestAverageStudent {

    public static void main(String[] args) {
        //String[][] input = {{"Bob", "87"}, {"Mike", "35"}, {"Bob", "52"}, {"Jason", "35"}, {"Mike", "55"}, {"Jessica", "99"}};
        String[][] input = {{"Bob","87"},{"Mark","100"},{"Charles","63"},{"Mark","22"}};
        int highestAverage = findHighestAverage(input);
        System.out.println("The student with the highest average is: " + highestAverage);
    }

    static int findHighestAverage(String[][] scores) {
        Map<String, Integer> sumMap = new HashMap<>();
        Map<String, Integer> countMap = new HashMap<>();

        for (String[] score : scores) {
            String student = score[0];
            int scoreValue = Integer.parseInt(score[1]);

            sumMap.put(student, sumMap.getOrDefault(student, 0) + scoreValue);
            countMap.put(student, countMap.getOrDefault(student, 0) + 1);
        }

        double highestAverage = 0;
        for (Map.Entry<String, Integer> entry : sumMap.entrySet()) {
            String student = entry.getKey();
            int sum = entry.getValue();
            int count = countMap.get(student);

            double average = (double) sum / count;
            highestAverage = Math.max(highestAverage, average);
        }

        // Floor the highest average to the nearest integer
        return (int) Math.floor(highestAverage);
    }
}

