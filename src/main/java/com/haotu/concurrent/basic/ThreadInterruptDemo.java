package com.haotu.concurrent.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadInterruptDemo {
    public static void main(String[] args) {
        //time sleep interrupt
        Thread thread = new Thread(()->{
            try {
                System.out.println("Thread name: " + Thread.currentThread().getName());
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread.interrupt();
        System.out.println("Main thread name: " + Thread.currentThread().getName());
        System.out.println("==========================================");
        //while interrupt
        Thread thread1 = new Thread(()->{
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Thread name: " + Thread.currentThread().getName());
                    System.out.println("Thread is interrupted!");
                    break;
                }
            }
        });

        thread1.start();
        thread1.interrupt();
        System.out.println("Main thread name: " + Thread.currentThread().getName());


        //executors interrupt
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdownNow();
        System.out.println("Main run");

        //Executor 中断一个线程
        Future<?> future = executorService.submit(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        future.cancel(true);

    }
}
