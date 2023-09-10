package com.haotu.designpattern.structural.pattrens.decorator;

abstract class Food {
    private String desc;
    private double price;
    public Food() {}
    public Food(String desc, double price) {
        this.desc = desc;
        this.price = price;
    }
    public abstract double cost();
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Noodles extends Food {

    public Noodles() {
    }
    public Noodles(String desc, double price) {
        super(desc, price);
    }
    public double cost() {
        return super.getPrice();
    }
}

class ChineseNoodles extends Noodles {
    public ChineseNoodles() {
        super("中国面", 12.5);
    }

}

class Decorator extends Food {
    private Food food;
    public Decorator(Food food) {
        this.food = food;
    }
    public double cost() {
        System.out.println(food.getDesc() + "price:" + food.getPrice()
                + "\n配料如下：" + super.getDesc() + "price:" + super.getPrice());
        return super.getPrice() + food.cost();
    }
}

class Cumin extends Decorator {
    public Cumin(Food food) {
        super(food);
        super.setDesc("孜然");
        super.setPrice(1.5);
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        Food food = new ChineseNoodles();
        food = new Cumin(food);
        System.out.println(food.cost());
    }
}
