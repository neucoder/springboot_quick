package com.haotu.designpattern.creational.patterns.singleton;

/**
 * 静态内部类实现单例模式
 * jvm保证单例
 */
public class Singleton5 {
    private Singleton5() {
    }

    private static class SingletonHolder {
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
