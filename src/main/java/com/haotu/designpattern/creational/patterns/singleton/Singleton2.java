package com.haotu.designpattern.creational.patterns.singleton;

/**
 * 懒汉式（线程不安全）
 * 优点：起到了Lazy Loading的效果，但是只能在单线程下使用
 * 缺点：如果在多线程下，一个线程进入了if (instance == null)判断语句块，还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例。
 */
public class Singleton2 {
    public static Singleton2 instance;

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
