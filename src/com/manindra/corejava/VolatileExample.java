package com.manindra.corejava;

public class VolatileExample {

    // A shared resource class
    static class SharedResource {
        // A flag that will be shared between threads
        private volatile boolean flag = false; // volatile keyword to solve visibility problem

        public  void  setFlag(boolean flag) {  // we can use  synchronized also here
            this.flag = flag;
        }

        public boolean getFlag() { // we can use  synchronized also here
            return flag;
        }
    }

    public static void main(String[] args) throws Exception {
        // Create an instance of the shared resource
        SharedResource sharedResource = new SharedResource();

        // -- Thread 1 --
        // This thread will update the flag after a delay.
        new Thread(() -> {
            System.out.println("Thread 1 started");
            try {
                System.out.println("Thread 1 logic started");
                // Simulate some work by sleeping for 1 second
                Thread.sleep(1000);
                System.out.println("Thread 1 logic completed");
                // Set the flag to true
                sharedResource.setFlag(true);
                System.out.println("Flag set by Thread 1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // -- Thread 2 --
        // This thread will wait until the flag becomes true.
        new Thread(() -> {
            System.out.println("Thread 2 started");
            // Loop continuously until the flag value is true
            while (!sharedResource.getFlag()) {
                // This is a busy-wait loop. It consumes CPU cycles while waiting.
            }
            System.out.println("Thread 2 logic completed");
        }).start();
    }
}
