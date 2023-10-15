package com.haotu.concurrent;

import java.util.concurrent.ThreadPoolExecutor;

class A {
    int a;
}

class B extends A {
    int b;

    public B() {
        a = 1;
        b = 2;
    }
}

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello World!");
        new ThreadPoolExecutor(1, 1, 1, null, null);

    }
}
