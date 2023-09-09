package com.haotu.designpattern.creational.patterns.factory;

import java.util.Calendar;

/**
 * 简单工厂模式
 * 优点：将对象的创建和使用分离，客户端无需知道具体的产品类名，只需要知道参数即可
 */
interface Pizza{
    void prepare();
};

class CheesePizza implements Pizza{
    @Override
    public void prepare() {
        System.out.println("prepare cheese pizza");
    }
}

class GreekPizza implements Pizza{
    @Override
    public void prepare() {
        System.out.println("prepare greek pizza");
    }
}


/**
 * 简单工厂模式实现类
 */
public class SimpleFactory {
    public static Pizza createPizza(String type){
        Pizza pizza = null;
        if(type.equals("cheese")){
            pizza = new CheesePizza();
        }else if(type.equals("greek")){
            pizza = new GreekPizza();
        }
        return pizza;
    }

    public static void main(String[] args) {
        Pizza pizza = SimpleFactory.createPizza("cheese");
        pizza.prepare();
        Pizza pizza1 = SimpleFactory.createPizza("greek");
        pizza1.prepare();
        //jdk canlendar 类中的工程模式
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.getTime().toLocaleString());
    }
}
