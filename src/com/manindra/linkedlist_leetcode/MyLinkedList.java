package com.manindra.linkedlist_leetcode;

public class MyLinkedList { //

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2); // List becomes 1->2->3
        System.out.println(list.get(1)); // Output: 2
        list.deleteAtIndex(1); // Now the list is 1->3
        System.out.println(list.get(1)); // Output: 3
    }

    private Node head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node curr = head;
        for (int i = 0; i < index; i++) curr = curr.next;
        return curr.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
    }

    public void addAtTail(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
        } else {
            Node curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = node;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) return;
        if (index == 0) {
            addAtHead(val);
        } else {
            Node node = new Node(val);
            Node curr = head;
            for (int i = 0; i < index - 1; i++) curr = curr.next;
            node.next = curr.next;
            curr.next = node;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0) {
            head = head.next;
        } else {
            Node curr = head;
            for (int i = 0; i < index - 1; i++) curr = curr.next;
            curr.next = curr.next.next;
        }
        size--;
    }

    private class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }
}

