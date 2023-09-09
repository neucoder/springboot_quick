package com.haotu.designpattern.singleton;

import com.haotu.designpattern.creational.patterns.singleton.Singleton1;
import org.junit.jupiter.api.Test;

import static org.testng.Assert.*;

public class Singleton1Test {

    @Test
    public void testGetInstance() {
        Singleton1 instance = Singleton1.getInstance();
        assertNotNull(instance);
        System.out.println(instance);
        // sum from 1 to 100
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println(sum);

    }

}