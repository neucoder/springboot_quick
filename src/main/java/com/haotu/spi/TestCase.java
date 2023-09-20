package com.haotu.spi;

import java.util.ServiceLoader;

public class TestCase {
    public static void main(String[] args) {
        ServiceLoader.load(Search.class).forEach(search -> {
            search.searchDoc("hello");
        });
    }
}

