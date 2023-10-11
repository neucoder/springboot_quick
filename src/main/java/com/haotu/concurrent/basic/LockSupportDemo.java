package com.haotu.concurrent.basic;

import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

//lock support 实现线程同步更加灵活
class MyThread1 extends Thread {
    private Object object;

    public MyThread1(Object object) {
        this.object = object;
    }

    public void run() {
        System.out.println("before unpark");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 获取blocker
        System.out.println("Blocker info " + LockSupport.getBlocker((Thread) object));
        // 释放许可
        LockSupport.unpark((Thread) object);

        // 再次获取blocker
        System.out.println("Blocker info " + LockSupport.getBlocker((Thread) object));

        System.out.println("after unpark");
    }
}

class test {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1(Thread.currentThread());
        myThread1.start();
        System.out.println("before park");
        // 休眠500ms，保证先执行park中的setBlocker(t, null);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 获取许可
        LockSupport.park("ParkAndUnparkDemo");
        System.out.println("after park");
    }
}
class MyThreadInterrupt extends Thread {
    private Object object;

    public MyThreadInterrupt(Object object) {
        this.object = object;
    }

    public void run() {
        System.out.println("before interrupt");
        try {
            // 休眠3s
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread = (Thread) object;
        // 中断线程
        thread.interrupt();
        System.out.println("after interrupt");
    }
}

class InterruptDemo {
    public static void main(String[] args) {
        MyThreadInterrupt myThread = new MyThreadInterrupt(Thread.currentThread());
        myThread.start();
        System.out.println("before park");
        // 获取许可
        LockSupport.park("ParkAndUnparkDemo");
        System.out.println("after park");
    }
}


//lockspport.park 不会释放锁例子

class LockExample {

    private Lock lock = new ReentrantLock();

    public void func() {
        lock.lock();
        try {
            // 获得锁后处理任务
            System.out.println("当前线程"+Thread.currentThread().getName()+"获取到了锁");

            LockSupport.park();
            // park不会释放锁

            System.out.println("线程"+Thread.currentThread().getName()+"被唤醒");
        } finally {
            lock.unlock(); // 需要在finally中手动释放锁
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LockExample example = new LockExample();

        Thread t1 = new Thread(() -> example.func(),"Thread-1");
        t1.start();

        // Thread-1获得了锁,然后park,没有释放锁


        Thread t2 = new Thread(() -> example.func(),"Thread-2");
        t2.start();
        // Thread-2因得到不到锁被阻塞
        Thread.sleep(1000);
        LockSupport.unpark(t1);
        // 最后通过unpark唤醒Thread-1,使其释放锁,Thread-2才能继续执行
        Thread.sleep(1000);
        LockSupport.unpark(t2);

    }
}
public class LockSupportDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        final long N = 10_0000_0000L;
        double sum = 0;
        long start = System.currentTimeMillis();
        for (long i = 0; i < N; i++) {
            sum += i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum: " + sum + " time: " + (end - start));
    }
}
