package com.haotu.demo;

import java.util.ArrayList;
import java.util.List;

interface myInterface {
    void print();
}
public class GenericMethod {

    public static <T> void process(T t) {
        if (t instanceof Integer) {
            Integer i = (Integer) t;
            System.out.println("Integer value = " + i);
        } else if (t instanceof String) {
            String s = (String) t;
            System.out.println("String value = " + s);
        } else {
            System.out.println("Unknown type");
        }
    }

    public static void main(String[] args) {
        process(10);
        process("Hello");
        process(10.5);
        List<String> lists = new ArrayList<String>(){{
            add("abc");
            add("def");
        }};
        System.out.println(lists);
        ((myInterface) () -> System.out.println("hello")).print();
        int a = 1_0000_0000;
        int b = 3_4_5;
        System.out.println(a + b);

    }

}
