package com.haotu.concurrent.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SyncDemo {
    public void func() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        }
    }
}

class LockDemo {
    private final Lock lock = new ReentrantLock();

    public void func() {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.print(i + " ");
            }
        } finally {
            lock.unlock();
        }
    }
}

public class SynchronizedDemo {
    public static void main(String[] args) {
        SyncDemo syncDemo = new SyncDemo();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            syncDemo.func();
            System.out.println();
        });
        executorService.execute(()->{
            syncDemo.func();
            System.out.println();
        });


        SyncDemo syncDemo1 = new SyncDemo();
        SyncDemo syncDemo2 = new SyncDemo();
        executorService.execute(()->{
            syncDemo1.func();
            System.out.println();
        });
        executorService.execute(()->{
            syncDemo2.func();
            System.out.println();
        });
        System.out.println("==========================================");
        LockDemo lockDemo = new LockDemo();
        executorService.execute(()->{
            lockDemo.func();
            System.out.println();
        });
        executorService.shutdown();
    }
}
