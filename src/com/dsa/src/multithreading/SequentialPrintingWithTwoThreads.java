package com.dsa.src.multithreading;

public class SequentialPrintingWithTwoThreads {

    public static final Object lock = new Object();
    public static boolean isFirstThreadTurn = true;

    public static void main(String[] args) {
        char[] firstThreadChars = {'A', 'B', 'C', 'D', 'E'};
        int[] secondThreadNumbers = {1, 2, 3, 4, 5};

        Thread t1 = new Thread(() -> {
           for(char c: firstThreadChars){
                synchronized (lock) {
                     while (!isFirstThreadTurn) {
                          try {
                            lock.wait(); // Wait for the second thread to finish
                          } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                          }
                     }
                     System.out.print(c + " ");
                     isFirstThreadTurn = false; // Switch turn to second thread
                     lock.notifyAll(); // Notify the second thread
                }
            }
        });

       Thread t2 = new Thread(() -> {
         for(int i: secondThreadNumbers){
                synchronized (lock) {
                     while (isFirstThreadTurn) {
                          try {
                            lock.wait(); // Wait for the first thread to finish
                          } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                          }
                     }
                     System.out.print(i + " ");
                     isFirstThreadTurn = true; // Switch turn to first thread
                     lock.notifyAll(); // Notify the first thread
                }
            }
       });

       t1.start();
       t2.start();
         
    }


}
