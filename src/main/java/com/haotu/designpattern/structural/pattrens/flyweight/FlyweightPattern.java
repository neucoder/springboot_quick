package com.haotu.designpattern.structural.pattrens.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式
 * 用棋子的例子说明享元模式
 */

class Position {
    int x, y; // 棋子所在的坐标

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

//抽象享元类
abstract class ChessPiece {

    private String color; //内蕴状态:颜色

    public ChessPiece(String color) {
        this.color = color;
    }

    public abstract void display(); //显示棋子
    public abstract void display(Position position);

    public String getColor() {
        return color;
    }
}

//白棋实现类
class WhiteChessPiece extends ChessPiece {

    public WhiteChessPiece() {
        super("白色");
    }

    @Override
    public void display() {
        System.out.print("○\n");
    }

    @Override
    public void display(Position position) {
        System.out.println("白棋位置：(" + position.getX() + ", " + position.getY() + ")");
    }

}

//黑棋实现类
class BlackChessPiece extends ChessPiece {

    public BlackChessPiece() {
        super("黑色");
    }

    @Override
    public void display() {
        System.out.println("●");
    }

    @Override
    public void display(Position position) {
        System.out.println("黑棋位置：(" + position.getX() + ", " + position.getY() + ")");
    }

}


class ChessPieceFactory {

    private static final Map<String, ChessPiece> pieces = new HashMap<>();

    public static ChessPiece getPiece(String color) {
        if(!pieces.containsKey(color)) {
            if(color.equals("白色")) {
                pieces.put(color, new WhiteChessPiece());
            } else {
                pieces.put(color, new BlackChessPiece());
            }
        }
        return pieces.get(color);
    }

}


public class FlyweightPattern {
    public static void main(String[] args) {
        ChessPiece white1 = ChessPieceFactory.getPiece("白色");
        ChessPiece white2 = ChessPieceFactory.getPiece("白色");
        ChessPiece black1 = ChessPieceFactory.getPiece("黑色");
        ChessPiece black2 = ChessPieceFactory.getPiece("黑色");
        System.out.println("white1 == white2 ? " + (white1 == white2));
        System.out.println("black1 == black2 ? " + (black1 == black2));
        white1.display();
        white1.display(new Position(1, 2));
        black1.display();
        black1.display(new Position(3, 4));
        System.out.println("享元模式");
    }
}
