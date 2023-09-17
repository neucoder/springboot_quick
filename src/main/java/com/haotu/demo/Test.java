package com.haotu.demo;

import com.google.common.base.Preconditions;

import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("hello");
        String s = optional.get();
        System.out.println(optional.orElse("world"));
        Preconditions.checkNotNull(null, "null object");
    }
}
