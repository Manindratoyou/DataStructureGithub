package com.manindra.hackerrank_2;

import java.util.*;

public class JimAndTheOrders {

    static class Order {
        int customerId;
        int deliveryTime;

        Order(int customerId, int deliveryTime) {
            this.customerId = customerId;
            this.deliveryTime = deliveryTime;
        }
    }

    public static List<Integer> jimOrders(List<List<Integer>> orders) {
        List<Order> orderList = new ArrayList<>();

        for (int i = 0; i < orders.size(); i++) {
            int orderTime = orders.get(i).get(0);
            int prepTime = orders.get(i).get(1);
            int deliveryTime = orderTime + prepTime;
            orderList.add(new Order(i + 1, deliveryTime)); // customerId is 1-based
        }

        // Sort by deliveryTime, then by customerId if times are equal
        orderList.sort((o1, o2) -> {
            if (o1.deliveryTime == o2.deliveryTime) {
                return Integer.compare(o1.customerId, o2.customerId);
            }
            return Integer.compare(o1.deliveryTime, o2.deliveryTime);
        });

        List<Integer> result = new ArrayList<>();
        for (Order order : orderList) {
            result.add(order.customerId);
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> orders1 = Arrays.asList(
                Arrays.asList(1, 3),
                Arrays.asList(2, 3),
                Arrays.asList(3, 3)
        );

        List<Integer> result = jimOrders(orders1);
        System.out.println("Delivery order: " + result);  // Output: [1, 2, 3]

        List<List<Integer>> orders2 = Arrays.asList(
                Arrays.asList(8, 1),
                Arrays.asList(4, 3),
                Arrays.asList(2, 5),
                Arrays.asList(1, 2)
        );

        System.out.println("Delivery order: " + jimOrders(orders2));  // Output: [4, 3, 2, 1]
    }
}

