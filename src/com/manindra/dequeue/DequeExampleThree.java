package com.manindra.dequeue;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DequeExampleThree {

    public static void main(String[] args) {

        exampleOne();
        exampleTwo();//function do not through exception
        exampleThree();//function that through exception

    }

    static void exampleOne() {

        Deque<Integer> d = new LinkedList<>();

        d.addFirst(10);
        d.addFirst(5);
        d.addFirst(15);
        d.addFirst(20);

        System.out.println(d);
        System.out.println();

        Iterator<Integer> itr = d.descendingIterator();
        while (itr.hasNext())
            System.out.println(itr.next());

    }

    static void exampleTwo() {

        Deque<Integer> deque = new LinkedList<>();
        //add element to front of queue
        deque.offerFirst(10);
        //add element to end of the deque
        deque.offerLast(20);
        //retrieve the head element
        System.out.println(deque.peekFirst());
        //retrieve the tail element
        System.out.println(deque.peekLast());
        //retrieve and remove the head element
        deque.pollFirst();
        //retrieve and remove the last element
        deque.pollLast();
    }

    static void exampleThree() {

        Deque<Integer> deque = new LinkedList<>();

        deque.addFirst(10);
        deque.addFirst(10);
        deque.addLast(21);
        deque.addLast(12);
        System.out.println(" get first " + deque.getFirst());
        System.out.println(" get last  " + deque.getLast());

        //traversal using iterator
        Iterator<Integer> itr = deque.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
        //traversal using for each
        for (int key : deque)
            System.out.print(key + " ");
    }
}
