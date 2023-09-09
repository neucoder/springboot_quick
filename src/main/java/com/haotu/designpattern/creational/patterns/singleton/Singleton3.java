package com.haotu.designpattern.creational.patterns.singleton;

/**
 * 懒汉式，线程安全
 * 效率比较低，每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。
 */
public class Singleton3 {
    private static Singleton3 instance;
    private Singleton3() {}

    public static synchronized Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
