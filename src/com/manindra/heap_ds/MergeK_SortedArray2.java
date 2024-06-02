package com.manindra.heap_ds;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeK_SortedArray2 {

    public static void main(String[] args) {

        // Initialize the list of sorted lists
        List<List<Integer>> listOfLists = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        list1.add(10);
        list1.add(20);
        list1.add(30);

        List<Integer> list2 = new ArrayList<>();
        list2.add(5);
        list2.add(15);

        List<Integer> list3 = new ArrayList<>();
        list3.add(1);
        list3.add(9);
        list3.add(11);
        list3.add(18);

        // Add the individual lists to the main list
        listOfLists.add(list1);
        listOfLists.add(list2);
        listOfLists.add(list3);

        // Print the merged list
        System.out.println("Merged List: " + mergeKSortedLists(listOfLists));
    }

    // Method to merge k sorted lists
    static List<Integer> mergeKSortedLists(List<List<Integer>> lists) {
        List<Integer> mergedList = new ArrayList<>();
        PriorityQueue<Triplet> priorityQueue = new PriorityQueue<>();

        // Add the first element of each list to the priority queue
        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).isEmpty()) {
                priorityQueue.add(new Triplet(lists.get(i).get(0), i, 0));
            }
        }

        // Process the priority queue until it is empty
        while (!priorityQueue.isEmpty()) {
            Triplet currentTriplet = priorityQueue.poll();
            mergedList.add(currentTriplet.value);
            int listIndex = currentTriplet.listIndex;
            int elementIndex = currentTriplet.elementIndex;

            // Add the next element from the same list to the priority queue
            if (elementIndex + 1 < lists.get(listIndex).size()) {
                priorityQueue.add(new Triplet(lists.get(listIndex).get(elementIndex + 1), listIndex, elementIndex + 1));
            }
        }

        return mergedList;
    }

    // Helper class to represent an element in the priority queue
    static class Triplet implements Comparable<Triplet> {
        int value;
        int listIndex;
        int elementIndex;

        Triplet(int value, int listIndex, int elementIndex) {
            this.value = value;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }

        /*public int compareTo(Triplet t){
            if (value<=t.value)
                return -1;
            else
                return 1;
        }
*/
        @Override
        public int compareTo(Triplet other) {
            return Integer.compare(this.value, other.value);
        }
    }
}
