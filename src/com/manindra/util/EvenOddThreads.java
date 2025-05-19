package com.manindra.util;



public class EvenOddThreads {

    public static void main(String[] args) {
        final int limit = 10; // Set the limit for numbers to print
        EvenOddPrinter printer = new EvenOddPrinter(limit);

        Thread oddThread = new Thread(printer::printOdd, "OddThread");
        Thread evenThread = new Thread(printer::printEven, "EvenThread");

        oddThread.start();
        evenThread.start();
    }

    static class EvenOddPrinter {
        private final int limit;
        private int number = 1;
        private boolean isOddTurn = true;

        public EvenOddPrinter(int limit) {
            this.limit = limit;
        }

        public synchronized void printOdd() {
            while (number <= limit) {
                while (!isOddTurn) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (number <= limit) {
                    System.out.println("Odd: " + number);
                    number++;
                    isOddTurn = false;
                    notify();
                }
            }
        }

        public synchronized void printEven() {
            while (number <= limit) {
                while (isOddTurn) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                if (number <= limit) {
                    System.out.println("Even: " + number);
                    number++;
                    isOddTurn = true;
                    notify();
                }
            }
        }
    }
}

