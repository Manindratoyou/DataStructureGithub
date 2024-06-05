package com.manindra.hackerrank;

import java.util.*;

public class MinimumLoss {

    public static void main(String[] args) {

        int[] prices = {20, 15, 8, 2, 12};
        minLoss(prices);
        System.out.println(minimumLoss(Arrays.asList(20L, 15L, 8L, 2L, 12L)));
    }


    static void minLoss(int[] prices) {
        int minLoss = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                minLoss = Math.min(Math.abs(prices[i] - prices[j]), minLoss);
            }
        }
        System.out.println(minLoss);
    }

    static int minimumLoss(List<Long> prices) {

        //Index all the elements
        Map<Long, Integer> priceIndexMap = new HashMap<>();
        for (int i = 0; i < prices.size(); i++) {
            priceIndexMap.put(prices.get(i), i);
        }

        Collections.sort(prices);
        long minimumLoss = Long.MAX_VALUE;

        //start from the end
        for (int i = prices.size() - 1; i > 0; i--) {

            //reject the invalid values
            if (priceIndexMap.get(prices.get(i)) > priceIndexMap.get(prices.get(i - 1)))
                continue;
            long dayLoss = prices.get(i) - prices.get(i - 1);
            minimumLoss = Math.min(dayLoss, minimumLoss);
        }

        return (int) minimumLoss;
    }
}
