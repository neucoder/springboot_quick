package com.haotu.designpattern.creational.patterns.singleton;

/**
 * 枚举实现单例模式
 */
enum Singlenton {
    INSTANCE;
    public void whateverMethod() {
        System.out.println("whateverMethod");
    }
}

public class Singleton6 {
    public static void main(String[] args) {
        Singlenton.INSTANCE.whateverMethod();
        System.out.println(Singlenton.INSTANCE);
    }
}
