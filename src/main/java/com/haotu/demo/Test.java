package com.haotu.demo;

import com.google.common.base.Preconditions;
import java.util.Optional;

public class Test {

     class User{
        String name;
    }

    static class Student {
         String name;
    }
    public static void main(String[] args) {
        User user = new Test().new User();
        user.name = "hello";
        System.out.println(user.name);

        Student student = new Student();
        student.name = "hello";
        System.out.println(student.name);

        Optional<String> optional = Optional.of("hello");
        String s = optional.get();
        System.out.println(optional.orElse("world"));
        Preconditions.checkNotNull(null, "null object");
    }
}
