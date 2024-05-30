package com.manindra.heap_ds;

import java.util.Arrays;
import java.util.PriorityQueue;

public class BuyMaximum_Items_with_GivenSum {

    public static void main(String[] args) {

        int[] cost = {1, 12, 5, 111, 200};
        int sum = 10;
        System.out.println(maxItemSolutionOne(cost, sum));
        System.out.println(maxItemSolutionTwo(cost, sum));
    }

    static int maxItemSolutionOne(int[] cost, int sum) {

        int result = 0;
        Arrays.sort(cost);
        for (int i = 0; i < cost.length; i++) {
            if (cost[i] <= sum) {
                sum -= cost[i];
                result++;
            }
        }
        return result;
    }

    static int maxItemSolutionTwo(int[] cost, int sum) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int result = 0;
        for (int i = 0; i < cost.length; i++) {
            pq.add(cost[i]);
        }
        for (int i = 0; i < cost.length; i++) {
            if (pq.peek() <= sum) {
                sum -= pq.poll();
                result++;
            } else
                break;
        }
        return result;
    }

}
