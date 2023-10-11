package com.haotu.concurrent.basic;


//volatile 关键字，可见性的例子
public class VolatileDemo {

    //private static boolean stop = false;
    private static volatile boolean stop = false;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (!stop) {
            }
            System.out.println("Thread name: " + Thread.currentThread().getName() + " stopped");
        });
        thread.start();
        try {
            Thread.sleep(1000);
            System.out.println("Main thread name: " + Thread.currentThread().getName() + "after 1 second");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stop = true;
        System.out.println("Hello World!");

    }
}
