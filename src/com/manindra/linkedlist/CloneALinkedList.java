package com.manindra.linkedlist;

import java.util.HashMap;

public class CloneALinkedList {

        public static void main(String[] args) {
            // Example usage
            NodeNew originalHead = new NodeNew(1);
            originalHead.next = new NodeNew(2);
            originalHead.next.next = new NodeNew(3);
            originalHead.random = originalHead.next.next; // Random pointer of 1 points to 3
            originalHead.next.random = originalHead; // Random pointer of 2 points to 1

            System.out.println("Original Linked List:");
            printLinkedList(originalHead);

            NodeNew clonedHead = clone(originalHead);

            System.out.println("Cloned Linked List:");
            printLinkedList(clonedHead);
        }

        static NodeNew clone(NodeNew originalHead) {
            if (originalHead == null)
                return null;

            HashMap<NodeNew, NodeNew> map = new HashMap<>();

            // Create a deep copy of each node and store mapping of original and cloned nodes
            for (NodeNew current = originalHead; current != null; current = current.next) {
                map.put(current, new NodeNew(current.data));
            }

            // Update next and random pointers of cloned nodes using the mapping
            for (NodeNew current = originalHead; current != null; current = current.next) {
                NodeNew clonedNode = map.get(current);
                clonedNode.next = map.get(current.next);
                clonedNode.random = map.get(current.random);
            }

            return map.get(originalHead); // Return the cloned head
        }

    static NodeNew cloneSolutionTwo(NodeNew originalHead) {
        if (originalHead == null)
            return null;

        // Step 1: Create a copy of each node and insert it after its original node
        NodeNew current = originalHead;
        while (current != null) {
            NodeNew next = current.next;
            current.next = new NodeNew(current.data);
            current.next.next = next;
            current = next;
        }

        // Step 2: Update random pointers of the cloned nodes
        for (current = originalHead; current != null; current = current.next.next) {
            current.next.random = current.random == null ? null : current.random.next;
        }

        // Step 3: Separate the original and cloned lists
        NodeNew clonedHead = originalHead.next;
        NodeNew clone = clonedHead;
        for (current = originalHead; current != null; current = current.next) {
            current.next = current.next.next;
            clone.next = clone.next != null ? clone.next.next : null;
            clone = clone.next;
        }

        return clonedHead;
    }


    static void printLinkedList(NodeNew head) {
            NodeNew temp = head;
            while (temp != null) {
                System.out.print("(" + temp.data + ", ");
                if (temp.random != null)
                    System.out.print(temp.random.data);
                else
                    System.out.print("null");
                System.out.print(") ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    class NodeNew {
        int data;
        NodeNew next, random;

        NodeNew(int data) {
            this.data = data;
            this.next = null;
            this.random = null;
        }
    }


