package com.haotu.guava.demo;

import com.google.common.collect.HashMultiset;
import org.testng.annotations.Test;

public class MultisetTest {
    @Test
    public void testMultiset() {
        HashMultiset<String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("b");
        multiset.add("a");
        multiset.add("c");
        multiset.add("a");
        multiset.add("b");
        int a = 12;
        int b = 12;
        if (a >= b) {
            System.out.println("a >= b");
        } else if (a < b) {
            System.out.println("a < b");
        }
        System.out.println(a);
        System.out.println("testMultiset");
    }
}
