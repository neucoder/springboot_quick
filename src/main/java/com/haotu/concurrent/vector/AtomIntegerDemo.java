package com.haotu.concurrent.vector;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomIntegerDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        atomicInteger.getAndIncrement();
        System.out.println(atomicInteger.get());
        atomicInteger.getAndDecrement();
        System.out.println(atomicInteger.get());

        ThreadLocal<Object> threadlocal = new ThreadLocal<>();
        threadlocal.set("hello");
        System.out.println(threadlocal.get());
    }
}
