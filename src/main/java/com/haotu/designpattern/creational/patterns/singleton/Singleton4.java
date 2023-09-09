package com.haotu.designpattern.creational.patterns.singleton;

/**
 * 双重检查
 * 推荐使用，线程安全，延迟加载，效率较高
 */
public class Singleton4 {
    private static volatile Singleton4 instance;
    private Singleton4() {}
    public static Singleton4 getInstance() {
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    // 1. 分配内存给这个对象
                    // 2. 初始化对象
                    // 3. 设置instance指向刚分配的内存地址
                    // 4. 用户初次访问对象
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
