package com.haotu.service;

class Point {
    private int x;
    private int y;

    public Point() {
        this.x = 0;
        this.y = 0;
    }

    public Point(int x, int y) {
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

    public String toString() {
        return "Point(" + x + ", " + y + ")";
    }
}
public class ExampleService {
    private int add(int a, int b) {
        return a + b;
    }

    private Point addPoint(Point a, Point b) {
        return new Point(a.getX() + b.getX(), a.getY() + b.getY());
    }

    public Point add2(Point a, Point b) {
        return addPoint(a, b);
    }

    public int add_int(int a, int b) {
        return add(a, b);
    }
}
