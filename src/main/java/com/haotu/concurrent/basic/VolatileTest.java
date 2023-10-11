package com.haotu.concurrent.basic;

class VolatileTest01 {
    volatile int i;

    public void addI(){
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        final  VolatileTest01 test01 = new VolatileTest01();
        for (int n = 0; n < 1000; n++) {
            new Thread(() -> {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test01.addI();
            }).start();
        }
        Thread.sleep(2000);//等待10秒，保证上面程序执行完成
        System.out.println(test01.i);
    }
}
class MyThread extends Thread {

    public void run() {
        synchronized (this) {
            System.out.println("before notify");
            notify();
            System.out.println("after notify");
        }
    }
}
// wait notify 使用方法
class WaitAndNotifyDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread1 = new MyThread();
        synchronized (myThread1) {
            try {
                myThread1.start();
                // 主线程睡眠3s
                Thread.sleep(1000);
                System.out.println("before wait");
                // 阻塞主线程
                myThread1.wait();
                System.out.println("after wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class VolatileTest {
}
