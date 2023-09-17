package com.haotu.concurrent;

public class Demo {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("thread id: " + Thread.currentThread().getId())).start();

    }
}
