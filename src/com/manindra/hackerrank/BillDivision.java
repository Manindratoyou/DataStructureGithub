package com.manindra.hackerrank;

import java.util.Arrays;
import java.util.List;

/**
 * Problem Description:
 * Two friends are sharing a meal at a restaurant. One of them is allergic to a particular item
 * and they don't eat it. You are given:
 * - `bill`: A list of integers where each element represents the cost of each item.
 * - `k`: The zero-based index of the item they didn't eat.
 * - `b`: The amount of money charged to the friend.
 *
 * The task is to determine if the friend was overcharged or not.
 * - If the friend was correctly charged, print "Bon Appetit".
 * - Otherwise, print the difference (b - actual share) that should be refunded.
 *
 * Input Example:
 * bill = [3, 10, 2, 9]
 * k = 1 (didn't eat the item with cost 10)
 * b = 12 (charged amount)
 *
 * Output Example:
 * If correctly charged: "Bon Appetit"
 * If overcharged: Refund amount (e.g., "5").
 */
public class BillDivision {

    public static void main(String[] args) {
        // Test case 1
        List<Integer> bill1 = Arrays.asList(3, 10, 2, 9);
        int k1 = 1; // Didn't eat item with index 1
        int b1 = 12; // Charged amount
        System.out.print("Test case 1 result: ");
        bonAppetit(bill1, k1, b1);

        // Test case 2
        List<Integer> bill2 = Arrays.asList(2, 4, 6);
        int k2 = 2; // Didn't eat item with index 2
        int b2 = 3; // Charged amount
        System.out.print("Test case 2 result: ");
        bonAppetit(bill2, k2, b2);

        // Test case 3
        List<Integer> bill3 = Arrays.asList(5, 10, 15);
        int k3 = 0; // Didn't eat item with index 0
        int b3 = 15; // Charged amount
        System.out.print("Test case 3 result: ");
        bonAppetit(bill3, k3, b3);
    }

    public static void bonAppetit(List<Integer> bill, int k, int b) {
        int sum = 0;
        for (int i = 0; i < bill.size(); i++) {
            if (i != k) {
                sum += bill.get(i);
            }
        }
        int price = sum / 2;

        if (price == b) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(b - price);
        }
    }
}
