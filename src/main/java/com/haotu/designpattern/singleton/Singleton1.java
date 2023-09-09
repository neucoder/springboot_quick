package com.haotu.designpattern.singleton;

/**
 * 静态常量实现单例模式
 * 优点：写法简单，在类装载的时候就完成实例化，避免了线程同步问题
 * 线程安全
 */
public class Singleton1 {
    private static Singleton1 instance = new Singleton1();
    private Singleton1() {}

    public static Singleton1 getInstance() {
        return instance;
    }

}
