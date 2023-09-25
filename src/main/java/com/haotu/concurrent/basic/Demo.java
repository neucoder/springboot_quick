package com.haotu.concurrent.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 6; i++) {
            executorService.execute(()->{
                System.out.println("Thread name: " + Thread.currentThread().getName());
            });
        }
        System.out.println("Hello World!");
        executorService.shutdown();
    }
}
