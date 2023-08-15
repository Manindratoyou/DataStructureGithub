package com.manindra.corejava;

public class SynchronizationExampleTwo {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedResource.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                sharedResource.decrement();
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + sharedResource.getCount());
    }
}

class SharedResource {
    private int count = 0;

    public synchronized void increment() {
        count++;
        System.out.println("Incremented: " + count);
    }

    public synchronized void decrement() {
        count--;
        System.out.println("Decremented: " + count);
    }

    public int getCount() {
        return count;
    }
}

