package com.manindra.corejava;

public class OddEvenPrinter {

    private final int limit = 10;
    private int number = 1;
    private final Object lock = new Object();

    public static void main(String[] args) {

        OddEvenPrinter printer = new OddEvenPrinter();
        Thread odd = new Thread(printer::prinOdd);
        Thread even = new Thread(printer::printEven);
        odd.start();
        even.start();
    }

    public void prinOdd() {
        synchronized (lock) {
            while (number <= limit) {
                if (number % 2 == 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("Odd " + number);
                    number++;
                    lock.notify();
                }

            }
        }
    }

    public void printEven() {
        synchronized (lock) {
            while (number <= limit) {
                if (number % 2 != 0) {
                    try {
                        lock.wait(); // Wait for odd thread to notify
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    System.out.println("Even: " + number);
                    number++;
                    lock.notify(); // Wake up odd thread
                }
            }
        }
    }
}

