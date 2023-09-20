package com.haotu.concurrent;

import javax.script.ScriptException;

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class ExceptionDemo {
    public static void main(String[] args) throws ScriptException {
        Object stu = new Student("张三");
        System.out.println(((Student)stu).getName());
        Class<?> aClass = stu.getClass();

    }
}
