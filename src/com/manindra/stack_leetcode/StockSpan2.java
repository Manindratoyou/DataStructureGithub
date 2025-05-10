package com.manindra.stack_leetcode;

import java.util.ArrayList;
import java.util.List;

public class StockSpan2 { //901

    public static void main(String[] args) {

        StockSpan2 stockSpan = new StockSpan2();
        System.out.println(stockSpan.next(100));
        System.out.println(stockSpan.next(80));
        System.out.println(stockSpan.next(60));
        System.out.println(stockSpan.next(70));
        System.out.println(stockSpan.next(60));
        System.out.println(stockSpan.next(75));
        System.out.println(stockSpan.next(85));
    }

    private List<Integer> list;

    public StockSpan2() {
        list = new ArrayList<>();
    }

    public int next(int price) {
        list.add(price);
        int count = 0;

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) <= price) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
