package com.manindra.dequeue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDSWithMinAndMax {

    public static void main(String[] args) {
        MyDs myDs = new MyDs();

        // Insert some elements
        myDs.insertMin(5);
        myDs.insertMax(10);
        myDs.insertMin(3);
        myDs.insertMax(7);

        // Get and print minimum and maximum values
        System.out.println("Minimum value: " + myDs.getMin()); // Expected output: 3
        System.out.println("Maximum value: " + myDs.getMax()); // Expected output: 7

        // Extract and print minimum and maximum values
        System.out.println("Extracted minimum value: " + myDs.extractMin()); // Expected output: 3
        System.out.println("Extracted maximum value: " + myDs.extractMax()); // Expected output: 7

        // Get and print minimum and maximum values after extraction
        System.out.println("Minimum value after extraction: " + myDs.getMin()); // Expected output: 5
        System.out.println("Maximum value after extraction: " + myDs.getMax()); // Expected output: 10
    }


    static class MyDs{

        Deque<Integer> deque;

        MyDs(){
            deque=new ArrayDeque<>();
        }

        void insertMin(int x){
            deque.offerFirst(x);
        }
        void insertMax(int x){
            deque.offerLast(x);
        }
        int getMin(){
            return deque.peekFirst();
        }
        int getMax(){
            return deque.peekLast();
        }
        int extractMin(){
            return deque.pollFirst();
        }
        int extractMax(){
            return deque.pollLast();
        }
    }
}
