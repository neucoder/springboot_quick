package com.haotu.designpattern.creational.patterns.factory;

/**
 * 工厂方法模式
 * 定义一个创建对象的接口，让子类决定实例化哪一个类。
 */
abstract class baseFactory {
    abstract public Pizza createProduct();
}

class CheesePizzaFactory extends baseFactory {
    @Override
    public Pizza createProduct() {
        return new CheesePizza();
    }
}

class GreekPizzaFactory extends baseFactory {
    @Override
    public Pizza createProduct() {
        return new GreekPizza();
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        baseFactory factory = new CheesePizzaFactory();
        Pizza pizza = factory.createProduct();
        pizza.prepare();
        baseFactory factory1 = new GreekPizzaFactory();
        Pizza pizza1 = factory1.createProduct();
        pizza1.prepare();
    }
}
