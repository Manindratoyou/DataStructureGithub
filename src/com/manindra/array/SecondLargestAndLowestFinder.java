package com.manindra.array;

public class SecondLargestAndLowestFinder {

    public static void main(String[] args) {

        int[] arr = {12, 35, 1, 10, 34, 1};

        int secondLargest = findSecondLargest(arr);
        int secondLowest = findSecondLowest(arr);

        if (secondLargest != Integer.MIN_VALUE) {
            System.out.println("Second Largest: " + secondLargest);
        } else {
            System.out.println("No second largest element found.");
        }

        if (secondLowest != Integer.MAX_VALUE) {
            System.out.println("Second Lowest: " + secondLowest);
        } else {
            System.out.println("No second lowest element found.");
        }
    }

    public static int findSecondLargest(int[] arr) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num < first) {
                second = num;
            }
        }

        return second;
    }

    public static int findSecondLowest(int[] arr) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < first) {
                second = first;
                first = num;
            } else if (num < second && num > first) {
                second = num;
            }
        }

        return second;
    }
}

