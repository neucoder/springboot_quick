package com.haotu.concurrent.basic;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorExample {

    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        // Schedule a task to run every 5 seconds
        executor.scheduleAtFixedRate(() -> {
            System.out.println("Periodic task executed");
        }, 0, 5, TimeUnit.SECONDS);

        // Schedule a delayed task
        executor.schedule(() -> {
            System.out.println("Delayed task executed");
        }, 5, TimeUnit.SECONDS);

    }

}
