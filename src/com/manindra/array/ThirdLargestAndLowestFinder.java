package com.manindra.array;

public class ThirdLargestAndLowestFinder {

    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1, 50};

        int thirdLargest = findThirdLargest(arr);
        int thirdLowest = findThirdLowest(arr);

        if (thirdLargest != Integer.MIN_VALUE) {
            System.out.println("Third Largest: " + thirdLargest);
        } else {
            System.out.println("No third largest element found.");
        }

        if (thirdLowest != Integer.MAX_VALUE) {
            System.out.println("Third Lowest: " + thirdLowest);
        } else {
            System.out.println("No third lowest element found.");
        }
    }

    public static int findThirdLargest(int[] arr) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second && num < first) {
                third = second;
                second = num;
            } else if (num > third && num < second) {
                third = num;
            }
        }

        return third;
    }

    public static int findThirdLowest(int[] arr) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        int third = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num < first) {
                third = second;
                second = first;
                first = num;
            } else if (num < second && num > first) {
                third = second;
                second = num;
            } else if (num < third && num > second) {
                third = num;
            }
        }

        return third;
    }
}

