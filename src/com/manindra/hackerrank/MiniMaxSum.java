package com.manindra.hackerrank;

import java.util.*;

public class MiniMaxSum {

    public static void main(String[] args) {
        // Test cases
        List<Integer> test1 = Arrays.asList(1, 2, 3, 4, 5);  // Expected output: 10 14
        List<Integer> test2 = Arrays.asList(7, 69, 2, 221, 8974); // Expected output: 299 9271

        System.out.print("Test Case 1: ");
        //miniMaxSum(test1);
        //miniMaxSum2(test1);
        miniMaxSum3(test1);

        System.out.print("Test Case 2: ");
        miniMaxSum(test2);
    }

    public static void miniMaxSum(List<Integer> arr) {

        Collections.sort(arr);
        long sum=0;
        for (int i=0;i<arr.size();i++){
            sum+=arr.get(i);
        }
        long low_sum=sum-arr.get(arr.size()-1);
        long high_sum=sum-arr.get(0);
        System.out.println(low_sum+" "+high_sum);

    }

    public static void miniMaxSum2(List<Integer> arr) {
        // Convert the list to a stream and calculate the total sum
        long totalSum = arr.stream().mapToLong(Integer::longValue).sum();

        // Calculate the minimum and maximum by excluding one element at a time
        long minSum = arr.stream().mapToLong(Integer::longValue).max().orElse(0);
        long maxSum = arr.stream().mapToLong(Integer::longValue).min().orElse(0);

        // Calculate the results
        minSum = totalSum - minSum; // Exclude the largest number for minSum
        maxSum = totalSum - maxSum; // Exclude the smallest number for maxSum

        // Print the results
        System.out.println(minSum + " " + maxSum);
    }

    public static void miniMaxSum3(List<Integer> arr) {
        Collections.sort(arr);
        long sum2 = arr.stream().skip(1).mapToLong(Long::valueOf).sum();
        long sum1 = arr.stream().limit(arr.size() - 1).mapToLong(Long::valueOf).sum();
        System.out.println(sum1 + " " + sum2);
    }

}

