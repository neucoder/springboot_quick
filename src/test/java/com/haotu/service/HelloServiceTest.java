package com.haotu.service;

import com.haotu.BaseTestNg;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

public class HelloServiceTest extends BaseTestNg {
    @Resource
    private HelloService helloService;

    @Test
    public void testHello() {
        System.out.println(helloService.hello());
    }
}
