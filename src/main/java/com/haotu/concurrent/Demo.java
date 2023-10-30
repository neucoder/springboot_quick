package com.haotu.concurrent;

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
        Double s = 0.0;
        long N = 100_0000L;
        for (int i = 0; i < N; i++) {
            s += i * i;
        }
        System.out.println("s = " + s);
    }
}
