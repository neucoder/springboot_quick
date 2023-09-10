package com.haotu.designpattern.structural.pattrens.bridge;


// 抽象颜色类
abstract class Color {
    abstract public void fill();
}

// 红色颜色扩展类
class Red extends Color {

    @Override
    public void fill() {
        // 红色填充逻辑
        System.out.println("红色填充");
    }

}

// 蓝色颜色扩展类
class Blue extends Color {

    @Override
    public void fill() {
        // 蓝色填充逻辑
        System.out.println("蓝色填充");
    }
}

// 抽象形状类
abstract class Shape {
    // 对实现颜色的对象进行组合
    protected Color color;

    // 构造函数
    public Shape(Color color) {
        this.color = color;
    }

    abstract public void draw(); // 绘制方法
}

// 扩展了抽象形状类的实体形状类
class Circle extends Shape {

    private int radius;

    public Circle(Color color, int radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public void draw() {
        // 绘制圆形逻辑
        color.fill(); // 使用颜色填充
        System.out.println("绘制圆形");
        System.out.println("半径：" + radius);
        // split line
        System.out.println("----------------------------------");
    }
}

class Square extends Shape {

    private int side;

    public Square(Color color, int side) {
        super(color);
        this.side = side;
    }

    @Override
    public void draw() {
        // 绘制正方形逻辑
        color.fill();
        System.out.println("绘制正方形");
        System.out.println("边长：" + side);
        System.out.println("----------------------------------");
    }
}

public class BridgePattern {
    public static void main(String[] args) {
        Shape redCircle = new Circle(new Red(), 10);
        Shape blueCircle = new Circle(new Blue(), 10);
        Shape redSquare = new Square(new Red(), 10);
        Shape blueSquare = new Square(new Blue(), 10);

        redCircle.draw();
        blueCircle.draw();
        redSquare.draw();
        blueSquare.draw();
    }
}
