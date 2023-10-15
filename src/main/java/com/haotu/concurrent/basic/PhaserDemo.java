package com.haotu.concurrent.basic;

import java.util.concurrent.Phaser;


public class PhaserDemo {

    public static void main(String[] args) {
        // 创建一个 Phaser 对象，并指定阶段数为 2
        Phaser phaser = new Phaser(2);

        // 创建两个线程
        Thread thread1 = new Thread(() -> {
            // 线程1执行阶段 1 的任务
            for (int i = 0; i < 10; i++) {
                System.out.println("thread1: " + i);
            }
            System.out.println("get current phase:" + phaser.getPhase());
            // 线程1到达阶段 1
            phaser.arriveAndAwaitAdvance();

            // 线程1执行阶段 2 的任务
            for (int i = 11; i < 20; i++) {
                System.out.println("thread1: " + i);
            }
            System.out.println("get current phase:" + phaser.getPhase());
            // 线程1到达阶段 2
            phaser.arriveAndAwaitAdvance();
        });

        Thread thread2 = new Thread(() -> {
            // 线程2执行阶段 1 的任务
            for (int i = 0; i < 10; i++) {
                System.out.println("thread2: " + i);
            }

            // 线程2到达阶段 1
            phaser.arriveAndAwaitAdvance();

            // 线程2执行阶段 2 的任务
            for (int i = 11; i < 20; i++) {
                System.out.println("thread2: " + i);
            }

            // 线程2到达阶段 2
            phaser.arriveAndAwaitAdvance();
        });

        // 启动两个线程
        thread1.start();
        thread2.start();

        // 等待所有线程都到达阶段 2
        phaser.awaitAdvance(phaser.getPhase());
        System.out.println("get current phase:" + phaser.getPhase());

        // 所有线程都到达阶段 2，继续执行后续操作
        System.out.println("所有线程都到达阶段 2");
    }
}

class PhaserExample {

    public static void main(String[] args) {

        Phaser phaser = new Phaser(2);

        // 创建阶段为0的Phaser,设置主线程和其他线程为参与方

        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1: Phase 1");
            phaser.arriveAndAwaitAdvance(); // 完成阶段1

            System.out.println("Thread 1: Phase 2");
            phaser.arriveAndAwaitAdvance(); // 完成阶段2
            System.out.println("Thread 1: Phase 3");
            phaser.arriveAndAwaitAdvance(); // 完成阶段3
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread 2: Phase 1");
            phaser.arriveAndAwaitAdvance(); // 完成阶段1

            System.out.println("Thread 2: Phase 2");
            phaser.arriveAndAwaitAdvance(); // 完成阶段2
            phaser.arriveAndDeregister();
        });

        t1.start();
        t2.start();

        // 主线程等待其它线程完成前两阶段
        phaser.awaitAdvance(phaser.getPhase());
        System.out.println("Main thread continues...");
    }
}