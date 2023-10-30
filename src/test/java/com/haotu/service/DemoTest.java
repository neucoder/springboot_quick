package com.haotu.service;

class TestA {

    private int foo() {
        System.out.println("foo");
        return 1;
    }

    public int bar() {
        return foo();
    }
}

class TestB extends TestA {

    private int foo() {
        System.out.println("foo");
        return 2;
    }

    public int bar() {
        return foo();
    }
}

public class DemoTest {
    public static void main(String[] args) {
        TestA a = new TestA();
        System.out.println(a.bar());
        TestB b = new TestB();
        System.out.println(b.bar());
    }
}
