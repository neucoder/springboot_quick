package com.haotu.concurrent.basic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {


    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread 1 start");
                latch.countDown();
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread 2 start");
                latch.countDown();
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread 3 start");
                latch.countDown();
            }
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread end");
        executorService.shutdown();
    }
}
