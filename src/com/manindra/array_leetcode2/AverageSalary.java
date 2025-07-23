package com.manindra.array_leetcode2;

import java.util.Arrays;

public class AverageSalary { //solution 1491

    public static void main(String[] args) {
        int[] salary = {4000, 3000, 1000, 2000};
        System.out.println("Average Salary = " + average(salary));
    }

    public static double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int sal : salary) {
            min = Math.min(min, sal);
            max = Math.max(max, sal);
            sum += sal;
        }

        // Subtract min and max from sum
        sum = sum - min - max;

        // Return average
        return (double) sum / (salary.length - 2);
    }

    public static double average2(int[] salary) {
        int min = Arrays.stream(salary).min().getAsInt();
        int max = Arrays.stream(salary).max().getAsInt();
        int sum = Arrays.stream(salary).sum();
        return (double) (sum - min - max) / (salary.length - 2);
    }
}

