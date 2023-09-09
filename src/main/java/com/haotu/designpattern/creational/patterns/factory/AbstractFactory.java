package com.haotu.designpattern.creational.patterns.factory;


/**
 * 抽象工厂模式
 * 用于创建相关或者依赖关系的对象簇，而无需指明具体对象类。
 */

class BeiJingCheesePizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("北京cheese披萨准备原材料");
    }
}

class BeiJingGreekPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("北京greek披萨准备原材料");
    }
}

class LondonGreekPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("伦敦greek披萨准备原材料");
    }
}

class LondonCheesePizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("伦敦cheese披萨准备原材料");
    }
}

interface BasePizzaFactory {
    Pizza createPizza(String type);
}

class BeiJingPizzaFactory implements BasePizzaFactory {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new BeiJingCheesePizza();
        } else if (type.equals("greek")) {
            pizza = new BeiJingGreekPizza();
        }
        return pizza;
    }
}

class LondonPizzaFactory implements BasePizzaFactory {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if (type.equals("cheese")) {
            pizza = new LondonCheesePizza();
        } else if (type.equals("greek")) {
            pizza = new LondonGreekPizza();
        }
        return pizza;
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        BasePizzaFactory basePizzaFactory = new BeiJingPizzaFactory();
        Pizza pizza = basePizzaFactory.createPizza("cheese");
        pizza.prepare();
        BasePizzaFactory basePizzaFactory1 = new LondonPizzaFactory();
        Pizza pizza1 = basePizzaFactory1.createPizza("greek");
        pizza1.prepare();
    }
}
