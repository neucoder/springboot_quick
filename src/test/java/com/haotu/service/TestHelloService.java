package com.haotu.service;

import com.haotu.BaseTestNg;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

public class TestHelloService extends BaseTestNg {
    @Resource(name = "helloServiceImpl")
    private HelloService helloService;

    @Test
    public void testSayHello() {
        helloService.sayHello();
    }
}
